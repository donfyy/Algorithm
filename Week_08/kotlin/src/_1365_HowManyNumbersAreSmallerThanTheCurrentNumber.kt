class _1365_HowManyNumbersAreSmallerThanTheCurrentNumber_ {
    class CountingSort {
        // O(N + K)  O(K)
        fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
            val bucket = IntArray(101)
            val n = nums.size
            // 把数放到桶中
            // bucket[i] 表示 i 出现的次数
            nums.forEach { bucket[it]++ }
            // 计算比当前数小的数的数目
            // bucket[i] 表示 [0, i] 所有数出现的次数和
            for (i in 1..100) {
                bucket[i] += bucket[i - 1]
            }
            // 将数目放到数组中
            val ret = IntArray(n)
            repeat(n) {
                ret[it] = if (nums[it] == 0) 0 else bucket[nums[it] - 1]
            }
            return ret
        }
    }

    class QuickSort {
        // O(NlogN)  O(N)
        fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
            // 复制nums，对复制后的nums排序
            val sorted = nums.copyOf().sorted()
            // 用map保存小于元素的元素数目
            val cnt = hashMapOf<Int, Int>()
            sorted.forEachIndexed { i, num -> cnt.putIfAbsent(num, i) }
            // 按照元素在nums中的顺序返回小于数目数组
            val n = nums.size
            val ret = IntArray(n)
            repeat (n) {
                ret[it] = cnt[nums[it]]!!
            }
            return ret
        }
    }
}