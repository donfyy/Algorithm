/**
 * 第一遍：2020/07/07周二 ✅
 * 第二遍：2020/07/08周四 ✅
 * 第三遍：2020/07/13周一 ✅
 * 第二遍：2020/07/06周一
 * 第二遍：2020/07/03周五
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _338_CountingBits {
    public int[] countBits(int num) {
        if (num < 0) return new int[0];
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i & i - 1] + 1;
        }
        return dp;
    }
}