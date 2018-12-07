package ch.hslu.pcp.kotlin.nullsafety

private class NullSafety {
    private var notnullable: String = "I'm certainly not null"
    private var nullable: String? = "I might be null"

    internal fun setValuesToNull() {
//        this.notnullable = null
//        this.nullable.length
        this.nullable = null
        println("Value of NotNullable var: $notnullable")
        println("Value of Nullable var: $nullable")
    }

    internal fun checkNullExplicit() {
        val sizeNotNullable = if (this.notnullable != null) this.notnullable.length else -1
        val nullable = this.nullable
        val sizeNullable = if (nullable != null) nullable.length else -1
//        val sizeNullable = if (this.nullable != null) this.nullable.length else -1
        println("length of NotNullable: $sizeNotNullable")
        println("length of Nullable: $sizeNullable")
    }

    internal fun checkNullSafeCall() {
        val firstCharNotNullable: Char = this.notnullable?.get(0)
        val firstCharNullable: Char? = this.nullable?.get(0)
        println("first character of NotNullable: $firstCharNotNullable")
        println("first character of Nullable: $firstCharNullable")
    }

    internal fun checkNullElvisOp() {
        val concatenatedNotNullable = this.notnullable?.plus(", and I won't ever be.") ?: "unreachable"
        val concatenatedNullable = this.nullable?.plus(", but right now I'm not.") ?: "Well, I'm null"
//        val concatenatedNullable = this.nullable?.plus(", but right now I'm not.") ?: throw NullPointerException("If you want a NPE, you can have it!")
        println("Concatenation of NotNullable: $concatenatedNotNullable")
        println("Concatenation of Nullable: $concatenatedNullable")
    }

    internal fun checkNullNotNullAssertionOp() {
        val capitalizedNotNullable = this.notnullable!!.capitalize()
        val capitalizedNullable = this.nullable!!.capitalize()
        println("Capitalization of NotNullable: $capitalizedNotNullable")
        println("Capitalization of Nullable: $capitalizedNullable")
    }
}

fun main(args: Array<String>) {
    val nullsafety = NullSafety()
    nullsafety.setValuesToNull()
    nullsafety.checkNullExplicit()
    nullsafety.checkNullSafeCall()
    nullsafety.checkNullElvisOp()
    nullsafety.checkNullNotNullAssertionOp()
}