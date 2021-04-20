package structure

import java.util.*

fun main() {
    val queue: Queue<Int> = LinkedList()
    with(queue) {
        offer(7)
        offer(5)
        offer(4)
        poll()
        offer(6)
        poll()
        while (queue.isNotEmpty()) {
            println(queue.peek())
            queue.poll()
        }
    }
}