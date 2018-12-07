package ch.hslu.pcp.kotlin.inlinefunctions

private class InlineFunctions {

    internal fun add(a: Int, b: Int): Unit {
        println("Result of addition: $a + $b = ${a + b}")
    }

    internal fun subtract(a: Int, b: Int): Unit {
        println("Result of subtraction: $a - $b = ${a - b}")
    }

    internal fun multiply(a: Int, b: Int): Unit {
        println("Result of multiplication: $a * $b = ${a * b}")
    }

    internal fun divide(a: Int, b: Int): Unit {
        if (b == 0) throw IllegalArgumentException("Division by zero")
        println("Result of division: $a / $b = ${a.div(b.toFloat())}")
    }
}

internal inline fun calculate(noinline add: (Int, Int) -> Unit, subtract: (Int, Int) -> Unit, multiply: (Int, Int) -> Unit, crossinline divide: (Int, Int) -> Unit) {
    val a = 10
    val b = 25
    add(a, b)
    subtract(a, b)
    multiply(a, b)
    Runnable {
        divide(a, b)
        return@Runnable
    }.run()
    println("About to end the calculation process")
}

fun main(args: Array<String>) {
    val inlineFunctions = InlineFunctions()
    val addition: (Int, Int) -> Unit = { a: Int, b: Int -> println("Result of addition: $a + $b = ${a + b}") }
    calculate(add = addition,
            subtract = { a: Int, b: Int -> inlineFunctions.subtract(a, b) },
            multiply = { a: Int, b: Int -> println("Result of multiplication: $a * $b = ${a * b}") },
//            multiply = { a: Int, b: Int ->
//                println("No multiplication of $a and $b, return instead")
//                // Non-local return
//                return
//            },
            divide = { a: Int, b: Int -> inlineFunctions.divide(a, b) })
    println("Again some addition: ")
    addition(35, 10)
}