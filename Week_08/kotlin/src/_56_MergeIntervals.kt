import java.util.*

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return intervals
    Arrays.sort(intervals) { l, r -> l[0] - r[0] }
    val ret = Array<IntArray?>(intervals.size) { null }
    ret[0] = intervals[0]
    var last = intervals[0]
    var j = 1
    for (i in 1 until intervals.size) {
        val current = intervals[i]
        if (current[0] <= last[1]) {
            last[1] = Math.max(last[1], current[1])
        } else {
            ret[j++] = current
            last = current
        }
    }
    return Arrays.copyOf(ret, j)
}