// 05-06 퀵정렬
// https://blog.naver.com/ndb796/221226813382

// 다음의 숫자들을 오름차순으로 정렬하는 프로그램을 작성하세요.
// 1 10 5 8 7 6 4 3 2 9

val numbers = mutableListOf(1, 10, 5, 8, 7, 6, 4, 3, 2)

fun quickSort(start: Int, end: Int) {
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
            swapItem(pivot, high)
        } else {
            swapItem(low, high)
        }
    }

    quickSort(start, high-1)
    quickSort(high+1, end)
}

fun swapItem(a: Int, b: Int) {
    numbers[a] = numbers[b].also { numbers[b] = numbers[a] }
}

fun main() {
    quickSort(0, numbers.size - 1)
    numbers.forEach { print("$it ") }
}