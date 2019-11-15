package tiiehenry.script.engine.eval

import tiiehenry.script.engine.framework.ScriptEngine

abstract class FuncEvaler<T : ScriptEngine>(override val engine: T) : Evaler(engine), FuncEvalable<T> {

    override fun evalFunc(name: String, vararg args: Any?): Any? {
        return evalFuncL(name, engine.onExceptionListener, args)
    }

    override fun evalVoidFunc(name: String, vararg args: Any?) {
        evalFuncL(name, engine.onExceptionListener, args)
    }

    override fun evalStringFunc(name: String, vararg args: Any?): String? {
        return evalStringFuncL(name, engine.onExceptionListener, args)
    }

    override fun evalIntegerFunc(name: String, vararg args: Any?): Int? {
        return evalIntegerFuncL(name, engine.onExceptionListener, args)
    }

    override fun evalFloatFunc(name: String, vararg args: Any?): Float? {
        return evalDoubleFunc(name, args)?.toFloat()
    }

    override fun evalDoubleFunc(name: String, vararg args: Any?): Double? {
        return evalDoubleFuncL(name, engine.onExceptionListener, args)
    }

    override fun evalBooleanFunc(name: String, vararg args: Any?): Boolean? {
        return evalBooleanFuncL(name, engine.onExceptionListener, args)
    }
}