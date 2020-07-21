package tiiehenry.script.wrapper

import tiiehenry.script.wrapper.engine.bridge.IFuncBridge
import tiiehenry.script.wrapper.engine.bridge.IVarBridge
import tiiehenry.script.wrapper.engine.evaluate.IEvaluator
import java.io.File
import java.io.Reader

interface IScriptEngine<V, T> {
    val context: IScriptContext

    val funcBridge: IFuncBridge<T>
    val varBridge: IVarBridge<V, T>


    val stringEvaluator: IEvaluator<V, T, String>
    val fileEvaluator: IEvaluator<V, T, File>
    val readerEvaluator: IEvaluator<V, T, Reader>

    fun create()
    fun pause()
    fun resume()
    fun destroy()
}