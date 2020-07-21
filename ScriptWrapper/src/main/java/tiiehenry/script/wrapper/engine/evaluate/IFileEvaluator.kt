package tiiehenry.script.wrapper.engine.evaluate

import tiiehenry.script.wrapper.engine.lang.IVariable
import tiiehenry.script.wrapper.engine.lang.OnExceptionListener
import java.io.File

interface IFileEvaluator<V,T>:IEvaluator {
    val onExceptionListener: OnExceptionListener

    fun evalFile(file: File, scriptName: String? = file.name, lineNumber: Int = 0): IVariable<V, T>?

    fun evalVoidFile(file: File, scriptName: String? = file.name, lineNumber: Int = 0) {
        evalFile(file, scriptName, lineNumber)
    }

    fun evalStringFile(file: File, scriptName: String? = file.name, lineNumber: Int = 0): String? {
        return evalFile(file, scriptName, lineNumber)?.getString()
    }

    fun evalIntegerFile(file: File, scriptName: String? = file.name, lineNumber: Int = 0): Int? {
        return evalFile(file, scriptName, lineNumber)?.getInteger()
    }

    fun evalFloatFile(file: File, scriptName: String? = file.name, lineNumber: Int = 0): Float? {
        return evalFile(file, scriptName, lineNumber)?.getFloat()
    }

    fun evalDoubleFile(file: File, scriptName: String? = file.name, lineNumber: Int = 0): Double? {
        return evalFile(file, scriptName, lineNumber)?.getDouble()
    }

    fun evalBooleanFile(file: File, scriptName: String? = file.name, lineNumber: Int = 0): Boolean? {
        return evalFile(file, scriptName, lineNumber)?.getBoolean()
    }

    fun evalStringSafely(file: File, scriptName: String? = file.name, lineNumber: Int = 0): IVariable<V, T>? {
        try {
            return evalFile(file, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun evalVoidStringSafely(file: File, scriptName: String? = file.name, lineNumber: Int = 0) {
        try {
            return evalVoidFile(file, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
    }

    fun evalStringStringSafely(file: File, scriptName: String? = file.name, lineNumber: Int = 0): String? {
        try {
            return evalStringFile(file, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun evalIntegerStringSafely(file: File, scriptName: String? = file.name, lineNumber: Int = 0): Int? {
        try {
            return evalIntegerFile(file, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun evalFloatStringSafely(file: File, scriptName: String? = file.name, lineNumber: Int = 0): Float? {
        try {
            return evalFloatFile(file, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun evalDoubleStringSafely(file: File, scriptName: String? = file.name, lineNumber: Int = 0): Double? {
        try {
            return evalDoubleFile(file, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }

    fun evalBooleanStringSafely(file: File, scriptName: String? = file.name, lineNumber: Int = 0): Boolean? {
        try {
            return evalBooleanFile(file, scriptName, lineNumber)
        } catch (e: Exception) {
            onExceptionListener.onException(e)
        }
        return null
    }
}