package tiiehenry.script.wrapper.framework.bridge

interface IBridge<S> {

    fun get(name: String): S?

}