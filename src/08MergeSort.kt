// 08 병합 정렬
// https://blog.naver.com/ndb796/221227934987

// 다음의 숫자들을 오름차순으로 정렬하는 프로그램을 작성하세요.
// 7 6 5 8 3 5 9 1

class Solution(val nums: MutableList<Int>) {

    private val sorted = arrayOfNulls<Int>(8)

    private fun merge(left: Int, mid: Int, right: Int) {
        var i = left
        var j = mid + 1
        var k = left

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                sorted[k] = nums[i]
                i++
            } else {
                sorted[k] = nums[j]
                j++
            }
            k++
        }

        if (i > mid) {
            for (t in j..right) {
                sorted[k] = nums[t]
                k++
            }
        } else {
            for (t in i..mid) {
                sorted[k] = nums[t]
                k++
            }
        }

        for (t in left..right) {
            nums[t] = sorted[t]!!
        }

    }

    fun partList(left: Int, right: Int) {
        if (left < right) {
            val mid = (left + right) / 2
            partList(left, mid)
            partList(mid + 1, right)
            merge(left, mid, right)
        }
    }

}

fun main() {
    val numbers = mutableListOf(7, 6, 5, 8, 3, 5, 9, 1)
    Solution(numbers).apply {
        partList(0, numbers.size - 1)
        nums.forEach { print("$it ") }
    }
}