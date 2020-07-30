package tiiehenry.script.wrapper.framework.lang

interface IFunction<T> {
    fun call(vararg args: Any): IVariable<*, T>?
}