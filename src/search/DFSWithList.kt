package search

import java.util.*

// Depth First Search - 깊이 우선 탐색
// 인접 리스트와 재귀함수를 이용하여

data class DFSNode(
    val data: Int,
    val adj: LinkedList<DFSNode> = LinkedList(),
    var visited: Boolean = false
)

class DFSGraph(size: Int) {

    val nodes = mutableListOf<DFSNode>()

    init {
        for (i in 0 until size) {
            nodes.add(DFSNode(i))
        }
    }

    fun addGraph(i1: Int, i2: Int) {
        val n1 = nodes[i1]
        val n2 = nodes[i2]

        if (!n1.adj.contains(n2)) {
            n1.adj.add(n2)
        }

        if (!n2.adj.contains(n1)) {
            n2.adj.add(n1)
        }
    }

    fun dfs(index: Int) {
        val root = nodes[index]
        root.visited = true
        print("${root.data} ")

        root.adj.forEachIndexed { i, dfsNode ->
            if (dfsNode.visited == false) {
                dfs(dfsNode.data)
            }
        }
    }
}

fun main() {
    val graph = DFSGraph(8)
    with(graph) {
        addGraph(1, 2)
        addGraph(1, 3)
        addGraph(2, 3)
        addGraph(2, 4)
        addGraph(2, 5)
        addGraph(3, 6)
        addGraph(3, 7)
        addGraph(4, 5)
        addGraph(6, 7)

        dfs(1)
    }
}