package search

import java.util.*

// Depth First Search - 깊이 우선 탐색
// 인접 행렬과 재귀함수를 이용하여

private val vertexCount = 7
private var visited : BooleanArray = booleanArrayOf()
private var graph: Array<IntArray> = arrayOf()

fun main() {

    graph = Array(vertexCount + 1) { IntArray(vertexCount + 1) { 0 } }
    visited = BooleanArray(graph.size) { false }

    addGraph(1, 2)
    addGraph(1, 3)
    addGraph(2, 3)
    addGraph(2, 4)
    addGraph(2, 5)
    addGraph(3, 6)
    addGraph(3, 7)
    addGraph(4, 5)
    addGraph(6, 7)

    // dfs(1) // 1 2 3 6 7 4 5
    dfsIteratively(1) // 1 3 7 6 2 5 4 =
}

private fun addGraph(a: Int, b:Int) {
    graph[a][b] = 1
    graph[b][a] = 1
}

private fun dfs(index: Int) {
    visited[index] = true
    print("$index ")

    val root = graph[index]

    root.forEachIndexed { idx, isAdj ->
        if (isAdj != 0 && visited[idx] == false) {
            dfs(idx)
        }
    }

//    for (x in root.indices) {
//        val y = graph[index][x]
//
//        if (y != 0 && visited[x] == false) {
//            dfs(x)
//        }
//
//    }
}

private fun dfsIteratively(index: Int) {
    visited[index] = true

    val stack = Stack<Int>()
    stack.push(index)

    while (stack.isNotEmpty()) {
        val popped = stack.pop()
        print("$popped ")
        graph[popped].forEachIndexed { idx, isAdj ->
            if (isAdj != 0 && visited[idx] == false) {
                visited[idx] = true
                stack.push(idx)
            }
        }
    }
}