package tiiehenry.script.wrapper.framework.internal

import tiiehenry.script.wrapper.engine.IScriptContext
import tiiehenry.script.wrapper.engine.IScriptEngine

interface IPrinter<V, T> {
    val engine: IScriptEngine<V, T>
    val context: IScriptContext
    fun println(msg: Any?) {
        print(msg)
        context.output.println()
    }

    fun print(msg: Any?)
}