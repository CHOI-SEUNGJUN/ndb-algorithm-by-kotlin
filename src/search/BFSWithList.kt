package search

import java.util.*

// Breath First Search - BFS 너비 우선 탐색
// 인접 리스트를 이용하여

data class Node(
    val data: Int,
    val adj: LinkedList<Node> = LinkedList(),
    var visited: Boolean = false
)

class Graph(size: Int) {

    private var nodes: MutableList<Node> = mutableListOf()

    init {
        for (i in 0 until size) {
            nodes.add(Node(i))
        }
    }

    fun addEdge(i1: Int, i2: Int) {
        val n1 = nodes[i1]
        val n2 = nodes[i2]

        if (!n1.adj.contains(n2)) {
            n1.adj.add(n2)
        }
        if (!n2.adj.contains(n1)) {
            n2.adj.add(n1)
        }
    }

    fun bfs(index: Int) {
        val root = nodes[index]
        val queue: Queue<Node> = LinkedList()
        queue.offer(root)
        root.visited = true

        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            polled.adj.forEach { adj ->
                if (adj.visited == false) {
                    adj.visited = true
                    queue.offer(adj)
                }
            }
            print("${polled.data} ")
        }
    }
}

fun main() {
    val graph = Graph(8)
    with(graph) {
        addEdge(1, 2)
        addEdge(1, 3)
        addEdge(2, 3)
        addEdge(2, 4)
        addEdge(2, 5)
        addEdge(3, 6)
        addEdge(3, 7)
        addEdge(4, 5)
        addEdge(6, 7)

        bfs(1)
    }
}