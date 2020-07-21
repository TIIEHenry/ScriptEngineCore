package tiiehenry.script.wrapper

object ScriptEngineManager : IScriptEngineManager {
    internal const val DEBUG = true

    private val engineWrapperMap = hashMapOf<String, IScriptEngineFactory<*,*, *>>()

    override fun addEngineFactory(engineFactory: IScriptEngineFactory<*,*, *>) {
        engineWrapperMap[engineFactory.engineName] = engineFactory
    }

    override fun removeEngineFactory(engineFactory: IScriptEngineFactory<*,*, *>) {
        engineWrapperMap.remove(engineFactory.engineName)
    }

    override fun getEngineFactoryByName(name: String): IScriptEngineFactory<*,*, *>? {
        return engineWrapperMap[name]
    }

    override fun getEngineFactoriesByScriptName(scriptName: String): List<IScriptEngineFactory<*,*, *>> {
        return engineWrapperMap.values.filter { it.scriptNames.contains(scriptName) }
    }

    override fun getEngineFactories(): List<IScriptEngineFactory<*,*, *>> {
        return engineWrapperMap.values.toList()
    }

    override fun getEngineFactoriesByMimeType(mimeType: String): List<IScriptEngineFactory<*,*, *>> {
        return engineWrapperMap.values.filter { it.mimeTypes.contains(mimeType) }
    }

    override val globalScope: MutableMap<String, *> = hashMapOf<String,Any?>()
//    override val globalScriptContext: IScriptContext=GlobalScriptContext()
}