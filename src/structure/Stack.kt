package structure

import java.util.*

fun main() {
    val stack = Stack<Int>()
    stack.push(7)
    stack.push(5)
    stack.push(4)
    stack.pop()
    stack.push(6)
    stack.pop()
    while (stack.isNotEmpty()) {
        println(stack.peek())
        stack.pop()
    }
}