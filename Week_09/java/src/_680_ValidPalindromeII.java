/**
 * 第一遍：2020/07/18周六 ✅
 * 第二遍：2020/07/16周三
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _680_ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        return recur(s, 0, s.length() - 1, false);
    }

    boolean recur(String s, int l, int r, boolean deleted) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (deleted) return false;
                return recur(s, l + 1, r, true) || recur(s, l, r - 1, true);
            }
            l++;
            r--;
        }
        return true;
    }
}