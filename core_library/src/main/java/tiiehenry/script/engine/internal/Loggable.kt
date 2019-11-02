package tiiehenry.script.engine.internal

import android.util.Log
import tiiehenry.script.engine.framework.ScriptEngine

interface Loggable<T : ScriptEngine> {
    val logTag: String
    val engine: T

    fun logi(s: Any?) {
        Log.i(logTag, engine.varBridge.toString(s))
        engine.scriptContext.notifyLog(engine.varBridge.toString(s))
    }


    fun logd(s: Any?) {
        Log.d(logTag, engine.varBridge.toString(s))
        engine.scriptContext.notifyLog(engine.varBridge.toString(s))
    }


    fun logw(s: Any?) {
        Log.w(logTag, engine.varBridge.toString(s))
        engine.scriptContext.notifyLog(engine.varBridge.toString(s))
    }


    fun loge(s: Any?) {
        Log.e(logTag, engine.varBridge.toString(s))
        engine.scriptContext.notifyLog(engine.varBridge.toString(s))
    }

    fun log(s: Any?) {
        engine.scriptContext.notifyLog(engine.varBridge.toString(s))
    }


    fun logri(id: Int) {
        Log.i(logTag, engine.scriptContext.getContext().getString(id))

        engine.scriptContext.notifyLog(engine.scriptContext.getContext().getString(id))
    }


    fun logrd(id: Int) {
        Log.d(logTag, engine.scriptContext.getContext().getString(id))
        engine.scriptContext.notifyLog(engine.scriptContext.getContext().getString(id))
    }


    fun logrw(id: Int) {
        Log.w(logTag, engine.scriptContext.getContext().getString(id))
        engine.scriptContext.notifyLog(engine.scriptContext.getContext().getString(id))
    }


    fun logre(id: Int) {
        Log.e(logTag, engine.scriptContext.getContext().getString(id))
        engine.scriptContext.notifyLog(engine.scriptContext.getContext().getString(id))
    }

    fun logr(id: Int) {
        engine.scriptContext.notifyLog(engine.scriptContext.getContext().getString(id))
    }
}