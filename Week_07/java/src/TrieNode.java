class TrieNode {
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

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
