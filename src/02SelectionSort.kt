// 다음의 숫자들을 오름차순으로 정렬하는 프로그램을 작성하세요.
// 1 10 5 8 7 6 4 3 2 9

fun main() {
    val numbers = mutableListOf(1, 10, 5, 8, 7, 6, 4, 3, 2, 9)
    var minIndex = 0

    for (i in 0 until numbers.size) {
        var min: Int = Int.MAX_VALUE
        for (j in i until numbers.size) {
            if (min > numbers[j]) {
                min = numbers[j]
                minIndex = j
            }
        }
        numbers[i] = numbers[minIndex].also { numbers[minIndex] = numbers[i] }
    }

    numbers.forEach { print("$it ") }
}