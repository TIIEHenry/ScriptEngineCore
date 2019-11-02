package tiiehenry.script.engine.internal

import tiiehenry.script.engine.bridge.VarBridge
import tiiehenry.script.engine.framework.ScriptEngine


open class Printer<T : ScriptEngine>(override val engine: T) : Printable<T> {
    override val logTag: String by lazy {  engine.name }

}
