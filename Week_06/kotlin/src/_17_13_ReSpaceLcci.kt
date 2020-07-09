class _17_13_ReSpaceLcci__ {
    fun respace(dictionary: Array<String>, sentence: String): Int {
        if (dictionary.isEmpty() || sentence.isEmpty()) {
            return 0
        }
        val root = Trie()
        for (word in dictionary) {
            root.insert(word)
        }
        val n = sentence.length
        val dp = IntArray(n + 1)
        for (i in 1..n) {
            dp[i] = dp[i - 1] + 1
            var node = root
            for (j in i downTo 1) {
                val c = sentence[j - 1]
                val next = node.children[c - 'a']
                if (next == null) {
                    break
                }
                if (next.isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1])
                }
                if (dp[i] == 0) {
                    break
                }
                node = next
            }
        }
        return dp[n]
    }
    class Trie {
        val children = Array<Trie?>(26){null}
        var isEnd = false

        fun insert(word:String) {
            var node = this
            for (i in word.length - 1 downTo 0) {
                val c = word[i]
                var next = node.children[c - 'a']
                if (next == null) {
                    next = Trie()
                    node.children[c - 'a'] = next
                }
                node = next
            }
            node.isEnd = true
        }
    }
}