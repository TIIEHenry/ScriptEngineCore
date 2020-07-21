package tiiehenry.script.wrapper.engine.internal

import tiiehenry.script.wrapper.IScriptContext
import tiiehenry.script.wrapper.IScriptEngine

interface IPrinter<V, T> {
    val engine: IScriptEngine<V, T>
    val context: IScriptContext
    fun println(msg: Any?) {
        print(msg)
        context.output.println()
    }

    fun print(msg: Any?)
}