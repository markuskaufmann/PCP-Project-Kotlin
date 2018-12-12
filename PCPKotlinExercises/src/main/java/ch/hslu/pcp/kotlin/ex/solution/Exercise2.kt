package ch.hslu.pcp.kotlin.ex.solution

import kotlin.random.Random

private fun generateSortAndPrintRandomInts(numberOfVals: Int, maxValueExc: Int) {
    val intSequence = generateSequence { Random.nextInt(0, maxValueExc) }
    val numbers = intSequence.take(numberOfVals)
    val output = numbers.sortedWith(reverseOrder()).toList().joinToString(" > ", prefix = "reverse ordered list = { ", postfix = " }")
    println(output)
}

fun main(args: Array<String>) {
    generateSortAndPrintRandomInts(7, 100)
}