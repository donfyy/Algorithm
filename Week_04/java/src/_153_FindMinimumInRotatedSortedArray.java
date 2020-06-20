/**
 * 第一遍：2020/06/20周六 ✅
 * 第二遍：2020/06/13周六
 * 第二遍：2020/06/12周二
 * 第三遍：2020/06/18周四
 * 第四遍：2020/07/02周四
 */
class _153_FindMinimumInRotatedSortedArray {
    /**
     * 剑指offer的写法，对于排序数组本身不用在执行二分查找了。
     */
    public int findMin(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int l = 0;
        int h = nums.length - 1;
        int m = l;
        while (nums[l] > nums[h]) {
            if (l == h - 1) {
                m = h;
                break;
            }
            m = l + ((h - l) >>> 1);

            if (nums[m] > nums[l]) {
                l = m;
            } else {
                h = m;
            }
        }
        return nums[m];
    }

    /**
     * 这种解法简洁，但是对于排序数组本身仍然要执行一次二分查找
     */
    public int findMin1(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + ((h - l) >>> 1);
            if (nums[m] > nums[h]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return nums[l];
    }

    /**
     * 放上自己的冗余代码，卧薪尝胆
     */
    public int findMin2(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int l = 0, h = nums.length - 1;
        while (l < h - 1) {
            int m = l + ((h - l) >>> 1);
            int val = nums[m];
            if (val > nums[l] && val > nums[h]) {
                l = m;
            } else {
                h = m;
            }
        }
        return l == h - 1 ? (Math.min(nums[l], nums[h])) : nums[l];
    }
}