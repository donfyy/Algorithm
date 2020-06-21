/**
 * 第一遍：2020/06/18周五 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 * 这道题加深了对贪心算法的理解。
 * 问题能够分解成子问题，子问题的最优解能递推到最终问题的最优解
 * 每一步（跳跃）都采取最优的选择。
 */
class _45_JumpGameII {
    //bfs方式的贪心
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int i = 0;
        int levelMax = 0;
        int maxPos = 0;
        int level = 0;
        out:
        while (levelMax - i + 1 > 0) {
            while (i <= levelMax) {
                maxPos = Math.max(maxPos, i + nums[i]);
                if (maxPos >= nums.length - 1) {
                    break out;
                }
                i++;
            }
            levelMax = maxPos;
            level++;
        }
        return level + 1;
    }

    public int jump1(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int nextPos = 0;
        int maxPos = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == nextPos) {
                nextPos = maxPos;
                step++;
            }
        }
        return step;
    }

    public int jump2(int[] nums) {
        //从最后一个位置开始，不断的找能够跳跃到该位置的最远位置。
        if (nums == null) {
            return 0;
        }
        int pos = nums.length - 1;
        int step = 0;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (i + nums[i] >= pos) {
                    pos = i;
                    step++;
                }
            }
        }
        return step;
    }

}