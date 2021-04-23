package sort.deep

fun main() = with(System.`in`.bufferedReader()) {

    val count = readLine().toInt()

    val list = mutableListOf<String>()

    repeat(count) {
        list.add(readLine())
    }

    list.sortedWith { o1, o2 ->
        if (o1.length == o2.length) {
            try {
                val ro1 = o1.replace("[^0-9]".toRegex(), "").map { it.toString().toLong() }.toLongArray()
                val ro2 = o2.replace("[^0-9]".toRegex(), "").map { it.toString().toLong() }.toLongArray()
                if (ro1.sum() == ro2.sum()) {
                    o1.compareTo(o2)
                } else {
                    (ro1.sum() - ro2.sum()).toInt()
                }
            } catch (e: NumberFormatException) {
                o1.compareTo(o2)
            }
        } else {
            o1.length - o2.length
        }
    }.forEach { println(it) }

}