package sort.heap
// 09 힙 정렬
// https://blog.naver.com/ndb796/221228342808

// 다음의 데이터를 오름차순 정렬하세요.
// 7 6 5 8 3 5 9 1 6

val heap = arrayOf(7, 6, 5, 8, 3, 5, 9, 1, 6)

fun main() {

    // build max heap
    for (i in 1 until heap.size) {
        var child = i

        while (child != 0) {
            val root = (child - 1) / 2
            if (heap[root] < heap[child]) {
                heap[root] = heap[child].also { heap[child] = heap[root] }
            }

            child = root
        }
    }

    for (i in heap.size - 1 downTo 0) {
        heap[0] = heap[i].also { heap[i] = heap[0] }
        var root = 0
        var child = 1

        while (child < i) {
            child = 2 * root + 1
            if (child < i -1 && heap[child] < heap[child + 1]) {
                child++
            }

            if (child < i && heap[root] < heap[child]) {
                heap[root] = heap[child].also { heap[child] = heap[root] }
            }

            root = child
        }
    }

    heap.forEach { print("$it ") }

}