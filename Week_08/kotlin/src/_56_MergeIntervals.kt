fun merge(intervals: Array<IntArray>): Array<IntArray> {
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