package tiiehenry.script.wrapper.framework.internal

import tiiehenry.script.wrapper.engine.IScriptContext
import java.io.*

class GlobalScriptContext(override val input: InputStream, override val output: PrintStream, override val error: PrintStream) : IScriptContext {

    override val bindings: MutableMap<String, *> = mutableMapOf<String,Any>()
}