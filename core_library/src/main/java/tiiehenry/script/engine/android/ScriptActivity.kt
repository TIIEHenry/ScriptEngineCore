package tiiehenry.script.engine.android

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import tiiehenry.script.engine.framework.ScriptEngine
import tiiehenry.script.engine.framework.ScriptProvider
import java.text.SimpleDateFormat
import java.util.*

abstract class ScriptActivity<A : Activity, T : ScriptEngine> : Activity(), ScriptContextActivity<A, T> {
    override val TAG: String = "ScriptActivity"
    override val mainHandler: Handler by lazy { ScriptMainHandler(this) }
    override val toastbuilder: StringBuilder = StringBuilder()
    override var lastShow: Long = 0
    override val logTextBuilder: StringBuilder = StringBuilder()
    override val printTextView: TextView by lazy { TextView(this) }
    override val printDataFormatter: SimpleDateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())//设置日期格式

    override val scriptProvider by lazy { ScriptProvider(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        onCreateBeforeSuper(savedInstanceState)
        super.onCreate(savedInstanceState)
        onCreateAfterSuper(savedInstanceState)
        engine.apply {
            init(TAG)
            onEngineInited()
        }
    }

    override fun toast(text: String) {
        super.toast(text)

    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        overridePendingTransitionOpen()
    }

    override fun onDestroy() {
        super.onDestroy()
        engine.destory()
    }

    override fun finish() {
        super.finish()
        overridePendingTransitionExit()
    }

    override fun getContext(): Context {
        return this
    }

}