package tiiehenry.script.wrapper.framework.internal

import tiiehenry.script.wrapper.engine.IScriptEngine
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

abstract class InputEvaluateTask<V, T>(private val input: InputStream, private val engine: IScriptEngine<V, T>) {
    private val thread = object : Thread() {
        override fun run() {
            try {
                val br = BufferedReader(InputStreamReader(input))
                var str: String?
                var lineNo = 0
                do {
                    lineNo++
                    str = br.readLine()
                    engine.stringEvaluator.evalSafely(str, null, lineNo)
                } while (!shouldFinish && !shouldFinish(str))
//            br.close()
            }catch (e:Exception){
                engine.context.error.println(e.message)
            }
        }
    }
    private var shouldFinish = false

    fun start() {
        thread.start()
    }

    fun end() {
        shouldFinish = true
    }

    abstract fun shouldFinish(str: String?): Boolean

}