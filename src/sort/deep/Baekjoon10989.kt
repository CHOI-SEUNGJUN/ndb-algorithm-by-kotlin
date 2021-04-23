package sort.deep

fun main() = with(System.`in`.bufferedReader()) {
    val array = IntArray(readLine().toInt()) { readLine().toInt() }
    close()

    val bw = System.`out`.bufferedWriter()

    val countArray = IntArray(10001) { 0 }

    array.forEach { countArray[it]++ }

    countArray.forEachIndexed { index, i ->
        repeat(i) { bw.write("$index\n") }
    }

    bw.close()
}