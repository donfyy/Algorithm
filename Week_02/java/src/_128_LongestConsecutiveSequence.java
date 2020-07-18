import java.util.HashSet;

/**
 * 第一遍：2020/07/18周六 ✅
 * 第二遍：2020/07/17周五
 * 第三遍：2020/07/18周六
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int v : nums) {
            set.add(v);
        }
        int ret = 0;
        for (int x : nums) {
            if (set.contains(x - 1)) continue;
            int y = x + 1;
            while (set.contains(y)) y++;
            ret = Math.max(ret, y - x);
        }
        return ret;
    }
}