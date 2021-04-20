// 07 기본 정렬 알고리즘 - 1
// https://www.acmicpc.net/problem/2752

//문제
//동규는 세수를 하다가 정렬이 하고싶어졌다.

//숫자 세 개를 생각한 뒤에, 이를 오름차순으로 정렬하고 싶어 졌다.

//숫자 세 개가 주어졌을 때, 가장 작은 수, 그 다음 수, 가장 큰 수를 출력하는 프로그램을 작성하시오.

//입력
//숫자 세 개가 주어진다. 이 숫자는 1보다 크거나 같고, 1,000,000보다 작거나 같다. 이 숫자는 모두 다르다.

//출력
//제일 작은 수, 그 다음 수, 제일 큰 수를 차례대로 출력한다.

// 선택 정렬을 활용하여
fun main() {
    val scannedList = readLine()!!.split(' ').map(String::toInt).toMutableList()

    var minIndex = -1

    for (i in 0 until scannedList.size) {
        var min = 1_000_001

        for (j in i until scannedList.size) {
            if (scannedList[j] < min) {
                min = scannedList[j]
                minIndex = j
            }
        }

        scannedList[i] = scannedList[minIndex].also { scannedList[minIndex] = scannedList[i] }
    }

    scannedList.forEach { print("$it ") }
}