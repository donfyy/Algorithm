/**
 * 第一遍：2020/06/15周三 ✅
 * 第二遍：2020/07/15周三 ✅
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _14_LongestCommonPrefix {
    //第一印象想到的解法，取出第一个字符串，然后从头开始取出每一个位置i处的字符c，遍历剩下的字符串比较i处的字符串是否相同，用了15分钟。
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String first = strs[0];
        int idx = 0;
        out:
        while (idx < first.length()) {
            char c = first.charAt(idx);
            for (int i = 1; i < strs.length; i++) {
                String s = strs[i];
                if (idx == s.length() || c != s.charAt(idx)) break out;
            }
            idx++;
        }
        return first.substring(0, idx);
    }

    class SolutionWithTrie {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            Trie trie = new Trie();
            for (String str : strs) {
                if (str.length() == 0) return "";
                trie.insert(str);
            }

            return trie.commonPrefix();
        }

        class Trie {
            Trie[] children = new Trie[26];
            int idx;
            int count;
            boolean isEnd;

            void insert(String str) {
                Trie node = this;
                for (int i = 0; i < str.length(); i++) {
                    int idx = str.charAt(i) - 'a';
                    if (node.children[idx] == null) {
                        node.children[idx] = new Trie();
                        node.count++;
                        node.idx = idx;
                    }
                    node = node.children[idx];
                }
                node.isEnd = true;
            }

            String commonPrefix() {
                StringBuilder sb = new StringBuilder();
                Trie node = this;
                while (!node.isEnd && node.count == 1) {
                    sb.append((char) (node.idx + 'a'));
                    node = node.children[node.idx];
                }
                return sb.toString();
            }
        }
    }
}