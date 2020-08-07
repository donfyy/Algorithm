import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 第一遍：2020/08/07周五 ✅
 * 第二遍：2020/08/04周二
 * 第三遍：2020/07/18周六
 * 第三遍：2020/07/08周四
 * 这道题目几乎花了我一天的时间，对于这种配对问题，直觉是枚举a和b，然后检查a和b是否配对。
 * 但是更好的解法是固定a然后求出可能配对的b，然后在查询b是否存在。和两数之和思路挺像的。
 * 奥利给！！！
 */
class _336_PalindromePairs {
    class Node {
        Node[] children = new Node[26];
        int idx = -1;

        void insert(String word, int idx) {
            Node n = this;
            for (int i = 0; i < word.length(); i++) {
                Node child = n.children[word.charAt(i) - 'a'];
                if (child == null) {
                    child = new Node();
                    n.children[word.charAt(i) - 'a'] = child;
                }
                n = child;
            }
            n.idx = idx;
        }

        int findWord(String word, int start, int end) {
            Node n = this;
            for (int i = end; i >= start; i--) {
                Node child = n.children[word.charAt(i) - 'a'];
                if (child == null) {
                    return -1;
                }
                n = child;
            }
            return n.idx;
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        //生成字典树
        Node trie = new Node();
        for (int i = 0; i < n; i++) {
            trie.insert(words[i], i);
        }
        //枚举每一个字符串的前缀和后缀

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int len = word.length();
            for (int j = 0; j <= word.length(); j++) {
                if (isPalindrome(word, j, len - 1)) {
                    int idx = trie.findWord(word, 0, j - 1);
                    if (idx != -1 && idx != i) {
                        ret.add(Arrays.asList(i, idx));
                    }
                }

                if (j > 0 && isPalindrome(word, 0, j - 1)) {
                    int idx = trie.findWord(word, j, len - 1);
                    if (idx != -1 && idx != i) {
                        ret.add(Arrays.asList(idx, i));
                    }
                }
            }
        }
        return ret;
    }

    boolean isPalindrome(String word, int l, int r) {
        while (l <= r && word.charAt(l) == word.charAt(r)) {
            l++;
            r--;
        }
        return l > r;
    }
}