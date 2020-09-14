/**
 * 第一遍：2020/09/13周日 ✅
 * 第二遍：2020/06/21周日
 * 第二遍：2020/06/12周二
 * 第三遍：2020/06/18周四
 * 第四遍：2020/07/02周四
 */
public class _81_SearchInRotatedSortedArrayII {
    static class BinarySearch {
        public boolean search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int m = (l + r) >>> 1;
                if (target == nums[m]) return true;
                if (nums[m] > nums[r]) {
                    if (target >= nums[l] && target < nums[m]) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                } else if (nums[m] < nums[r]) {
                    if (target > nums[m] && target <= nums[r]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                } else {
                    if (nums[m] > nums[l]) {
                        if (target < nums[m]) {
                            r = m - 1;
                        } else {
                            l = m + 1;
                        }
                    } else if (nums[m] < nums[l]) {
                        r = m - 1;
                    } else {
                        r--;
                    }
                }
            }
            return false;
        }
    }
}
