package tiiehenry.script.engine.android

import android.content.pm.PackageManager
import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*


class ScriptDexLoader(private val scriptContext: ScriptContext<*>) {


    fun loadDexFile(dexFile: File): ScriptDexClassLoader? {
        if (!dexFile.isFile)
            return null
        val path = dexFile.absolutePath
        //path查找
        var dex = scriptDexClassLoaderMap[path]
        if (dex != null)
            return dex
        //md5查找
        dexFile.getMD5().let {
            if (it != "0") {
                val classLoader = scriptDexClassLoaderMap[it]
                if (classLoader != null)
                    return classLoader
            }
        }
        //没找到加载
        dex = ScriptDexClassLoader(path, scriptContext.scriptProvider, scriptContext.getContext().classLoader)
        scriptDexClassLoaderMap[path] = dex
        return dex
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