package ch.hslu.pcp.kotlin.typesafebuilders

private class Resident(var firstname: String? = null, var lastname: String? = null, var age: Int? = null)

private class Address(var street: String? = null, var postbox: Int? = null, var city: String? = null, val residents: ArrayList<Resident> = ArrayList()) {

    internal fun resident(init: Resident.() -> Unit) = Resident().also {
        it.init()
        residents.add(it)
    }
}

private class AddressBook(var name: String? = null, var pages: Int? = null, val addresses: ArrayList<Address> = ArrayList()) {

    internal fun address(init: Address.() -> Unit) = Address().also {
        it.init()
        addresses.add(it)
    }
}

private fun addressbook(init: AddressBook.() -> Unit) = AddressBook().apply { init() }

private fun printAddressBook(addressBook: AddressBook) {
    println("AddressBook: ${addressBook.name}, ${addressBook.pages} pages")
    val adresses = addressBook.addresses
    adresses.forEach {
        println("\tAddress: ${it.street}, ${it.postbox}, ${it.city}")
        val residents = it.residents
        residents.forEach { resident ->
            println("\t\tResident: ${resident.firstname} ${resident.lastname}, ${resident.age}")
        }
    }
}


fun main(args: Array<String>) {
    val addressBook = addressbook {
        name = "Resident Assembly"
        pages = 1240

        address {
            street = "Bundesplatz 15"
            postbox = 6003
            city = "Lucerne"

            resident {
                firstname = "Peter"
                lastname = "Buholzer"
                age = 40
            }

            resident {
                firstname = "Petra"
                lastname = "Muster"
                age = 30
            }

            resident {
                firstname = "Max"
                lastname = "Meier"
                age = 44
            }
        }

        address {
            street = "Pilatusstrasse 34"
            postbox = 6005
            city = "Lucerne"

            resident {
                firstname = "Adam"
                lastname = "Riese"
                age = 62
            }
        }
    }
    printAddressBook(addressBook)
}