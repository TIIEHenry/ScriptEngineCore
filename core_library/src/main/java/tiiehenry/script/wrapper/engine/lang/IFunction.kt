package tiiehenry.script.wrapper.engine.lang

interface IFunction<T> {
    fun call(vararg args: Any): IVariable<*, T>?
}