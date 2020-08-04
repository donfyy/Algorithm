import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class _632_SlidingWindow_ {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        val idxMap = HashMap<Int, MutableList<Int>>()
        var rangeLeft = Integer.MAX_VALUE
        var rangeRight = Integer.MIN_VALUE
        val n = nums.size
        for (i in 0 until n) {
            nums[i].forEach { x ->
                idxMap.computeIfAbsent(x) { ArrayList() }.add(i)
                rangeLeft = x.coerceAtMost(rangeLeft)
                rangeRight = x.coerceAtLeast(rangeRight)
            }
        }

        val freq = IntArray(n)
        var count = 0 // list count inside sliding window
        var left = rangeLeft
        var right = rangeLeft
        var bestLeft = rangeLeft
        var bestRight = rangeRight
        while (right <= rangeRight) {
            idxMap[right]?.let {
                it.forEach { idx ->
                    freq[idx]++
                    if (freq[idx] == 1) {
                        count++
                    }
                }

                while (count == n) {
                    if (right - left < bestRight - bestLeft) {
                        bestLeft = left
                        bestRight = right
                    }
                    idxMap[left]?.forEach { idx ->
                        freq[idx]--
                        if (freq[idx] == 0) {
                            count--
                        }
                    }
                    left++
                }
            }
            right++
        }
        return intArrayOf(bestLeft, bestRight)
    }
}
class _632_Heap_ {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        val n = nums.size
        val next = IntArray(n)
        val heap = PriorityQueue<Int>() { l, r -> nums[l][next[l]] - nums[r][next[r]]}
        var rangeRight = Integer.MIN_VALUE
        for (i in 0 until n) {
            heap.offer(i)
            rangeRight = rangeRight.coerceAtLeast(nums[i][0])
        }

        var bestLeft = nums[heap.peek()][next[heap.peek()]]
        var bestRight = rangeRight
        while (true) {
            val idx = heap.poll()
            val rangeLeft = nums[idx][next[idx]]
            if (rangeRight - rangeLeft < bestRight - bestLeft) {
                bestLeft = rangeLeft
                bestRight = rangeRight
            }
            next[idx]++
            if (next[idx] == nums[idx].size) {
                break
            }
            heap.offer(idx)
            rangeRight = rangeRight.coerceAtLeast(nums[idx][next[idx]])
        }
        return intArrayOf(bestLeft, bestRight)
    }
}