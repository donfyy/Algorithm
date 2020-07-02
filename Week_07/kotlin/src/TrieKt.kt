fun main() {
    var trie = TrieKt()
    trie.insert("add")
    println(trie.search("ad"))
}
class TrieKt {

    /** Initialize your data structure here. */
    val children = Array<TrieKt?>(26){null}
    var isEnd = false

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var node = this;
        for (i in word.indices) {
            val c = word[i]
            //犯错，没有调用node的children。。多花了半小时时间
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = TrieKt()
            }
            node = node.children[c - 'a']!!
        }
        node.isEnd = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var node = this
        for(i in word.indices) {
            val c = word[i]
            if (node.children[c - 'a'] == null) {
                return false
            }
            node = node.children[c - 'a']!!
        }
        return node.isEnd
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var node = this
        for (i in prefix.indices) {
            val c = prefix[i]
            if (node.children[c - 'a'] == null) {
                return false
            }
            node = node.children[c - 'a']!!
        }
        return true
    }

}