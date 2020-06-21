/**
 * 第一遍：2020/06/21周日 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 * 这道题加深了对贪心算法的理解。
 * 问题能够分解成子问题，子问题的最优解能递推到最终问题的最优解
 * 每一步（跳跃）都采取最优的选择。
 */
public class _55_JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int rightMost = 0;//到第i个元素为止能够到达的最远位置
        for (int i = 0; i < nums.length; i++) {
            if (i > rightMost) {
                return false;
            }
            rightMost = Math.max(rightMost, i + nums[i]);
        }
        return true;
    }
}
