// 03_버블 정렬
// https://blog.naver.com/ndb796/221226803544

// 다음의 숫자들을 오름차순으로 정렬하는 프로그램을 작성하세요.
// 1 10 5 8 7 6 4 3 2 9

fun main() {
    val numbers = mutableListOf(1, 10, 5, 8, 7, 6, 4, 3, 2, 9)

    for (i in 0 until numbers.size) {
        for (j in 0 until numbers.size - 1 - i) {
            if (numbers[j] > numbers[j + 1]) {
                numbers[j] = numbers[j + 1].also { numbers[j + 1] = numbers[j] }
            }
        }
    }

    numbers.forEach { print("$it ") }
}