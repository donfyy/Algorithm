/**
 * 第一遍：2020/07/16周五 ✅
 * 第二遍：2020/07/15周三
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >>> 1);
            if (nums[m] == target) return m;
            if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }
        return l;
    }

    class SolutionWithRecursion {
        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length == 0) return 0;
            return recursion(nums, 0, nums.length - 1, target);
        }

        int recursion(int[] nums, int l, int r, int target) {
            if (l > r) return l;
            int m = l + ((r - l) >>> 1);
            if (nums[m] == target) return m;
            if (nums[m] > target) {
                return recursion(nums, l, m - 1, target);
            }
            return recursion(nums, m + 1, r, target);
        }
    }
}