package tiiehenry.script.wrapper.framework.bridge

import tiiehenry.script.wrapper.framework.lang.IVariable

interface IVarBridge<V, T/*, S : ScriptEngine*/> : IBridge<IVariable<V, T>> {

    fun getType(name: String): T? {
        return get(name)?.getType()
    }

    override fun get(name: String): IVariable<V, T>?

    fun getAll(names: List<String>): MutableMap<String, IVariable<V, T>?> {
        val values = mutableMapOf<String, IVariable<V, T>?>()
        for (name in names) {
            values[name] = get(name)
        }
        return values
    }

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

    fun set(name: String, value: Any?,type:T?=null)

    fun setAll(values: Map<String, Any?>) {
        for (value in values) {
            set(value.key, value.value)
        }
    }

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