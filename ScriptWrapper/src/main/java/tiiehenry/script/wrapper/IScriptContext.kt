package tiiehenry.script.wrapper

import java.io.Reader
import java.io.Writer

interface IScriptContext {
    /**
     * the <code>Reader</code> for scripts to read input
     */
    val reader: Reader

    /**
     * the <code>Writer</code> for scripts to use when displaying output.
     */
    val writer:Writer

    /**
     * the <code>Writer</code> used to display error output.
     */
    val errorWriter:Writer
}