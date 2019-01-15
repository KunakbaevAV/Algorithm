package homework_6

class TreeStack(val size: Int) {
    var stack = Array<Node?>(size) { null }
    var top: Int = -1

    fun push(node: Node?) {
        stack[++top] = node
    }

    fun pop(): Node? {
        return stack[top--]
    }

    fun peek(): Node? {
        return stack[top]
    }

    fun isEmpty(): Boolean {
        return top == -1
    }

    fun isFull(): Boolean {
        return top == size - 1
    }
}