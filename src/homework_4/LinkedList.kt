package homework_4

class Link(var name: String?, var age: Int) {
    var next: Link? = null

    fun display() = println("name $name, age $age")
}

class LinkedList {
    var first: Link? = null
    var last: Link? = null

    fun isEmpty() = first == null

    fun insert(name: String, age: Int) {
        val newLink = Link(name, age)
        if (isEmpty()) last = newLink
        newLink.next = first
        first = newLink
    }

    fun insertLast(name: String, age: Int) {
        val newLink = Link(name, age)
        if (isEmpty()) first = newLink
        else last!!.next = newLink
        last = newLink
    }

    fun delete(): Link? {
        val temp = first
        if (first!!.next == null) last = null
        first = first!!.next
        return temp
    }

    fun display() {
        var current = first
        while (current != null) {
            current.display()
            current = current.next
        }
    }
}

class LinkIterator(var list: LinkedList?) {
    var current: Link? = null
    var prevous: Link? = null

    init {
        reset()
    }

    fun reset() {
        current = list!!.first
        prevous = null
    }

    fun atEnd() = current!!.next == null

    fun nextLink() {
        prevous = current
        current = current!!.next
    }

    fun insertAfter(name: String, age: Int) {
        val newLink = Link(name, age)
        if (list!!.isEmpty()) {
            list!!.first = newLink
            current = newLink
        } else {
            newLink.next = current!!.next
            current!!.next = newLink
            nextLink()
        }
    }

    fun insertBefore(name: String, age: Int) {
        val newLink = Link(name, age)
        if (prevous == null) {
            newLink.next = list!!.first
            list!!.first = newLink
            reset()
        } else {
            newLink.next = prevous!!.next
            prevous!!.next = newLink
            current = newLink
        }
    }

    fun deleteCurrent(): String {
        val name = current!!.name
        if (prevous == null) {
            list!!.first = current!!.next
            reset()
        } else {
            prevous!!.next = current!!.next
            if (atEnd()) {
                reset()
            } else {
                current = current!!.next
            }
        }
        return name!!
    }

}

