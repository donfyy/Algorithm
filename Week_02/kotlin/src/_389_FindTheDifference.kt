class _389_FindTheDifference_ {
    class UsingMap {
        fun findTheDifference(s: String, t: String): Char {
            val freq = IntArray(26)
            s.forEach { freq[it - 'a']++ }
            t.forEach {
                if (--freq[it - 'a'] < 0) {
                    return it
                }
            }
            return ' '
        }
    }
    class UsingSum {
        fun findTheDifference(s: String, t: String): Char {
            var ret = 0
            t.forEach { ret += it.toInt() }
            s.forEach { ret -= it.toInt() }
            return ret.toChar()
        }
    }
    class UsingXor {
        fun findTheDifference(s: String, t: String): Char {
            var ret = 0
            s.forEach { ret = ret xor it.toInt() }
            t.forEach { ret = ret xor it.toInt() }
            return ret.toChar()
        }
    }
}