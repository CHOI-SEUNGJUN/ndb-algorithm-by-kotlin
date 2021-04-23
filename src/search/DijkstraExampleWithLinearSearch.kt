package search

private class Solution {
    private val number = 6
    private val array = Array(number) { IntArray(number) }
    private val visited = BooleanArray(number) { false }
    private val distance = IntArray(number)
    private val maxValue = 1_000_000_000

    fun solution(start: Int) {
        initArray()

        for (i in 0 until number) {
            distance[i] = array[start][i]
        }

        visited[start] = true

        for (i in 0 until number - 2) {
            val current = getSmallIndex()
            visited[current] = true
            for (j in 0 until number) {
                if (visited[j] == false) {
                    if (distance[current] + array[current][j] < distance[j]) {
                        distance[j] = distance[current] + array[current][j]
                    }
                }
            }
        }

        val bw = System.`out`.bufferedWriter()
        distance.forEach { bw.write("$it\n") }
        bw.close()
    }

    private fun initArray() {
        array[0] = intArrayOf(0, 2, 5, 1, maxValue, maxValue)
        array[1] = intArrayOf(2, 0, 3, 2, maxValue, maxValue)
        array[2] = intArrayOf(5, 3, 0, 3, 1, 5)
        array[3] = intArrayOf(1, 2, 3, 0, 1, maxValue)
        array[4] = intArrayOf(maxValue, maxValue, 1, 1, 0, 2)
        array[5] = intArrayOf(maxValue, maxValue, 5, maxValue, 2, 0)
    }

    private fun getSmallIndex(): Int {
        var min = Int.MAX_VALUE
        var index = 0

        for (i in 0 until number) {
            if (distance[i] < min && visited[i] == false) {
                min = distance[i]
                index = i
            }
        }

        return index
    }
}

fun main() {
    Solution().solution(0)
}