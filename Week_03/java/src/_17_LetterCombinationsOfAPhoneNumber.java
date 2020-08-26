import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 第一遍：2020/06/06周五 ✅
 * 第二遍：2020/08/26周三 ✅
 * 第三遍：2020/06/13周五
 * 第四遍：2020/06/27周五
 */
class _17_LetterCombinationsOfAPhoneNumber {
    class SolutionDFS {
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String digits;
        List<String> ret = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) return Collections.emptyList();
            this.digits = digits;
            dfs(0);
            return ret;
        }

        void dfs(int i) {
            if (i == digits.length()) {
                ret.add(path.toString());
                return;
            }

            String comb = map[digits.charAt(i) - '2'];
            for (int j = 0; j < comb.length(); j++) {
                path.append(comb.charAt(j));
                dfs(i + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    class SolutionBFS {
        // 时间O(4^n) 空间O(n)
        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) return Collections.emptyList();
            String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            LinkedList<String> queue = new LinkedList<>();
            queue.offer("");
            for (int i = 0; i < digits.length(); i++) {
                String comb = map[digits.charAt(i) - '2'];
                while (queue.peek().length() == i) {
                    String path = queue.poll();
                    for (int j = 0; j < comb.length(); j++) {
                        queue.offer(path + comb.charAt(j));
                    }
                }
            }
            return queue;
        }
    }
}