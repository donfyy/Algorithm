/**
 * 第一遍：2020/07/30周四 ✅
 * 第二遍：2020/07/30周五 ✅
 * 第三遍：2020/07/29周三
 * 第四遍：2020/07/05周日
 * 重点掌握朴素的动态规划和数学归纳法，我感到极限呀。。。
 */
class _343_IntegerBreak {
    public int integerBreak(int n) {
        //f(n) 表示n可以获得的最大乘积
        //f(n) = max(k * (n - k) , f(n - k) * k) k in [1, n - 1]
        //f(2) = max(1 * (2 - 1), f(2 - 1) * 1) f(1) = 0
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    class SolutionGreedy {
        public int integerBreak(int n) {
            if (n < 4) {
                return n - 1;
            }
            int quotient = n / 3;
            int remainder = n % 3;
            if (remainder == 0) {
                return (int) Math.pow(3, quotient);
            }
            if (remainder == 1) {
                return (int) Math.pow(3, quotient - 1) * 4;
            }
            return (int) Math.pow(3, quotient) * 2;
        }
    }
}