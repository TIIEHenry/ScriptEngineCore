package tiiehenry.script.wrapper.engine

import java.io.InputStream
import java.io.PrintStream
import java.io.Reader
import java.io.Writer

interface IScriptContext {
    /**
     * the <code>InputStream</code> for scripts to read input
     */
    val input: InputStream

    /**
     * the <code>PrintStream</code> for scripts to use when displaying output.
     */
    val output:PrintStream

    /**
     * the <code>PrintStream</code> used to display error output.
     */
    val error:PrintStream


    /**
     *  when engine created, the bindings will be set by varBridge
     */
    val bindings: MutableMap<String, *>
}