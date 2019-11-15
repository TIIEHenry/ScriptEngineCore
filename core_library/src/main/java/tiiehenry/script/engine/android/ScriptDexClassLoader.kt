package tiiehenry.script.engine.android

import dalvik.system.DexClassLoader
import tiiehenry.script.engine.framework.ScriptProvider


class ScriptDexClassLoader(val dexPath: String, scriptProvider: ScriptProvider<*>, parent: ClassLoader)
    : DexClassLoader(dexPath, scriptProvider.getOdexDir(), scriptProvider.getNativeLibraryDir(), parent) {
    private val classCache = HashMap<String, Class<*>>()


    @Throws(ClassNotFoundException::class)
    override fun findClass(name: String): Class<*>? {
        var cls = classCache[name]
        if (cls == null) {
            cls = super.findClass(name)
            classCache[name] = cls
        }
        return cls
    }

}