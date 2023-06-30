package com.learning

import java.util.*

data class Vertex(val label: String, var isVisited: Boolean = false)

class Graph {
    val adjList = mutableMapOf<String, MutableList<Vertex>>()

    fun addVertex(vertex: Vertex) {
        adjList.put(vertex.label, mutableListOf())
    }

    fun connect(startVertex: Vertex, endVertex: Vertex) {
        if (adjList.contains(startVertex.label))
            adjList.get(startVertex.label)?.add(endVertex)
    }

    fun dfs(source: String) {
        println("node $source is visited ")

        for (vrtx in adjList.get(source)!!) {
            vrtx.isVisited = true
            dfs(vrtx.label)
        }
    }

    fun dfsIteratively(source: String) {
        var stack = Stack<Vertex>()
        stack.push(Vertex(source, true))
        while (!stack.isEmpty()) {
            val current = stack.pop()
            current.isVisited = true
            println("vertex ${current.label} visited")
            for (neighbor in adjList.get(current.label)!!) {
                stack.push(neighbor)
            }
        }
    }

    fun bfs(source: String) {
        val queue = LinkedList<Vertex>()
        queue.add(Vertex(source, true))

        while (!queue.isEmpty()) {
            val current = queue.remove()
            current.isVisited = true
            println("Vertex ${current.label} is visited")
            for (vertex in adjList.get(current.label)!!) {
                queue.add(vertex)
            }
        }
    }
}

fun main() {
    val graph = Graph()
    graph.addVertex(Vertex("a"))
    graph.addVertex(Vertex("b"))
    graph.addVertex(Vertex("e"))
    graph.addVertex(Vertex("c"))
    graph.addVertex(Vertex("f"))
    graph.addVertex(Vertex("d"))


    graph.connect(Vertex("a"), Vertex("b"))
    graph.connect(Vertex("a"), Vertex("c"))
    graph.connect(Vertex("b"), Vertex("d"))
    graph.connect(Vertex("c"), Vertex("e"))
    graph.connect(Vertex("d"), Vertex("f"))

    print(
        "Graph like \n" +
        "a -> b , c \n" +
        "b -> d \n"     +
        "c -> e \n"     +
        "d -> f \n"
    )

    println("********** Depth First Recursively *********** ")
    graph.dfs("a")

    println("********** Depth First Iteratively *********** ")
    graph.dfsIteratively( "a")

    println("********** Breadth First Iteratively *********** ")
    graph.bfs( "a")
}