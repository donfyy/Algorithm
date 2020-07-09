/**
 * 第一遍：2020/07/09周四 ✅
 * 第二遍：2020/06/28周日
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 * 想到了状态表示，没有想到状态转移方程，也想到了用trie树，没有想到逆序建立trie树。好精妙
 * 还有一种方法叫字符串哈希可以参考 1392最长快乐前缀 Rabin-Karp方法
 */
class _17_13_ReSpaceLcci {
    public int respace(String[] dictionary, String sentence) {
        //f(i) 到第i个字符为止的字符串未识别的字符数

        Trie root = new Trie();
        for (String word : dictionary) {
            root.insert(word);
        }
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; 
            Trie node = root;
            for (int j = i; j > 0; j--) {
                char c = sentence.charAt(j - 1);
                Trie next = node.children[c - 'a'];
                if (next == null) {
                    break;
                }
                if (next.isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                node = next;
            }     
        }
        return dp[n];
    }

    class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd;

        void insert(String word) {
            Trie node = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                Trie next = node.children[c - 'a'];
                if (next == null) {
                    next = new Trie();
                    node.children[c - 'a'] = next;
                }
                node = next;
            }
            node.isEnd = true;
        }
    }
}