package longestpalindromicsubstring;

/**
 * 第一遍：2020/08/19周三 ✅
 * 第二遍：2020/08/20周四 ✅
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 * todo Manacher算法
 */
class _647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null) return 0;
        int n = s.length();
        int ret = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i >> 1;
            int r = l + (i & 1);
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                ret++;
            }
        }
        return ret;
    }

    class SolutionDP {
        public int countSubstrings(String s) {
            //f(i, j) 表示闭区间[i, j]的子串是否是回文串
            //f(i, j) = f(i + 1, j - 1) && s[i] == s[j]
            //i in [0, n - 1], j in [0, n - 1]
            int n = s.length();
            boolean[] dp = new boolean[n];
            int ret = 0;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= i; j--) {
                    dp[j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[j - 1]);
                    if (dp[j]) {
                        ret++;
                    }
                }
            }
            return ret;
        }
    }
}