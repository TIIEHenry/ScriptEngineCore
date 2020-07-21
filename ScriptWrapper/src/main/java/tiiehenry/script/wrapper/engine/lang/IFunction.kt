package tiiehenry.script.wrapper.engine.lang

interface IFunction<T> {
    fun call(vararg args: Any): IVariable<T, *>?

    fun callVoid(vararg args: Any) {
        call(args)
    }

    fun callString(vararg args: Any): String? {
        return call(args)?.getString()
    }

    fun callBoolean(vararg args: Any): Boolean? {
        return call(args)?.getBoolean()
    }

    fun callInteger(vararg args: Any): Int? {
        return call(args)?.getInteger()
    }

    fun callFloat(vararg args: Any): Float? {
        return call(args)?.getFloat()
    }

    fun callDouble(vararg args: Any): Double? {
        return call(args)?.getDouble()
    }

}