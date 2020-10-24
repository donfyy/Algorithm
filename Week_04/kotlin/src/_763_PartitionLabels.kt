class _763_ {
    class Solution {
        fun partitionLabels(S: String): List<Int> {
            val lastPos = IntArray(26)
            S.forEachIndexed { i, v -> lastPos[v - 'a'] = i }
            val ret = ArrayList<Int>()
            var l = 0
            var r = 0
            S.forEachIndexed { i, v ->
                r = maxOf(r, lastPos[v - 'a'])
                if (i == r) {
                    ret += r - l + 1
                    l = r + 1
                }
            }
            return ret
        }
    }
}