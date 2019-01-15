package homework_6

class MyTree {
    var root: Node? = null

    fun find(key: Int): Node? {
        var current: Node? = root
        while (current!!.person.id != key)
            current = if (current.person.id > key) current.leftChild else current.rightChild
        return if (current == null) null else current
    }

    fun insert(person: Person) {
        val node = Node()
        node.person = person

        if (root == null) {
            root = node
        } else {
            var current = root
            var parent: Node?
            while (true) {
                parent = current
                if (person.id < current!!.person.id) {
                    current = current.leftChild
                    if (current == null) {
                        parent!!.leftChild = node
                        return
                    }
                } else {
                    current = current.rightChild
                    if (current == null) {
                        parent!!.rightChild = node
                        return
                    }
                }

            }
        }
    }

    fun delete(id: Int) {

    }

    fun displayTree() {
        val stack = TreeStack(100)
        stack.push(root)
        var nBlanks = 32
        var isRowEmpty = false

        while (!isRowEmpty) {
            val localStack = TreeStack(100)
            isRowEmpty = true
            for (i in 0 until nBlanks) {
                print(" ")
            }
            while (!stack.isEmpty()) {
                val temp = stack.pop()
                if (temp != null) {
                    temp.display()
                    localStack.push(temp.leftChild)
                    localStack.push(temp.rightChild)
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false
                    }
                } else {
                    print("--")
                    localStack.push(null)
                    localStack.push(null)
                }
                for (j in 0 until nBlanks * 2 - 2) {
                    print(' ')
                }
                println(" ")
                nBlanks /= 2
                while (!localStack.isEmpty()) {
                    stack.push(localStack.pop())
                }
                println(".......................................")
            }
        }
    }
}

fun main(args: Array<String>) {
    val tree = MyTree()
    for (i in 0..10) {
        tree.insert(Person("VAsia$i", i, 10 + i))
    }
    tree.find(3)!!.display()
}