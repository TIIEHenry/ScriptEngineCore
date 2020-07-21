package tiiehenry.script.wrapper.engine.bridge

import tiiehenry.script.wrapper.IScriptContext
import tiiehenry.script.wrapper.engine.lang.IFunction

/**
 * T var type
 */
interface IFuncBridge<T/*,S : ScriptEngine*/> : IBridge<IFunction<T>>/*<S>*/ {
    val context: IScriptContext

    override fun get(name: String): IFunction<T>?

    fun set(name: String, function: IFunction<T>?)

    fun callFunc(name: String, vararg args: Any): Any? {
        return get(name)?.call(*args)
    }

    fun callFuncSafely(name: String, vararg args: Any): Any? {
        try {
            return get(name)?.call(*args)
        } catch (e: Exception) {
            context.error.println(e.message)
        }
        return null
    }

}