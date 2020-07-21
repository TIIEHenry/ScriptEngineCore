package tiiehenry.script.wrapper.engine.internal

import tiiehenry.script.wrapper.IScriptContext
import java.io.*

class GlobalScriptContext(readerStream: InputStream, writerStream: OutputStream, errorStream: OutputStream) : IScriptContext {
    override val input: Reader = InputStreamReader(readerStream)
    override val output: Writer = OutputStreamWriter(writerStream, Charsets.UTF_8)
    override val error: Writer = OutputStreamWriter(errorStream, Charsets.UTF_8)
    override val bindings: MutableMap<String, *> = mutableMapOf<String,Any>()
}