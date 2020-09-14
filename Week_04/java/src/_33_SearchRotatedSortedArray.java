/**
 * 第一遍：2020/09/13周日 ✅
 * 第二遍：2020/06/21周日
 * 第二遍：2020/06/12周二
 * 第三遍：2020/06/18周四
 * 第四遍：2020/07/02周四
 */
class _33_SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l + ((h - l) >>> 1);
            int v = nums[m];
            if (v == target) return m;
            if (v >= nums[l]) {
                if (target >= nums[l] && target < v) h = m - 1; else l = m + 1;
            } else {
                if (target >= nums[l] || target < v) h = m - 1; else l = m + 1;
            }
        }
        return -1;
    }
}