package ch.hslu.pcp.kotlin.classdelegation

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

val value: Int by lazy {
    //Do database query in here to get the value once
    println("The variable is called the first time")
    10
}

var name: String by Delegates.observable("-") {
    _, oldValue, newValue -> println("Old Value: $oldValue \nNew Value $newValue")
}

var ageProperty: Int by Delegate()

class Delegate {

    private var age = 0

    operator fun getValue(nothing: Nothing?, property: KProperty<*>): Int {
        println("Returned $age")
        return age
    }

    operator fun setValue(nothing: Nothing?, property: KProperty<*>, i: Int) {
        println("New age set to $i")
        age = i
    }

}

fun main(args: Array<String>) {
    println("First call:")
    println(value)
    println("Second call:")
    println(value)
    println()

    name = "Kevin"
    name = "Markus"
    println()

    ageProperty = 12
    println(ageProperty)
}