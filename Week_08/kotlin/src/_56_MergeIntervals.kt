fun merge(intervals: Array<IntArray>): Array<IntArray> {
    // 要合并所有重叠的区间，先考虑合并某一个重叠的区间[l, r]
    // 与其重叠的区间是不连续的，需要顺序扫描整个集合
    // 能否通过某种方式可以让重叠的区间是连续的，这里通过以左端点排序实现
    // 核心在于让不连续的重叠区间连续，这样就可以线性合并所有重叠的区间
    if (intervals.isEmpty()) return emptyArray()
    intervals.sortBy { it[0] }
    val ret = mutableListOf<IntArray>()
    var curr = intervals[0]
    intervals.forEach {
        if (it[0] > curr[1]) {
            ret += curr
            curr = it
        } else {
            curr[1] = maxOf(curr[1], it[1])
        }
    }
    ret += curr
    return ret.toTypedArray()
}