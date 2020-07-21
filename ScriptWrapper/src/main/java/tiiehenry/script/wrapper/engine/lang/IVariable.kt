package tiiehenry.script.wrapper.engine.lang

interface IVariable<V,T> {
    val value:V?

    fun getType(name: String): T

    fun getString(): String {
        value?.let {
            if (it is String)
                return it
            return it.toString()
        }
        return "null"
    }

    fun getBoolean(): Boolean {
        value?.let {
            if (it is Boolean)
                return it
            return it as? Boolean ?: false
        }
        return false
    }

    fun getInteger(): Int {
        value?.let {
            if (it is Int)
                return it
            return it as? Int ?: -1
        }
        return -1
    }

    fun getFloat(): Float {
        value?.let {
            if (it is Float)
                return it
            return it as? Float ?: -1F
        }
        return -1F
    }

    fun getDouble(): Double {
        value?.let {
            if (it is Double)
                return it
            return it as? Double ?: -1.0
        }
        return -1.0
    }
}