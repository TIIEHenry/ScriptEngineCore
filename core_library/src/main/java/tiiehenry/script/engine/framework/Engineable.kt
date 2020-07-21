package tiiehenry.script.engine.framework

import tiiehenry.script.engine.android.ScriptContext
import tiiehenry.script.engine.android.ScriptDexLoader
import tiiehenry.script.engine.bridge.FuncBridge
import tiiehenry.script.engine.bridge.VarBridge
import tiiehenry.script.engine.eval.FileEvaler
import tiiehenry.script.engine.eval.FuncEvaler
import tiiehenry.script.engine.eval.OnExceptionListener
import tiiehenry.script.engine.eval.StringEvalable
import tiiehenry.script.engine.internal.Loggable
import tiiehenry.script.engine.internal.Printable
import tiiehenry.script.engine.internal.Requirer

interface Engineable {
    val name: String

    val onExceptionListener: OnExceptionListener

    val logger: Loggable<*>
    val printer: Printable<*>

    val requirer: Requirer
    val dexLoader: ScriptDexLoader

    val funcBridge: FuncBridge<*,*>
    val varBridge: VarBridge<*,*>


    val stringEvaler: StringEvalable<*>
    val funcEvaler: FuncEvaler<*>
    val fileEvaler: FileEvaler<*>

    val scriptContext: ScriptContext<*>


    fun init(globalAlias: String)
    fun destroy()
}