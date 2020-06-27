/**
 * 第一遍：2020/06/27周六 ✅
 * 第二遍：2020/06/27周六 
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 * 这个题目要多多回顾，这个状态表示对我来说稍微有点绕。。。
 */
class _53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        //f(i)到第i个元素为止的连续子数组  的最大和
        //f(i) = max(f(i-1), 0) + value(i)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ret = nums[0];
        int dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp, 0) + nums[i];
            ret = Math.max(ret, dp);
        }
        return ret;
    }

    // TODO: 2020/6/27 使用线段树的分治法
    // TODO: 2020/6/27 剑指offer给出了一种非动态规划的解法
}