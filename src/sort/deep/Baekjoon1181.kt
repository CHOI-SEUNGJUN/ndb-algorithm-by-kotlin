package sort.deep

import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val count = readLine().toInt()

    val words = mutableListOf<String>()

    repeat(count) {
        words.add(readLine())
    }

    words.sortWith { o1, o2 ->
        if (o1.length == o2.length) {
            o1.compareTo(o2)
        } else  {
            o1.length - o2.length
        }
    }

    words.distinct().forEach { println(it) }

    close()
}