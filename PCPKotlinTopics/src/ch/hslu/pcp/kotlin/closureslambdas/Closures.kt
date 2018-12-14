package ch.hslu.pcp.kotlin.closureslambdas

fun main(args: Array<String>) {
    var sum = 0
    (1..10).forEach { sum += it }
    println(sum)
}