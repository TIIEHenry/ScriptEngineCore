package tiiehenry.script.wrapper.engine.bridge

interface IBridge<S> {

    fun get(name: String): S?

}