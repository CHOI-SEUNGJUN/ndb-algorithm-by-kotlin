import java.util.*

// 07 기본 정렬 알고리즘 - 3
// https://www.acmicpc.net/problem/2751

// 퀵 정렬을 활용하여 - 최악의 경우 O(n^2) 시간 초과로 실패
fun main() {
    val count = readLine()!!.toInt()
    val scanner = Scanner(System.`in`)
    val numbers = mutableListOf<Int>()

    repeat(count) {
        numbers.add(scanner.nextInt())
    }

    quickSorting(numbers, 0, numbers.size - 1)

    numbers.forEach { println(it) }

}

fun quickSorting(numbers: MutableList<Int>, start: Int, end: Int) {
    if (start >= end) return

    val pivot = start
    var low = start + 1
    var high = end

    while (low <= high) {
        while (low <= end && numbers[low] < numbers[pivot]) {
            low++
        }
        while (high >= start && numbers[high] > numbers[pivot]) {
            high--
        }

        if (low > high) {
            swapItems(numbers, pivot, high)
        } else {
            swapItems(numbers, high, low)
        }
    }

    quickSorting(numbers, start, high - 1)
    quickSorting(numbers, high + 1, end)
}

fun swapItems(numbers: MutableList<Int>, a: Int, b: Int) {
    numbers[a] = numbers[b].also { numbers[b] = numbers[a] }
}