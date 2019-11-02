package tiiehenry.script.engine.bridge.i

import tiiehenry.script.engine.framework.ScriptEngine

interface IVarBridge<T, S : ScriptEngine> : IBridge<S> {
    fun getType(name: String): T

    fun getVar(name: String): Any?

    fun getString(name: String): String?

    fun getBoolean(name: String): Boolean?

    fun getInteger(name: String): Int?

    fun getFloat(name: String): Float?

    fun getDouble(name: String): Double?

    fun putVar(name: String, value: Any?)

    fun putString(name: String, value: String)

    fun putBoolean(name: String, value: Boolean)

    fun putInteger(name: String, value: Int)

    fun putFloat(name: String, value: Float)

    fun putDouble(name: String, value: Double)

    fun toString(value: Any?): String {
        if (value is String)
            return value
        value?.let {
            return toString()
        }
        return "null"
    }

    fun toBoolean(value: Any?): Boolean {
        if (value is Boolean)
            return value
        value?.let {
            return it as? Boolean ?: false
        }
        return false
    }

    fun toInteger(value: Any?): Int {
        if (value is Int)
            return value
        value?.let {
            return it as? Int ?: -1
        }
        return -1
    }

    fun toFloat(value: Any?): Float {
        if (value is Float)
            return value
        value?.let {
            return it as? Float ?: -1F
        }
        return -1F
    }

    fun toDouble(value: Any?): Double {
        if (value is Double)
            return value
        value?.let {
            return it as? Double ?: -1.0
        }
        return -1.0
    }
}