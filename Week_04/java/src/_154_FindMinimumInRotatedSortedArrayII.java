/**
 * 第一遍：2020/09/13周日 ✅
 * 第二遍：2020/10/01周四 ✅
 * 第二遍：2020/06/12周二
 * 第三遍：2020/06/18周四
 * 第四遍：2020/07/02周四
 */
public class _154_FindMinimumInRotatedSortedArrayII {
    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length, l = 0, r = n - 1, idx = l;
            while (nums[l] >= nums[r]) {
                if (l == r - 1) {
                    idx = r;
                    break;
                }
                idx = (l + r) >>> 1;
                if (nums[idx] > nums[l]) {
                    l = idx;
                } else if (nums[idx] < nums[r]) {
                    r = idx;
                } else {
                    idx = 0;
                    for (int i = 1; i < n; i++) {
                        if (nums[i] < nums[idx]) {
                            idx = i;
                        }
                    }
                    break;
                }
            }
            return nums[idx];
        }
    }

    static class Solution2 {
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) return -1;
            int l = 0, r = nums.length - 1;
            while (l < r) {
                if (nums[r] > nums[l]) break;
                int m = (l + r) >>> 1;
                if (nums[m] > nums[l]) {
                    l = m + 1;
                } else if (nums[m] < nums[l]) {
                    r = m;
                } else if (nums[m] != nums[r]) {
                    l = m + 1;
                } else {
                    l++;
                }
            }
            return nums[l];
        }
    }
}
