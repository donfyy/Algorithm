/**
 * 第一遍：2020/07/19周日 ✅
 * 第二遍：2020/07/19周日
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 * todo Manacher算法
 */
class _5_LongestPalindromicSubstring {
    //时间O(n^2) 空间O(n)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        //f(i, j)表示字符串s在闭区间[i, j]上的子串是否为会问子串
        //f(i, j) = f(i + 1, j - 1) && s[i] == s[j]
        //if (i == j) f(i, j) = true; if (i == j - 1) f(i, j) = s[i] == s[j]
        int n = s.length();
        boolean[] dp = new boolean[n];
        int l = 0, r = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                dp[j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[j - 1]);
                if (dp[j] && j - i > r - l) {
                    l = i;
                    r = j;
                }
            }
        }
        return s.substring(l, r + 1);
    }
    class Solution {
        //时间O(n^2) 空间O(1)
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) return s;
            int l = 0, r = 0;// r exclusive
            for (int i = 0; i < s.length(); i++) {
                int len = expandPalindrome(s, i, i);
                int len1 = expandPalindrome(s, i, i + 1);
                len = Math.max(len, len1);
                if (len > r - l) {
                    l = i - (len - 1 >>> 1);
                    r = l + len;
                }
            }
            return s.substring(l, r);
        }

        int expandPalindrome(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return r - l - 1;
        }
    }
}