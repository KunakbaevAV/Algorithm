package homework_8

class MyHashMap<K, V>() {
    val MAX_CAPACITY = Int.MAX_VALUE / 2
    var capacity = 16
    val loadFactor = 0.75
    var threshold: Int = (capacity * loadFactor).toInt()
    var size = 0
    var entry = Array<Entry<K, V>>(capacity) { Entry(null, null) }
    var table = Array(capacity) { entry }

    fun put(key: K, value: V) {
        val hash = key.hashCode()
        val index = indexForHash(hash)
        if (size > threshold) {
            resize()
        }
        addEntry(hash, key, value, index)
    }

    fun get(key: K): Entry<K, V> {
        val index = indexForHash(key.hashCode())
        for (i in 0 until table[index].size) {
            if (table[index][i].key == key) {
                return table[index][i]
            }
        }
        return Entry(null, null)
    }

    fun indexForHash(hash: Int): Int {
        return hash and capacity - 1
    }

    fun addEntry(hash: Int, key: K, value: V, index: Int) {
        if (table[index][0].key == null) {
            size++
        }
        table[index].plus(Entry(key, value))
    }

    //Попробовал сделать свой вариант resize. Только понял, что тут много чего надо делать.
    //так что пока дальше не иду.
    fun resize() {
        capacity *= 2
        println(capacity)
        val entry = Array<Entry<K, V>>(capacity) { Entry(null, null) }
        val newTable = Array(capacity) { entry }
        for (i in 0 until table.size) {
            newTable.plus(table[i])
        }
        table = newTable
        threshold = (capacity * loadFactor).toInt()
        println("resize")
    }
}

fun main(args: Array<String>) {
    val hashMap = MyHashMap<String, String>()
    for (i in 0..4) {
        hashMap.put(i.toString(), (Math.random() * 10).toString())
    }

    hashMap.get("2").display()
}

