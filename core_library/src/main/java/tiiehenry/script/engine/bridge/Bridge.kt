package tiiehenry.script.engine.bridge

import tiiehenry.script.engine.bridge.i.IBridge
import tiiehenry.script.engine.framework.ScriptEngine

open class Bridge<T : ScriptEngine>(override val engine: T): IBridge<T>
