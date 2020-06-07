import java.util.Random;

/**
 * 这一题在剑指offer上读过，所以下面两种解法就直接写出来了。
 * 使用partition函数需要修改原来的数组，并且时间复杂度不稳定。使用计数法则不用
 * 第一遍：2020/06/07周日 ✅
 * 第二遍：2020/06/08周一
 * 第三遍：2020/06/14周日
 * 第四遍：2020/06/28周日
 */
class _169_MajorityElements {
    /**
     * 时间O(n)
     * 空间O(1)
     */
    public int majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int current = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (current == nums[i]) {
                count++;
            } else {
                if (--count == 0) {
                    current = nums[i];
                    count = 1;
                }
            }

        }

        return current;
    }

    /**
     * 时间O(n)最坏O(n^2)
     * 空间O(1)
     */
    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = nums.length - 1;
        int idx = partition(nums, start, end);

        int mid = nums.length >>> 1;
        while (idx != mid) {
            if (idx > mid) {
                end = mid;
            } else {
                start = mid;
            }

            idx = partition(nums, start, end);
        }

        return nums[idx];
    }

    /**
     * 时间O(n)最坏O(n^2)
     * 空间O(logn)最坏O(n)
     */
    int dfs(int[] nums, int start, int end, int mid) {
        int idx = partition(nums, start, end);
        if (idx == mid) return idx;
        if (idx < mid) return dfs(nums, idx + 1, end, mid);
        else return dfs(nums, start, idx - 1, mid);
    }

    int partition(int[] nums, int start, int end) {
        int idx = new Random().nextInt(end - start) + start;
        swap(nums, idx, end);

        idx = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                if (++idx != i) {
                    swap(nums, idx, i);
                }
            }
        }
        swap(nums, ++idx, end);

        return idx;
    }

    void swap(int[] nums, int l, int r) {
        if (l == r) return;
        nums[l] = nums[l] ^ nums[r];
        nums[r] = nums[l] ^ nums[r];
        nums[l] = nums[l] ^ nums[r];
    }
}