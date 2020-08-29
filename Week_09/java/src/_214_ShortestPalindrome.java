/**
 * 第一遍：2020/08/24周二 ✅
 * 第二遍：2020/08/25周三 ✅
 * 第三遍：2020/08/25周五 ✅
 * 第四遍：2020/06/13周六
 * todo: 使用二进制位的解法
 */
class _214_ShortestPalindrome {
    private static final int D = 256;
    private static final int Q = 1000000007;

    public String shortestPalindrome(String s) {
        if (s == null || s.isEmpty()) return s;
        long u = 0, v = 0, m = 1;
        int n = s.length(), r = 0;
        for (int i = 0; i < n; i++) {
            u = (u * D + s.charAt(i)) % Q;
            v = (v + m * s.charAt(i)) % Q;
            m = m * D % Q;
            if (u == v) {
                r = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i > r; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }

    class SolutionKMP {
        public String shortestPalindrome(String s) {
            if (s == null || s.isEmpty()) return s;
            int n = s.length();
            int[] lps = new int[n + 1];
            lps[0] = -1;
            int j = 0;
            int i = 1;
            while (i < n) {
                if (s.charAt(j) == s.charAt(i)) {
                    lps[++i] = ++j;
                } else if (j != 0) {
                    j = lps[j];
                } else {
                    i++;
                }
            }
            j = 0;
            for (i = n - 1; i >= 0; i--) {
                while (j > 0 && s.charAt(j) != s.charAt(i)) {
                    j = lps[j];
                }
                if (s.charAt(j) == s.charAt(i)) {
                    j++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (i = n - 1; i >= j; i--) {
                sb.append(s.charAt(i));
            }
            sb.append(s);
            return sb.toString();
        }
    }
}