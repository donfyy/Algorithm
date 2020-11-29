class _493_ {
    class Solution {
        fun reversePairs(nums: IntArray): Int {
            val n = nums.size
            val cache = IntArray(n)
            fun merge(left: Int, right: Int): Int {
                if (left >= right) return 0
                val mid = (left + right) ushr 1
                var ret = merge(left, mid)
                ret += merge(mid + 1, right)
                var i = left
                var j = mid + 1
                var k = j
                var l = left
                while (i <= mid) {
                    while (j <= right && nums[j] * 2L < nums[i]) j++;
                    ret += j - mid - 1;
                    while (k <= right && nums[k] < nums[i]) cache[l++] = nums[k++];
                    cache[l++] = nums[i++];
                }
                while (k <= right) cache[l++] = nums[k++];
                cache.copyInto(nums, left, left, right + 1)
                return ret
            }
            return merge(0, n - 1);
        }
    }

    class SolutionRight {
        fun reversePairs(nums: IntArray): Int {
            if (nums.size < 2) return 0
            return mergeSort(nums, 0, nums.size - 1, IntArray(nums.size))
        }

        fun mergeSort(nums: IntArray, left: Int, right: Int, cache: IntArray): Int {
            if (left >= right) return 0
            val mid = left + ((right - left) shr 1)
            var count = 0
            count += mergeSort(nums, left, mid, cache)
            count += mergeSort(nums, mid + 1, right, cache)

            var i = left
            var j = mid + 1
            var k = left
            var l = i

            while (j <= right) {
                while (l <= mid && nums[l] <= 2L * nums[j]) l++
                count += mid + 1 - l

                while (i <= mid && nums[i] < nums[j]) cache[k++] = nums[i++]
                cache[k++] = nums[j++]
            }

            while (i <= mid) cache[k++] = nums[i++]
            System.arraycopy(cache, left, nums, left, right - left + 1)
            return count
        }
    }
}
