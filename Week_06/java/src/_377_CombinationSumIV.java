/**
 * 第一遍：2020/09/10周三 ✅
 * 第二遍：2020/09/10周三
 * 第三遍：2020/06/14周日
 * 第四遍：2020/06/28周日
 * 要学会画递归树找到dp的思路，现在写dp的代码基本上比较连贯了。
 * 但是出思路上还是有些欠缺。问题分析上还是欠缺。
 */
public class _377_CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        // f(i) 表示target为i的组合的个数
        // f(i) += f(i - j) j in nums
        // f(j) = 1 for j in nums
        // f(0) = 1
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
