package tiiehenry.script.engine.android

import android.os.Handler
import android.os.Message

class ScriptMainHandler(val scriptContext: ScriptContext<*>) : Handler() {
    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)
        when (msg.what) {
            TOAST -> scriptContext.toast(msg.obj.toString())
            LOG -> scriptContext.log(msg.obj.toString())
            PRINT -> scriptContext.print(msg.obj.toString())
        }
    }

    companion object {
        val TOAST = "toast".hashCode()
        val LOG = "log".hashCode()
        val PRINT = "print".hashCode()
    }
}