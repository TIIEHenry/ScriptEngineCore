package tiiehenry.script.wrapper.engine.evaluate

import tiiehenry.script.wrapper.engine.lang.IVariable
import tiiehenry.script.wrapper.engine.lang.OnExceptionListener

interface IStringEvaluator<V, T> : IEvaluator {
    val onExceptionListener: OnExceptionListener

    fun evalString(source: String, scriptName: String? = null, lineNumber: Int = 0): IVariable<V, T>?

    fun evalVoidString(source: String, scriptName: String? = null, lineNumber: Int = 0) {
        evalString(source, scriptName, lineNumber)
    }

    fun evalStringString(source: String, scriptName: String? = null, lineNumber: Int = 0): String? {
        return evalString(source, scriptName, lineNumber)?.getString()
    }

    fun evalIntegerString(source: String, scriptName: String? = null, lineNumber: Int = 0): Int? {
        return evalString(source, scriptName, lineNumber)?.getInteger()
    }

    fun evalFloatString(source: String, scriptName: String? = null, lineNumber: Int = 0): Float? {
        return evalString(source, scriptName, lineNumber)?.getFloat()
    }

    fun evalDoubleString(source: String, scriptName: String? = null, lineNumber: Int = 0): Double? {
        return evalString(source, scriptName, lineNumber)?.getDouble()
    }

    fun evalBooleanString(source: String, scriptName: String? = null, lineNumber: Int = 0): Boolean? {
        return evalString(source, scriptName, lineNumber)?.getBoolean()
    }

    fun evalStringSafely(source: String, scriptName: String? = null, lineNumber: Int = 0): IVariable<V, T>? {
        try {
            return evalString(source, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun evalVoidStringSafely(source: String, scriptName: String? = null, lineNumber: Int = 0) {
        try {
            return evalVoidString(source, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
    }

    fun evalStringStringSafely(source: String, scriptName: String? = null, lineNumber: Int = 0): String? {
        try {
            return evalStringString(source, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun evalIntegerStringSafely(source: String, scriptName: String? = null, lineNumber: Int = 0): Int? {
        try {
            return evalIntegerString(source, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun evalFloatStringSafely(source: String, scriptName: String? = null, lineNumber: Int = 0): Float? {
        try {
            return evalFloatString(source, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun evalDoubleStringSafely(source: String, scriptName: String? = null, lineNumber: Int = 0): Double? {
        try {
            return evalDoubleString(source, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun evalBooleanStringSafely(source: String, scriptName: String? = null, lineNumber: Int = 0): Boolean? {
        try {
            return evalBooleanString(source, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

}