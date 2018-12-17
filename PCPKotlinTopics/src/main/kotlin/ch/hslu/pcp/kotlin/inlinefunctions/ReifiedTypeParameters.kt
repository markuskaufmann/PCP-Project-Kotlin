package ch.hslu.pcp.kotlin.inlinefunctions

internal inline fun <reified T> checkInstanceType(instance: Any) {
    if (instance is T) {
        println("$instance (${instance::class}) is of type ${T::class}")
    } else {
        println("Types don't match: Argument: $instance (${instance::class}), Type Parameter: ${T::class}")
    }
}

fun main(args: Array<String>) {
    checkInstanceType<String>(32)
    checkInstanceType<Int>(2.5)
    checkInstanceType<String>("Test")
}