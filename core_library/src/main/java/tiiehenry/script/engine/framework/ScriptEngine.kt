package tiiehenry.script.engine.framework

import tiiehenry.script.engine.android.ScriptContext
import tiiehenry.script.engine.android.ScriptDexLoader
import tiiehenry.script.engine.eval.OnExceptionListener
import tiiehenry.script.engine.internal.Requirer


abstract class ScriptEngine(final override val scriptContext: ScriptContext<*>) : Engineable {

    override val name: String = "ScriptEngine"

    override val dexLoader by lazy {ScriptDexLoader(scriptContext)}
    override val requirer by lazy { Requirer(this)}

    override val onExceptionListener: OnExceptionListener =object : OnExceptionListener {
        override fun onException(e: Exception) {
            e.printStackTrace()
            printer.printe(e.message)
        }
    }

}
