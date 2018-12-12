package ch.hslu.pcp.kotlin.closureslambdas


fun main(args: Array<String>) {
    val addWithSpace : String.(String) -> String = { this + " " + it.trimStart() }
    println("This is a".addWithSpace("test abc"))
}