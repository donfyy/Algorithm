/**
 * 第一遍：2020/05/21周四 ✅
 * 第二遍：2020/06/01周一 ✅
 * 第三遍：2020/08/13周四 ✅
 * 第四遍：2020/06/11周四
 */
class _70_ClimbStairs {
    public static void main(String[] args) {
        assert new _70_ClimbStairs().climbStairsVariant(0) == -1;
        assert new _70_ClimbStairs().climbStairsVariant(1) == 1;
        assert new _70_ClimbStairs().climbStairsVariant(2) == 1;
        assert new _70_ClimbStairs().climbStairsVariant(3) == 2;
        assert new _70_ClimbStairs().climbStairsVariant(4) == 1;
        assert new _70_ClimbStairs().climbStairsVariant(5) == 1;
        assert new _70_ClimbStairs().climbStairsVariant(6) == 2;
    }
    //相邻两步不能相同
    //dp[i][0]爬一阶到i的方法数
    //dp[i][1]爬两阶到i的方法数
    //dp[i][0] + dp[i][1]爬到i阶的方法数
    //dp[i][0] = dp[i - 1][1]    dp[i][1] = dp[i - 2][0]
    //dp[1][0] = 1, dp[1][1] = 0, dp[2][0] = 0, dp[2][1] = 1
    //3的倍数都是2种方法，其他都是1种方法
    //花了两个小时，还是画图能帮助理解。
    public int climbStairsVariant(int n) {
         if (n < 1) {
            return -1;
        }
        if (n < 2) {
            return 1;
        }
        int[][] dp = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
        int i_1 = 1;
        for (int i = 3; i <= n; i++) {
            int i_2 = i_1 ^ 1;
            dp[i_2][1] = dp[i_2][0];
            dp[i_2][0] = dp[i_1][1];
            i_1 = i_2;
        }
        return dp[i_1][0] + dp[i_1][1];
    }
    /**
     * 自底向上的循环，递推，动态规划。递归会超时。
     * 时间:O(n),空间:O(1)
     */
    public int climbStairs(int n) {
        if (n < 1) {
            return -1;
        }
        if (n < 2) {
            return 1;
        }
        int fn = 1, fn_1 = 1, fn_2 = 1;
        for (int i = 2; i <= n; i++) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }
}