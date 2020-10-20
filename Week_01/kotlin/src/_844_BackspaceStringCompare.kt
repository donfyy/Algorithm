class _844_ {
    class Solution {
        fun backspaceCompare(S: String, T: String): Boolean {
            val i = intArrayOf(S.lastIndex, 0)
            val j = intArrayOf(T.lastIndex, 0)
            fun skip(p: IntArray, s: String) {
                while (p[0] >= 0) {
                    if (s[p[0]] == '#') {
                        p[1]++
                        p[0]--
                    } else if (p[1] > 0){
                        p[1]--
                        p[0]--
                    } else {
                        break
                    }
                }
            }
            while (i[0] >= 0 || j[0] >= 0) {
                skip(i, S)
                skip(j, T)
                // 一个大于0一个小于0退出
                if (i[0] >= 0 != j[0] >= 0) return false
                if (i[0] >= 0 && j[0] >= 0 && S[i[0]--] != T[j[0]--]) return false
            }
            return true
        }
    }
}