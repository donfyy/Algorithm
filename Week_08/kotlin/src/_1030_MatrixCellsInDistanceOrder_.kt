class _1030_ {
    class Solution {
        fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
            val ret = Array<IntArray>(R * C) { IntArray(2) }
            for (i in 0 until R) {
                for (j in 0 until C) {
                    ret[i * C + j][0] = i
                    ret[i * C + j][1] = j
                }
            }
            ret.sortWith(Comparator { l, r -> Math.abs(l[0] - r0) + Math.abs(l[1] - c0) - Math.abs(r[0] - r0) - Math.abs(r[1] - c0)})
            return ret
        }
    }
}