import homework_4.LinkIterator
import homework_4.LinkedList

fun main(args: Array<String>) {
    val linkedList = LinkedList()

    for (i in 0..5) {
        linkedList.insertLast("Vasia $i", 15 + i)
    }

    linkedList.display()

    val iterator = LinkIterator(linkedList)

    println("Итератор двигается на 2 позиции вперед")
    iterator.nextLink()
    iterator.nextLink()

    println("Текущий элемент итератора")
    iterator.current!!.display()

    println("Удаляем ${iterator.deleteCurrent()}")

    println("Новый список:")
    linkedList.display()

}

