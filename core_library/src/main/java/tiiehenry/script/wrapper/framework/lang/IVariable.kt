package tiiehenry.script.wrapper.framework.lang

interface IVariable<V, T> {
    val value: V

    fun getType(): T?

    fun getString(): String? {
        value?.let {
            if (it is String)
                return it
            return it.toString()
        }
        return null
    }

    fun getBoolean(): Boolean? {
        value?.let {
            if (it is Boolean)
                return it
            return it as? Boolean
        }
        return null
    }

    fun getInteger(): Int? {
        value?.let {
            if (it is Int)
                return it
            return it as? Int
        }
        return null
    }

    fun getFloat(): Float? {
        value?.let {
            if (it is Float)
                return it
            return it as? Float
        }
        return null
    }

    fun getDouble(): Double? {
        value?.let {
            if (it is Double)
                return it
            return it as? Double
        }
        return null
    }
}