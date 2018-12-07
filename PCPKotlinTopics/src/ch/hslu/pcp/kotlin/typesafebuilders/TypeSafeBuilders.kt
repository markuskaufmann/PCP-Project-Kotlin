package ch.hslu.pcp.kotlin.typesafebuilders

private class Person(val id: Int, val firstName: String, val lastName: String, val age: Int)

private fun generateListOfPeople(): List<Person> {
    return listOf(
            Person(1, "Max", "Muster", 42),
            Person(2, "Hans", "Meier", 57),
            Person(3, "Sarah", "Müller", 34),
            Person(4, "Laura", "Bachmann", 24)
    )
}

fun main(args: Array<String>) {
    val people = generateListOfPeople()
    val xmlPeople = xml("people") {
        for (person in people) {
            "person" {
                attribute("id", person.id)
                "firstName" {
                    text(person.firstName)
                }
                "lastName" {
                    text(person.lastName)
                }
                "age" {
                    text(person.age.toString())
                }
            }
        }
    }
    println(xmlPeople.toString())
}
