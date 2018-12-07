package ch.hslu.pcp.kotlin.closureslambdas

import java.util.stream.Collectors

private fun sampleStream() {
    val strings = "This is a simple example to show you the power of lambdas".split(" ").stream()
    val output = strings
            .filter { s -> s.length > 2 }
//                    .filter { it.length > 2 }
            .map { s -> s.toUpperCase() }
//                    .map { it.toUpperCase() }
            .sorted()
            .collect(Collectors.joining(" "))
    println(output)
}

private fun trailingCalculate(prefix: String, a: Double, b: Double, func: (Double, Double) -> Double) {
    println("$prefix of $a and $b: ${func(a, b)}")
}

fun main(args: Array<String>) {
    sampleStream()
    trailingCalculate("Multiplication", 10.0, 15.0) { fact1, fact2 -> fact1 * fact2 }
}