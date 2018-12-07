package ch.hslu.pcp.kotlin.closureslambdas

fun compareStringLengths(a: String, b: String): String {
    return if (a.trim().length >= b.trim().length) a else b
}

private val compareLength = { a: String, b: String -> if (a.trim().length >= b.trim().length) a else b }

fun main(args: Array<String>) {
    val strFirst = "abc"
    val strSecond = "def"

    println("Compare with plain function (normal method): ${compareStringLengths(strFirst, strSecond)}")

    val compLambdaRef = compareLength(strFirst, strSecond)
    println("Compare with referenced lambda: $compLambdaRef")

    val compLambdaInline: (String, String) -> String = { a, b -> if (a.trim().length >= b.trim().length) a else b}
    println("Compare with inline lambda: ${compLambdaInline(strFirst, strSecond)}")

    val compAnonymous = fun(a: String, b: String): String {
        return if (a.trim().length >= b.trim().length) a else b
    }
    println("Compare with anonymous function: ${compAnonymous(strFirst, strSecond)}")

    val plusMethodRef: (String, String) -> String = String::plus
    println("Concatenate strings with method reference: ${plusMethodRef(strFirst, strSecond)}")
}