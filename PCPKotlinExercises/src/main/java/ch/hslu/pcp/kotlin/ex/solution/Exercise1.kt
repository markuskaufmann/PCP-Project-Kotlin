package ch.hslu.pcp.kotlin.ex.solution

private fun reduceAndPrintStrings(namesArray: Array<String>): String? {
    val names: List<String> = namesArray.toList()
    val tempResult = names
        .filter { it.startsWith("T") }
        .map { it.toUpperCase() }
        .fold("") { t: String?, u: String? -> "$t $u" }
    val result: String? = if (tempResult.isEmpty()) null else tempResult
    result?.let { println("[Debugoutput] x = $result") }
    return result
}

private fun printOptional(optionalString: String?, defaultValue: String) {
    println("value = " + (optionalString ?: defaultValue))
}

fun main(args: Array<String>) {
    val namesArray = arrayOf("Joe", "Tara", "Sue", "Tim")
    val reducedString = reduceAndPrintStrings(namesArray)
    printOptional(reducedString, "[Default]")

    val otherArray = arrayOf("Joe", "Sue")
    val otherReducedString = reduceAndPrintStrings(otherArray)
    printOptional(otherReducedString, "[Default]")
}