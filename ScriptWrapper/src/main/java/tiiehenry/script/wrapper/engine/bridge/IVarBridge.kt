package tiiehenry.script.wrapper.engine.bridge

import tiiehenry.script.wrapper.engine.lang.IVariable

interface IVarBridge<V, T/*, S : ScriptEngine*/> : IBridge/*<S>*/ {
    fun getType(name: String): T? {
        return get(name)?.getType(name)
    }

    fun get(name: String): IVariable<V, T>?

    fun getString(name: String): String? {
        return get(name)?.getString()
    }

    fun getBoolean(name: String): Boolean? {
        return get(name)?.getBoolean()
    }

    fun getInteger(name: String): Int? {
        return get(name)?.getInteger()
    }

    fun getFloat(name: String): Float? {
        return get(name)?.getFloat()
    }

    fun getDouble(name: String): Double? {
        return get(name)?.getDouble()
    }

    fun set(name: String, value: Any?)

    fun setString(name: String, value: String) {
        set(name, value)
    }

    fun setBoolean(name: String, value: Boolean) {
        set(name, value)
    }

    fun setInteger(name: String, value: Int) {
        set(name, value)
    }

    fun setFloat(name: String, value: Float) {
        set(name, value)
    }

    fun setDouble(name: String, value: Double) {
        set(name, value)
    }

}