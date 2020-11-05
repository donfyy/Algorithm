class _57_InsertInterval_ {
    class Solution {
        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            // 因为区间列表是按左端点排序的， 那么与新区间重叠的区间一定是连续的
            // 那么我们可以顺序扫描列表，将与新区间重叠的区间合并到新区间中，与新区间不重叠的区间按原顺序放在列表中
            var l = newInterval[0]
            var r = newInterval[1]
            val ret = arrayListOf<IntArray>()
            var placed = false
            intervals.forEach {
                when {
                    it[1] < l -> ret += it
                    it[0] > r -> {
                        if (!placed) {
                            ret += intArrayOf(l, r)
                            placed = true
                        }
                        ret += it
                    }
                    else -> {
                        l = minOf(l, it[0])
                        r = maxOf(r, it[1])
                    }
                }
            }
            if (!placed) {
                ret += intArrayOf(l, r)
            }
            return ret.toTypedArray()
        }
    }
}