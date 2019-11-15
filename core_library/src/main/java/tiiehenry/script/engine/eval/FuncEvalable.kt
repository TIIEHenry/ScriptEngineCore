package tiiehenry.script.engine.eval

import tiiehenry.script.engine.framework.ScriptEngine

interface FuncEvalable<T : ScriptEngine> : Evalable<T> {
    fun evalFunc(name: String, vararg args: Any?): Any?

    fun evalVoidFunc(name: String, vararg args: Any?)

    fun evalStringFunc(name: String, vararg args: Any?): String?

    fun evalIntegerFunc(name: String, vararg args: Any?): Int?

    fun evalFloatFunc(name: String, vararg args: Any?): Float?

    fun evalDoubleFunc(name: String, vararg args: Any?): Double?

    fun evalBooleanFunc(name: String, vararg args: Any?): Boolean?

    fun evalFuncL(name: String, listener: OnExceptionListener, vararg args: Any?): Any?

    fun evalVoidFuncL(name: String, listener: OnExceptionListener, vararg args: Any?)

    fun evalStringFuncL(name: String, listener: OnExceptionListener, vararg args: Any?): String?

    fun evalIntegerFuncL(name: String, listener: OnExceptionListener, vararg args: Any?): Int?

    fun evalFloatFuncL(name: String, listener: OnExceptionListener, vararg args: Any?): Float?

    fun evalDoubleFuncL(name: String, listener: OnExceptionListener, vararg args: Any?): Double?

    fun evalBooleanFuncL(name: String, listener: OnExceptionListener, vararg args: Any?): Boolean?

}
