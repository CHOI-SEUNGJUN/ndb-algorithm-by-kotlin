package sort.counting

// 12 계수 정렬(Counting Sort)

// 다음의 5이하 자연수 데이터들을 오름차순 정렬하세요.
// 1 3 2 4 3 2 5 3 1 2 3 4 4 3 5 1 2 3 5 2 3 1 4 3 5 1 2 1 1 1

fun main() {
    val count = IntArray(5) { 0 }
    val numbers = "1 3 2 4 3 2 5 3 1 2 3 4 4 3 5 1 2 3 5 2 3 1 4 3 5 1 2 1 1 1".split(" ").map(String::toInt) // 편의를 위한 코드

    numbers.forEach {
        count[it - 1]++
    }

    count.forEachIndexed { index, i ->
        for (x in 0..i) { print(index+1) }
    }

}