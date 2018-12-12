package ch.hslu.pcp.kotlin.closureslambdas


// passing lambdas example
internal fun invokeLambda(lambda: (Double) -> Boolean) : Boolean {
    return lambda(Math.PI)
}

internal fun passingLambdaObject() {
    val lambda = { arg: Double -> arg == 1.45 }
    val result = invokeLambda(lambda)
    println("Passing object: $result")
}

internal fun passingLambdaLiteral() {
    val result = invokeLambda({ arg: Double -> arg == 1.5 })
    println("Passing literal: $result")
}

internal fun passingLambdaLiteralTrailing() {
    val result = invokeLambda { arg: Double -> arg == Math.PI }
    println("Passing literal trailing: $result")
}

internal fun passingLambdaMethodReference() {
    val result = invokeLambda(Double::isFinite)
    println("Passing method reference: $result")
}

internal fun passingExample() {
    passingLambdaObject()
    passingLambdaLiteral()
    passingLambdaLiteralTrailing()
    passingLambdaMethodReference()
}


// compare strings example
internal fun compareStringLengths(a: String, b: String): String {
    return if (a.trim().length >= b.trim().length) a else b
}

private val compareLength: (String, String) -> String = { a: String, b: String -> if (a.trim().length >= b.trim().length) a else b }

internal fun compareStringsExample() {
    val strFirst = "abc"
    val strSecond = "def"

    println("Compare with plain function (normal method): ${compareStringLengths(strFirst, strSecond)}")

    val compLambdaRef = compareLength(strFirst, strSecond)
    println("Compare with referenced lambda: $compLambdaRef")

    val compLambdaInline: (String, String) -> String = { a, b -> if (a.trim().length >= b.trim().length) a else b }
    println("Compare with inline lambda: ${compLambdaInline(strFirst, strSecond)}")

    val compAnonymous = fun(a: String, b: String): String {
        return if (a.trim().length >= b.trim().length) a else b
    }
    println("Compare with anonymous function: ${compAnonymous(strFirst, strSecond)}")

    val plusMethodRef: (String, String) -> String = String::plus
    println("Concatenate strings with method reference: ${plusMethodRef(strFirst, strSecond)}")
}


fun main(args: Array<String>) {
    passingExample()
    compareStringsExample()
}