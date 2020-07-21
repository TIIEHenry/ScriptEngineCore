package tiiehenry.script.wrapper.engine


interface IScriptEngineFactory<E: IScriptEngine<V, T>,V, T> {
    /**
     * engine name
     */
    val engineName: String

    /**
     * engine version
     */
    val engineVersion: String

    /**
     * like js rhino javascript JavaScript
     */
    val scriptNames: List<String>
    val mimeTypes: List<String>

    val globalScriptContext: IScriptContext

//    val bindings: MutableMap<String, *>

    fun newScriptEngine(scriptContext: IScriptContext): E

    fun newScriptEngine(): E {
        return newScriptEngine(globalScriptContext)
    }

}