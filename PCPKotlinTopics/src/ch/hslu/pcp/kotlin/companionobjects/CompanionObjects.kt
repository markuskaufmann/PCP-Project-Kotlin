package ch.hslu.pcp.kotlin.companionobjects

class Product(private val name: String, private var price: Int) {
    companion object Factory {
        private val products = mutableListOf<Product>()

        fun getProduct(name: String): Product {
            var product = Product(name, 0)
            if (products.any { p -> p.name == name }) {
                products.forEach { p -> if (p.name == name) product = p }
            } else {
                products.add(product)
            }
            return product
        }
    }

    fun getPrice(): Int {
        return price
    }

    fun setPrice(price: Int): Unit {
        this.price = price
    }
}

class Singleton private constructor() {
    companion object {
        private val singleton = Singleton()

        fun create(): Singleton {
            return singleton
        }
    }

    private var name: String = ""

    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String {
        return name
    }
}


fun main(args: Array<String>) {
    val apple1 = Product.getProduct("Apple")
    apple1.setPrice(12)
    println("apple1 price: " + apple1.getPrice())

    val banana = Product.getProduct("Banana")
    banana.setPrice(10)
    println("apple1 price: " + apple1.getPrice())
    println("banana price: " + banana.getPrice())

    val apple2 = Product.getProduct("Apple")
    apple1.setPrice(15)
    println("apple1 price: " + apple1.getPrice())
    println("apple2 price: " + apple2.getPrice())


    val singleton1 = Singleton.create()
    singleton1.setName("Test")

    println("Name1: " + singleton1.getName())

    val singleton2 = Singleton.create()
    println("Name2: " + singleton2.getName())
}