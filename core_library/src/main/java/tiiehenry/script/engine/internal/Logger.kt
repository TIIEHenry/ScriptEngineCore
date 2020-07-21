package tiiehenry.script.engine.internal

import tiiehenry.script.engine.framework.ScriptEngine

abstract class Logger<T : ScriptEngine>(override val engine: T) : Loggable<T>