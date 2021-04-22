package sort.basic

import java.io.*
import java.lang.StringBuilder

/**
 * 07 기본 정렬 알고리즘 - 3
 * https://www.acmicpc.net/problem/2751
 *
 * 계수 정렬(counting sort)를 이용하여
 *
 * ndb 포스팅에서는 퀵 정렬, C++ STL 함수로 구현해도 통과했으나
 * Kotlin 에서는 기본 내장 함수로는 통과하지 못한다.
 *
 * 또한 계수 정렬을 이용하여 문제 해결을 해도 Scanner(or BufferedReader) + println() 방식으로는 통과하지 못한다.
 *
 * BufferedReader 와 StringBuilder 모두 사용해야 백준 #2751 문제를 통과할 수 있었다.
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val count = readLine().toInt()

    val array = BooleanArray(2_000_001)
    val sb = StringBuilder()

    repeat(count) {
        array[readLine().toInt() + 1_000_000] = true
    }

    array.forEachIndexed { index, b ->
        if (b) {
            sb.append(index - 1_000_000).append("\n")
        }
    }

    print(sb)
}