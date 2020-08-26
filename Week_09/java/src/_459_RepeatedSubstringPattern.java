/**
 * 第一遍：2020/08/24周一 ✅
 * 第二遍：2020/08/24周二 ✅
 * 第三遍：2020/08/24周三 ✅
 * 第四遍：2020/06/13周六
 */
class _459_RepeatedSubstringPattern {
    //时间：O(n^2) 空间：O(1)
    public boolean repeatedSubstringPattern(String s) {
        if (s == null) return false;
        int n = s.length();
        for (int i = 1; i <= (n >> 1); i++) {
            if ((n % i == 0)) {
                int j = i;
                while (j < n && s.charAt(j) == s.charAt(j - i)) {
                    j++;
                }
                if (j == n) {
                    return true;
                }
            }
        }
        return false;
    }

    class SolutionKMP {
        // 时间O(n) 空间O(n)
        public boolean repeatedSubstringPattern(String s) {
            if (s == null) return false;
            int m = s.length();
            int[] lps = new int[m];
            int j = 0;
            int i = 1;
            while (i < m) {
                if (s.charAt(i) == s.charAt(j)) {
                    lps[i++] = ++j;
                } else if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i++] = 0;
                }
            }

            return j != 0 && m % (m - j) == 0;
        }

    }
}