class _925_LongPressedName_ {
    class Solution {
        fun isLongPressedName(name: String, typed: String): Boolean {
            val m = name.length
            val n = typed.length
            var i = 0
            var j = 0
            while (j < n) {
                when {
                    i < m && name[i] == typed[j] -> {
                        i++
                        j++
                    }
                    j > 0 && typed[j] == typed[j - 1] -> {
                        j++
                    }
                    else -> {
                        return false
                    }
                }
            }
            return i == m
        }
    }
}