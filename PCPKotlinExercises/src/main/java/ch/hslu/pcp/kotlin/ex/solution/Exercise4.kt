package ch.hslu.pcp.kotlin.ex.solution

private fun join(strings: Iterable<String>): String {
    return strings.reduce { first, second -> "$first $second" }
}

fun main(args: Array<String>) {
    val strings = listOf("Java", "is", "cool")
    println("Mit Iterable.joinToString: " + strings.joinToString(" "))
    println("Mit eigener Methode: " + join(strings))
}