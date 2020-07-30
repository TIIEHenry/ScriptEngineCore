package tiiehenry.script.wrapper.framework.internal

import tiiehenry.script.wrapper.engine.IScriptContext
import tiiehenry.script.wrapper.engine.IScriptEngine
import java.io.File
import java.io.FileNotFoundException

interface IRequirer<V, T> {
    val engine: IScriptEngine<V, T>
    val context: IScriptContext


    val findPathList: MutableList<String>
    val requireList: MutableList<String>
    val requireMap: MutableMap<String, Any?>
    fun getFileNameWithExtension(name: String): String

    private fun findRequireFileByName(name: String): File? {
        findPathList.forEach {
            val file = File(it, name)
            if (file.exists()) {
                return file
            }
        }
        requireList.forEach {
            val file = File(File(it).parentFile, name)
            if (file.exists()) {
                return file
            }
        }
        return null
    }

    fun require(name: String): Any? {
        val fileName = getFileNameWithExtension(name)
        try {
            when {
                File(fileName).exists() -> return requireFile(File(fileName))
                else -> {
                    val file = findRequireFileByName(fileName)
                    if (file != null) {
                        requireFile(file)
                    } else {
                        throw FileNotFoundException("can not find：$name")
                    }
                }
            }
        } catch (e: Exception) {
            context.error.println(e.message)
        }
        return null
    }


    @Throws(Exception::class)
    fun requireFile(file: File): Any? {
        if (requireList.contains(file.absolutePath))
            return requireMap[file.absolutePath]
        val re = engine.fileEvaluator.eval(file, null)
        requireMap[file.absolutePath] = re
        requireList.add(file.absolutePath)
        return re
    }

    fun load(name: String): Any? {
        try {
            when {
                File(name).exists() -> return loadFile(File(name))
                else -> {
                    val file = findRequireFileByName(name)
                    if (file != null) {
                        loadFile(file)
                    } else {
                        throw Exception("can not find：$name")
                    }
                }
            }
        } catch (e: Exception) {
            context.error.println(e.message)
        }
        return null
    }


    @Throws(Exception::class)
    fun loadFile(file: File): Any? {
        val re = engine.fileEvaluator.eval(file, file.name)
        requireMap[file.absolutePath] = re
        requireList.add(file.absolutePath)
        return re
    }
}