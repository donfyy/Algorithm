fun restoreIpAddresses(s: String): List<String> {
    fun String.dfs(segStart: Int, segments: IntArray, segId: Int, ret: ArrayList<String>) {
        if (segStart == length && segId == 4) {
            val sb = StringBuilder()
            for (seg in segments) {
                sb.append(seg).append('.')
            }
            sb.deleteCharAt(sb.length - 1)
            ret.add(sb.toString())
        }
        if (segId == 4) {
            return
        }

        for (i in 1..4) {
            if (segStart + i > length || (i > 1 && (this[segStart] == '0'))) {
                continue
            }

            val seg = Integer.parseInt(substring(segStart, segStart + i))
            if (seg > 0xFF) {
                continue
            }
            segments[segId] = seg
            dfs(segStart + i, segments, segId + 1, ret);
        }
    }

    val segments = IntArray(4)
    val ret = ArrayList<String>()
    s.dfs(0, segments, 0, ret)
    return ret
}