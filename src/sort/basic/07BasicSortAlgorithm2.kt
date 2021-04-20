import java.util.*

// 07 기본 정렬 알고리즘 - 2
// https://www.acmicpc.net/problem/2750

// 삽입 정렬을 활용하여
fun main() {
    val count = readLine()!!.toInt()
    val scanner = Scanner(System.`in`)
    val numbers = mutableListOf<Int>()

    repeat(count) {
        numbers.add(scanner.nextInt())
    }

    for (i in 0 until numbers.size - 1) {
        var j = i
        while (j >= 0 && numbers[j] > numbers[j+1]) {
            numbers[j] = numbers[j+1].also { numbers[j+1] = numbers[j] }
            j--
        }
    }

    numbers.forEach { println(it) }

}