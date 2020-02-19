package tiiehenry.script.engine.internal

import tiiehenry.script.engine.framework.ScriptEngine
import java.io.File
import java.io.FileNotFoundException


//require 返回保存状态，load 每次都加载
open class Requirer(private val engine: ScriptEngine) {


    val requireList = ArrayList<String>()
    val requireMap = HashMap<String, Any?>()

    private fun findRequireFileByName(name: String): File? {
        findPathList.forEach {
            val file = File(it, name)
            if (file.exists()) {
                return file
            }
            val filen = File(it, "$name.js")
            if (filen.exists()) {
                return filen
            }
        }
        requireList.forEach {
            val file = File(File(it).parentFile, name)
            if (file.exists()) {
                return file
            }
            val filen = File(File(it).parentFile, "$name.js")
            if (filen.exists()) {
                return filen
            }
        }
        return null
    }

    open fun require(name: String): Any? {
        try {
            when {
                File(name).exists() -> return requireFile(File(name))
                else -> {
                    val file = findRequireFileByName(name)
                    if (file != null) {
                        requireFile(file)
                    } else {
                        throw FileNotFoundException("can not find：$name")
                    }
                }
            }
        } catch (e: Exception) {
            engine.onExceptionListener.onException(e)
        }
        return null
    }

    open  fun require(file: File): Any? {
        try {
            return requireFile(file)
        } catch (e: Exception) {
            engine.onExceptionListener.onException(e)
        }
        return null
    }

    @Throws(Exception::class)
    fun requireFile(file: File): Any? {
        if (requireList.contains(file.absolutePath))
            return requireMap[file.absolutePath]
//        val re = engine.stringEvaler.evalString(file.readText(), file.name)
        val re=engine.fileEvaler.evalFile(file)
        requireMap[file.absolutePath] = re
        requireList.add(file.absolutePath)
        return re
    }

    open  fun load(name: String): Any? {
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
            engine.onExceptionListener.onException(e)
        }
        return null
    }

    open fun load(file: File): Any? {
        try {
            return loadFile(file)
        } catch (e: Exception) {
            engine.onExceptionListener.onException(e)
        }
        return null
    }

    @Throws(Exception::class)
    fun loadFile(file: File): Any? {
        val re = engine.stringEvaler.evalString(file.readText(), file.name)
        requireMap[file.absolutePath] = re
        requireList.add(file.absolutePath)
        return re
    }

    companion object{
        val findPathList = ArrayList<String>()

        fun addFindPath(name: String) {
            findPathList.add(name)
        }
    }
}