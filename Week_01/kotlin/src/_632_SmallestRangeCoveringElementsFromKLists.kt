import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class _632_SlidingWindow_ {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        val n = nums.size
        var rangeLeft = Integer.MAX_VALUE
        var rangeRight = Integer.MIN_VALUE
        val idxMap = HashMap<Int, MutableList<Int>>()
        for (i in 0 until n) {
            for (x in nums[i]) {
                val idxList = idxMap.computeIfAbsent(x) { ArrayList() }
                idxList.add(i)
                rangeLeft = rangeLeft.coerceAtMost(x)
                rangeRight = rangeRight.coerceAtLeast(x)
            }
        }

        var left = rangeLeft
        var right = rangeLeft
        var bestLeft = rangeLeft
        var bestRight = rangeRight
        val freq = IntArray(n)
        var listCount = 0
        while (right <= rangeRight) {
            if (idxMap.containsKey(right)) {
                for (idx in idxMap[right]!!) {
                    freq[idx]++
                    if (freq[idx] == 1) {
                        listCount++
                    }
                }

                while (listCount == n) {
                    if (right - left < bestRight - bestLeft) {
                        bestRight = right;
                        bestLeft = left;
                    }

                    if (idxMap.containsKey(left)) {
                        for (idx in idxMap[left]!!) {
                            freq[idx]--
                            if (freq[idx] == 0) {
                                listCount--
                            }
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