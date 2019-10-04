package tiiehenry.script.engine.android

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.StrictMode
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.WindowManager
import android.widget.Toast
import tiiehenry.script.engine.framework.ScriptEngine
import tiiehenry.script.engine.framework.ScriptProvider

interface ScriptContext<T : ScriptEngine> {
    var engine: T

    val scriptProvider:ScriptProvider<T>


    val mainHandler: Handler
    val toastbuilder: StringBuilder
    var lastShow: Long

    fun getContext(): Context

    fun newScriptEngine(): T

    fun getScriptEngine(): T {
        return engine
    }

    fun initJsContext() {
    }

    fun onEngineInited() {
//        engine.
//        engine.putVar("context", getContext())

    }

    //null engine
    fun onCreateBeforeSuper(savedInstanceState: Bundle?) {
        resetPolicy()
        initJsContext()
    }

    //engine inited but not eval
    fun onCreateAfterSuper(savedInstanceState: Bundle?) {

    }


    fun toast(id: Int) {
        notifyShowToast(getContext().getString(id))
    }

    fun toast(a: Any) {
        notifyShowToast(a.toString())
    }

    /* fun printi(id: Int) {
         notifyShowToast(getContext().getString(id))
         logi("js", getContext().getString(id))
     }

     fun printi(a: Any?) {
         notifyShowToast(a.toString())
         logi("js", a.toString())
     }

     fun printe(id: Int) {
         notifyShowToast(getContext().getString(id))
         loge("js", getContext().getString(id))
     }

     fun printe(a: Any?) {
         notifyShowToast(a.toString())
         loge("js", a.toString())
     }

 */
    fun showToast(text: String) {
        val now = System.currentTimeMillis()
        if (now - lastShow > 1000) {
            toastbuilder.setLength(0)
            toastbuilder.append(text)
        } else {
            toastbuilder.append("\n")
            toastbuilder.append(text)
        }
        lastShow = now
        Toast.makeText(getContext(), toastbuilder.toString(), Toast.LENGTH_LONG).show()
    }

    fun notifyShowToast(text: String) {
        val m = Message().apply {
            what = ScriptMainHandler.TOAST
            obj = text
        }
        mainHandler.sendMessage(m)
    }

//    fun getString(id: Int): String

    fun getAttrColor(id: Int): Int {
        val typedValue = TypedValue()
        getContext().theme.resolveAttribute(id, typedValue, true)
        return typedValue.data
    }

    fun getWidth(): Int {
        val wm = getContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val outMetrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.widthPixels
    }

    fun getHeight(): Int {
        val wm = getContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val outMetrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.heightPixels
    }

    private fun resetPolicy() {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        val builder = StrictMode.VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())//绕过provider
    }
}