import java.util.*

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    if (nums.size < k) return IntArray(0)
    val deque = LinkedList<Int>()
    val ret = IntArray(nums.size - k + 1)
    for (i in nums.indices) {
        while (deque.isNotEmpty() && nums[deque.peekLast()] <= nums[i]) {
            deque.pollLast()
        }
        deque.offerLast(i)

        if (i >= k - 1) {
            if (i - deque.peekFirst() == k) {
                deque.pollFirst()
            }
            ret[i - k + 1] = nums[deque.peekFirst()]
        }
    }

    return ret
}

class _239_Heap_ {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.size < k) return IntArray(0)
        val ret = IntArray(nums.size - k + 1)
        val heap = PriorityQueue<Int> { l, r -> r - l }
        for (i in nums.indices) {
            heap.offer(nums[i])
            if (i >= k - 1) {
                if (i >= k) {
                    heap.remove(nums[i - k])
                }
                ret[i + 1 - k] = heap.peek()
            }
        }
        return ret
    }
}