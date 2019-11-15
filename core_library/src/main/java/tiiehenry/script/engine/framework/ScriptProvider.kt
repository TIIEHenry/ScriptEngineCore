package tiiehenry.script.engine.framework

import android.content.Context
import tiiehenry.script.engine.android.ScriptContext

open class ScriptProvider<T : ScriptEngine>(private val scriptContext: ScriptContext<T>) {


    fun getOdexDir(): String {
        return scriptContext.getContext().getDir("odex", Context.MODE_PRIVATE).absolutePath
    }

    fun getSoDir(): String {
        return scriptContext.getContext().getDir("so", Context.MODE_PRIVATE).absolutePath
    }

    fun getNativeLibraryDir(): String {
        return scriptContext.getContext().applicationInfo.nativeLibraryDir
    }

}