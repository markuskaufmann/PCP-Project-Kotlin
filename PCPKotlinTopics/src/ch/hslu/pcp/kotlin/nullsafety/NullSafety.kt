package ch.hslu.pcp.kotlin.nullsafety

class NullSafety {
    var notnullable: String = "I'm certainly not null"
    var nullable: String? = "I could be null"

    fun setNull() {
//        this.notnullable = null;
        this.nullable = null;
        println("Value of NotNullable var: $notnullable")
        println("Value of Nullable var: $nullable")
    }
}

fun main(args: Array<String>) {
    val nullsafety = NullSafety()
    nullsafety.setNull()
}