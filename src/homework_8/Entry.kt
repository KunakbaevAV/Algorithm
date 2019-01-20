package homework_8

class Entry<K, V>(var key: K?, var value: V?) {
    var hash = 0
    var next: Entry<K, V>? = null

    fun display() {
        println("key=$key, value=$value")
    }
}