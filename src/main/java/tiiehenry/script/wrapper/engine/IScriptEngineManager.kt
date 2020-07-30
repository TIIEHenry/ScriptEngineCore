package tiiehenry.script.wrapper.engine


interface IScriptEngineManager {
    fun addEngineFactory(engineFactory: IScriptEngineFactory<*, *, *>)
    
    fun removeEngineFactory(engineFactory: IScriptEngineFactory<*, *, *>)

    fun getEngineFactoryByName(name: String): IScriptEngineFactory<*, *, *>?

    fun getEngineFactoriesByScriptName(scriptName: String): List<IScriptEngineFactory<*, *, *>>

    fun getEngineFactories(): List<IScriptEngineFactory<*, *, *>>

    /**
     * Look up `IScriptEngineFactory` for a given mime type.  The algorithm
     * @param mimeType The given mime type
     */
    fun getEngineFactoriesByMimeType(mimeType: String): List<IScriptEngineFactory<*, *, *>>

    val globalScope: MutableMap<String, *>
//    val globalScriptContext: IScriptContext
}