class _1002_ {
    fun commonChars(A: Array<String>): List<String> {
        // 每个字符在所有字符串中出现次数的最小值
        // 要求全部字符，先求一个字符
        // 由字符出现的次数想到用哈希表
        val minFreq = IntArray(26) { Integer.MAX_VALUE }
        val freq = IntArray(26)
        A.forEach {
            freq.fill(0)
            for (c in it) {
                freq[c - 'a']++
            }
            for (i in 0..25) {
                minFreq[i] = minOf(minFreq[i], freq[i])
            }
        }
        val ret = arrayListOf<String>()
        minFreq.forEachIndexed { i, v ->
            repeat(v) {
                ret += ('a' + i).toString()
            }
        }
        return ret
    }
}