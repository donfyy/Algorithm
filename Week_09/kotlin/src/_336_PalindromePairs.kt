import kotlin.collections.ArrayList

class _336_PalindromePairs_ {
    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val trie = Node()
        for (i in words.indices) {
            trie.insert(words[i], i)
        }

        val ret = ArrayList<List<Int>>()
        for (i in words.indices) {
            val word = words[i]
            val m = word.length
            for (j in 0..m) {
                if (word.isPalindrome(j, m - 1)) {
                    val idx = trie.find(word, 0, j - 1)
                    if (idx != -1 && idx != i) {
                        ret.add(listOf(i, idx))
                    }
                }
                if (j > 0 && word.isPalindrome(0, j - 1)) {
                    val idx = trie.find(word, j, m - 1)
                    if (idx != -1 && idx != i) {
                        ret.add(listOf(idx, i))
                    }
                }
            }
        }
        return ret
    }

    fun String.isPalindrome(left: Int, right: Int): Boolean {
        var l = left
        var r = right
        while (l < r && this[l] == this[r]) {
            l++
            r--
        }
        return l >= r
    }

    class Node {
        val children = Array<Node?>(26) { null }
        var idx = -1

        fun insert(word: String, idx: Int) {
            var n = this
            for (c in word) {
                n = n.children[c - 'a'] ?: Node().apply {
                    n.children[c - 'a'] = this
                }
            }
            n.idx = idx
        }

        fun find(word: String, l: Int, r: Int): Int {
            var n = this
            for (i in r downTo l) {
                n = n.children[word[i] - 'a'] ?: return -1
            }
            return n.idx
        }
    }
}