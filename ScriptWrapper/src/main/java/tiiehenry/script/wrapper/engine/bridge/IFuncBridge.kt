package tiiehenry.script.wrapper.engine.bridge

import tiiehenry.script.wrapper.engine.lang.IFunction
import tiiehenry.script.wrapper.engine.lang.OnExceptionListener

/**
 * T var type
 */
interface IFuncBridge<T/*,S : ScriptEngine*/> : IBridge/*<S>*/ {
    val onExceptionListener: OnExceptionListener

    fun get(name: String): IFunction<T>

    fun set(name: String, function: IFunction<T>?)

    fun callFunc(name: String, vararg args: Any): Any? {
        return get(name).call(*args)
    }

    fun callVoidFunc(name: String, vararg args: Any) {
        return get(name).callVoid(*args)
    }

    fun callStringFunc(name: String, vararg args: Any): String? {
        return get(name).callString(*args)
    }

    fun callIntegerFunc(name: String, vararg args: Any): Int? {
        return get(name).callInteger(*args)
    }

    fun callFloatFunc(name: String, vararg args: Any): Float? {
        return get(name).callFloat(*args)
    }

    fun callDoubleFunc(name: String, vararg args: Any): Double? {
        return get(name).callDouble(*args)
    }

    fun callBooleanFunc(name: String, vararg args: Any): Boolean? {
        return get(name).callBoolean(*args)
    }

    fun callFuncSafely(name: String, vararg args: Any): Any? {
        try {
            return get(name).call(*args)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun callVoidFuncSafely(name: String, vararg args: Any) {
        try {
            get(name).callVoid(*args)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
    }

    fun callStringFuncSafely(name: String, vararg args: Any): String? {
        try {
            get(name).callString(*args)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun callIntegerFuncSafely(name: String, vararg args: Any): Int? {
        try {
            get(name).callInteger(*args)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun callFloatFuncSafely(name: String, vararg args: Any): Float? {
        try {
            get(name).callFloat(*args)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun callDoubleFuncSafely(name: String, vararg args: Any): Double? {
        try {
            get(name).callDouble(*args)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun callBooleanFuncSafely(name: String, vararg args: Any): Boolean? {
        try {
            get(name).callBoolean(*args)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }


}