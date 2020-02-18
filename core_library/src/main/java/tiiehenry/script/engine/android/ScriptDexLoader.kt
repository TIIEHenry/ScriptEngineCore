package tiiehenry.script.engine.android

import android.content.pm.PackageManager
import dalvik.system.DexClassLoader
import java.io.File
import java.io.FileNotFoundException
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

open class ScriptDexLoader(private val scriptContext: ScriptContext<*>) : ClassLoader(scriptContext.getContext().classLoader) {

    private val mDexClassLoaders = mutableListOf<DexClassLoader>()

    @Throws(FileNotFoundException::class)
    fun loadDexFile(dexFile: File): ScriptDexClassLoader? {
        if (!dexFile.isFile) {
            throw FileNotFoundException(dexFile.path)
        }
        val path = dexFile.absolutePath
        //path查找
        var loader = scriptDexClassLoaderMap[path]
        if (loader != null)
            return loader
        //md5查找
        dexFile.getMD5().let {
            if (it != "0") {
                val classLoader = scriptDexClassLoaderMap[it]
                if (classLoader != null)
                    return classLoader
            }
        }
        //没找到加载
        loader = ScriptDexClassLoader(path, scriptContext.scriptProvider, parent)
        //        val loader = DexClassLoader(file.path, scriptContext.scriptProvider.getOdexDir(), scriptContext.scriptProvider.getSoDir(), parent)
        scriptDexClassLoaderMap[path] = loader
        mDexClassLoaders.add(loader)
        return loader
    }

    @Throws(ClassNotFoundException::class)
    override fun loadClass(name: String?, resolve: Boolean): Class<*>? {
        var loadedClass = findLoadedClass(name)
        if (loadedClass == null) {
            for (dex in mDexClassLoaders) {
                loadedClass = dex.loadClass(name)
                if (loadedClass != null) {
                    break
                }
            }
            if (loadedClass == null) {
                loadedClass = parent.loadClass(name)
            }
        }
        return loadedClass
    }


    //    加载其他安装的app的dex
    fun loadInstalledApkDex(pkg: String): ScriptDexClassLoader? {
        try {
            var dex = scriptDexClassLoaderMap[pkg]
            if (dex == null) {
                val manager = scriptContext.getContext().packageManager
                val info = manager.getPackageInfo(pkg, 0).applicationInfo
                dex = ScriptDexClassLoader(info.publicSourceDir, scriptContext.scriptProvider, scriptContext.getContext().classLoader)
                scriptDexClassLoaderMap[pkg] = dex
            }
            return dex
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return null
    }

    fun File.getMD5(): String {
        val digest = MessageDigest.getInstance("MD5")
        val bigInt = BigInteger(1, digest.digest(readBytes()))
        return bigInt.toString(16)
    }

    companion object {
        //md5
        private val scriptDexClassLoaderMap = HashMap<String, ScriptDexClassLoader>()
    }
}