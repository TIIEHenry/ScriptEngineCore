package tiiehenry.script.wrapper

import java.io.FileReader
import java.io.Reader
import java.io.Writer

class GlobalScriptContext() : IScriptContext {
    override val reader: Reader=FileReader()
    override val writer: Writer
        get() = TODO("Not yet implemented")
    override val errorWriter: Writer
        get() = TODO("Not yet implemented")
}