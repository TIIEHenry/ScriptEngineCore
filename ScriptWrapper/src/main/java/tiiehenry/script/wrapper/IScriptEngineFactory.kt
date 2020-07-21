package tiiehenry.script.wrapper


interface IScriptEngineFactory<V, T> {
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

    fun newScriptEngine(scriptContext: IScriptContext): IScriptEngine<V, T>

    fun newScriptEngine(): IScriptEngine<V, T> {
        return newScriptEngine(globalScriptContext)
    }

}