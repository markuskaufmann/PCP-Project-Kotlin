package ch.hslu.pcp.kotlin.classdelegation

interface CustomList {
    fun add(number: Int)
    fun addAll(numbers: List<Int>)
}

class MyList : CustomList {

    private val myList = ArrayList<Int>()

    override fun add(number: Int) {
        myList.add(number)
    }

    override fun addAll(numbers: List<Int>) {
        numbers.forEach { t: Int? -> t?.let { add(it) } }
    }
}

class DelegationList(private val customList: CustomList) : CustomList by customList {
    private var itemsAdded = 0

    override fun add(number: Int) {
        itemsAdded++
        customList.add(number)
    }

    override fun addAll(numbers: List<Int>) {
        itemsAdded += numbers.size
        customList.addAll(numbers)
    }

    fun getItemsAdded(): Int {
        return itemsAdded
    }
}

fun main(args: Array<String>) {
    val myDelegationList = DelegationList(MyList())

    myDelegationList.add(12)
    myDelegationList.add(10)
    myDelegationList.addAll(listOf(1, 2, 3))

    println(myDelegationList.getItemsAdded())
}