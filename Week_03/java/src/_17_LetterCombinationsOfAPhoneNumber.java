import java.util.*;

/**
 * 第一遍：2020/06/06周五 ✅
 * 第二遍：2020/06/07周日
 * 第三遍：2020/06/13周五
 * 第四遍：2020/06/27周五
 */
class _17_LetterCombinationsOfAPhoneNumber {
    String[] map = new String[]{
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return Collections.emptyList();


        List<String> ret = new LinkedList<>();
        dfs(digits, 0, new StringBuilder(), ret);
        return ret;
    }

    /**
     * 使用数组实现一个简单的哈希表将执行速度从1ms降低到0ms
     *
     * @param digits
     * @param level
     * @param path   使用StringBuilder来保存路径 执行速度从7ms降低到1ms
     * @param ret
     */
    private void dfs(String digits, int level, StringBuilder path, List<String> ret) {
        if (digits.length() == level) {
            ret.add(path.toString());
            return;
        }

        int idx = (digits.charAt(level)) - '2';
        if (idx >= map.length) {
            return;
        }
        String combinations = map[idx];

        for (int i = 0; i < combinations.length(); i++) {
            dfs(digits, level + 1, path.append(combinations.charAt(i)), ret);
            path.deleteCharAt(path.length() - 1);
        }

    }

    private void dfs(String digits, int level, String path, List<String> ret) {
        if (digits.length() == level) {
            ret.add(path);
            return;
        }

        int idx = (digits.charAt(level)) - '2';
        if (idx >= map.length) {
            return;
        }
        String combinations = map[idx];


        for (int i = 0; i < combinations.length(); i++) {
            dfs(digits, level + 1, path + (combinations.charAt(i)), ret);
        }

    }

    /**
     * 7ms
     */
    public List<String> letterCombinationsBfs(String digits) {
        if (digits == null || digits.length() == 0) return Collections.emptyList();


        LinkedList<String> queue = new LinkedList<>();

        queue.offerLast("");
        for (int i = 0; i < digits.length(); i++) {
            int mIdx = digits.charAt(i) - '2';
            if (mIdx >= map.length) {
                return Collections.emptyList();
            }
            while (queue.peekFirst().length() == i) {
                String path = queue.pollFirst();


                String comb = map[mIdx];
                for (int j = 0; j < comb.length(); j++) {
                    queue.offerLast(path + comb.charAt(j));
                }

            }
        }
        return queue;
    }

}