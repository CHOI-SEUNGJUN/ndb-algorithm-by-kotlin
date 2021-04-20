package search

import java.util.*

// Breath First Search - BFS 너비 우선 탐색
// 인접 행렬을 이용하여

private val vertexCount = 7
private var visited: BooleanArray = booleanArrayOf()
private var graph: Array<IntArray> = arrayOf()

fun main() {
    graph = Array(vertexCount + 1) { IntArray(vertexCount + 1) { 0 } }
    visited = BooleanArray(vertexCount + 1) { false }

    addGraph(1, 2)
    addGraph(1, 3)
    addGraph(2, 3)
    addGraph(2, 4)
    addGraph(2, 5)
    addGraph(3, 6)
    addGraph(3, 7)
    addGraph(4, 5)
    addGraph(6, 7)

    bfs(1)
}

private fun addGraph(a: Int, b:Int) {
    graph[a][b] = 1
    graph[b][a] = 1
}

private fun bfs(start: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.offer(start)
    visited[start] = true
    while (queue.isNotEmpty()) {
        val x = queue.poll()
        print("$x ")
        for (i in graph[x].indices) {
            val y = graph[x][i]

            if (y == 1 && visited[i] == false) {
                queue.offer(i)
                visited[i] = true
            }
        }
    }
}