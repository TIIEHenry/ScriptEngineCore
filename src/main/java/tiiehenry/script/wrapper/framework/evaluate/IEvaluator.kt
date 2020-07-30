package tiiehenry.script.wrapper.framework.evaluate

import tiiehenry.script.wrapper.engine.IScriptContext
import tiiehenry.script.wrapper.framework.lang.IVariable

interface IEvaluator<V, T, S> {
    val context: IScriptContext
    fun eval(input: S, scriptName: String? = null, lineNumber: Int = 1): IVariable<V, T>?

//    fun eval(input: S, type: T? = null, scriptName: String? = null, lineNumber: Int = 0): IVariable<V, T>?
//
//    fun eval(input: S, scriptName: String? = null, lineNumber: Int = 0): IVariable<V, T>? {
//        return eval(input, null, scriptName, lineNumber)
//    }

    fun evalSafely(input: S, scriptName: String?=null, lineNumber: Int = 1): IVariable<V, T>? {
        try {
            return eval(input, scriptName, lineNumber)
        } catch (e: Exception) {
            context.error.println(e.message)
        }
        return null
    }

//    fun evalSafely(input: S, scriptName: String?, lineNumber: Int = 0): IVariable<V, T>? {
//        return evalSafely(input, null, scriptName, lineNumber)
//    }

//    fun evalSafely(input: S, type: T? = null, scriptName: String?, lineNumber: Int = 0): IVariable<V, T>? {
//        try {
//            return eval(input, type, scriptName, lineNumber)
//        } catch (e: Exception) {
//            context.errorWriter.write(e.message.toString())
//        }
//        return null
//    }
}