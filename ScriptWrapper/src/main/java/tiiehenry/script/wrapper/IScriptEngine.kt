package tiiehenry.script.wrapper

import tiiehenry.script.wrapper.engine.bridge.IFuncBridge
import tiiehenry.script.wrapper.engine.bridge.IVarBridge
import tiiehenry.script.wrapper.engine.evaluate.IFileEvaluator
import tiiehenry.script.wrapper.engine.evaluate.IStringEvaluator

interface IScriptEngine<V,T> {

    val context:IScriptContext

    val funcBridge: IFuncBridge<T>
    val varBridge: IVarBridge<V, T>


    val stringEvaluator: IStringEvaluator<V, T>
    val fileEvaluator: IFileEvaluator<V, T>


    fun setBindings(bindings:Map<String,*>)
}