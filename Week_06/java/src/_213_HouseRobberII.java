/**
 * 第一遍：2020/07/29周三 ✅
 * 第二遍：2020/06/29周一
 * 第三遍：2020/07/29周三
 * 第四遍：2020/07/05周日
 */
class _213_HouseRobberII {
    public int rob(int[] nums) {
        //[0, n - 1] Max([0, n - 2], [1, n - 1])
        //f(i) 表示[0, i]偷到的最大金额
        //f(i) = max(f(i - 1), f(i - 2) + nums[i])
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        return n == 1 ? nums[0] : Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int left_2 = 0;
        int left_1 = 0;
        for (int i = start; i <= end; i++) {
            int dp = Math.max(left_1, left_2 + nums[i]);
            left_2 = left_1;
            left_1 = dp;
        }
        return left_1;
    }
}