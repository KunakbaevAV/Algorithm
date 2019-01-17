package homework_7

import homework_3.Queue

class Vertex(var label: Char) {
    var wasVisited = false

    override fun toString(): String {
        return label.toString()
    }
}

class Graph(private val MAX_VERTEX: Int) {
    val vertexList = Array<Vertex?>(MAX_VERTEX) { null }
    var size = 0
    private var queue = Queue(MAX_VERTEX)
    private val adjMat = Array(MAX_VERTEX) { IntArray(MAX_VERTEX) }

    fun addVertex(label: Char) {
        vertexList[size++] = Vertex(label)
    }

    fun addEdge(start: Int, end: Int) {
        adjMat[start][end] = 1
        adjMat[end][start] = 1
    }

    fun displayVertex(vertex: Int) {
        println(vertexList[vertex])
    }

    private fun getAdjUnvisitedVertex(vertex: Int): Int {
        for (i in 0 until size) {
            if (adjMat[vertex][i] == 1 && !vertexList[i]!!.wasVisited) {
                return i
            }
        }
        return -1
    }

    fun bfs() {
        vertexList[0]!!.wasVisited = true
        displayVertex(0)
        queue.insert(0)
        var v1: Int


        while (!queue.isEmpty) {
            v1 = queue.remove()
            var v2 = getAdjUnvisitedVertex(v1)
            while (v2 != -1) {
                vertexList[v2]!!.wasVisited = true
                displayVertex(v2)
                queue.insert(v2)
                v2 = getAdjUnvisitedVertex(v1)
            }
        }
        for (i in 0 until size) vertexList[i]!!.wasVisited = false
    }
}

fun main(args: Array<String>) {
    val graph = Graph(10)
    graph.addVertex('A')
    graph.addVertex('B')
    graph.addVertex('C')
    graph.addVertex('D')
    graph.addVertex('E')
    graph.addVertex('F')
    graph.addVertex('J')
    graph.addVertex('I')
    graph.addVertex('U')
    graph.addVertex('L')

    graph.addEdge(0, 3)
    graph.addEdge(3, 4)
    graph.addEdge(4, 6)

    graph.bfs()
}