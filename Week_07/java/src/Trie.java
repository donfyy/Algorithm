/**
 * 第一遍：2020/06/29周一  ✅
 * 第二遍：2020/06/28周日
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }

        return true;
    }

    static class TrieNode {
        private static final int R = 26;
        private TrieNode[] children = new TrieNode[R];
        private boolean isEnd;

        public boolean containsKey(char c) {
            return children[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return children[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            children[c - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */