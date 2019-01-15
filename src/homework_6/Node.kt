package homework_6

class Node {
    var person = Person()
    var leftChild: Node? = null
    var rightChild: Node? = null

    fun display() = println("Name: ${person.name}, age: ${person.age}")
}