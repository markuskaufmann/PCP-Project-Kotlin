package ch.hslu.pcp.kotlin.extensions

fun String.capitalizeEachWord(): String {
    return this.split(" ").map { t -> t.capitalize() }.reduce { acc, s -> "$acc $s" }
}

fun Int.square(): Int {
    return this*this
}

fun Any?.toString(): String {
    if (this == null) return "null"
    return toString()
}

fun main(args: Array<String>) {
    val testString = "This is a string"
    println(testString)
    println(testString.capitalizeEachWord())

    val testInt = 12
    println(testInt)
    println(testInt.square())

    var nullableVariable : Any? = null
    println(nullableVariable.toString())

    nullableVariable = "This string is not null"
    println(nullableVariable.toString())
}