import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 第一遍：2020/07/02周四 ✅
 * 第二遍：2020/07/03周五 ✅
 * 第三遍：2020/09/13周日 ✅
 * 第四遍：2020/07/05周日
 * 小技巧：dx和dy的应用使得代码更加简洁美观易读, StringBuilder的应用使得性能提升了一倍，发现一个单词时修改trie树避免了使用set去判重
 * dfs的时间复杂度O(M * N * 3 ^ K)K 表示单词的平均长度 MN分别表示board的行数和列数。构建trie的时间复杂度O(H * K) H表示单词的个数
 * 总的时间复杂度为O(max(M * N * 3 ^ K, H * K))
 * 空间复杂度O(H * K) dfs的空间复杂度为K可以忽略。
 * 如果是工业级应用还可以使用剪纸的方法，每找到一个叶子节点就删掉一个叶子节点
 */
class _212_WordSearchII {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words == null || words.length == 0) {
            return Collections.emptyList();
        }
        //构建trie树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        //dfs board
        List<String> ret = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie.root, ret, sb);
            }
        }

        return ret;
    }

    void dfs(char[][] board, int i, int j, TrieNode node, List<String> set, StringBuilder word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '@') {
            return;
        }
        if (!node.containsKey(board[i][j])) {
            return;
        }
        TrieNode currNode = node.get(board[i][j]);
        word.append(board[i][j]);
        if (currNode.isEnd()) {
            set.add(word.toString());
            currNode.setEnd(false);
        }

        char temp = board[i][j];
        board[i][j] = '@';
        for (int k = 0; k < dx.length; k++) {
            dfs(board, i + dx[k], j + dy[k], currNode, set, word);
        }
        // dfs(board, i - 1, j, currNode, set, word);
        // dfs(board, i + 1, j, currNode, set, word);
        // dfs(board, i, j - 1, currNode, set, word);
        // dfs(board, i, j + 1, currNode, set, word);
        word.deleteCharAt(word.length() - 1);
        board[i][j] = temp;
    }
}