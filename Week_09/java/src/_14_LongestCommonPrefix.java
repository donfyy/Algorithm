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
}