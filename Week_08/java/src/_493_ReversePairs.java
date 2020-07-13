import java.util.Arrays;
import java.util.Comparator;

/**
 * 第一遍：2020/07/12周日 ✅
 * 第二遍：2020/07/13周一 ✅
 * 第二遍：2020/07/08周四
 * 第二遍：2020/07/06周一
 * 第二遍：2020/07/03周五
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _493_ReversePairs {
    // TODO: 2020/7/12  BST 与 BIT解法
    //https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-%22Reverse-Pairs%22
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(new int[0][], Comparator.comparingInt(e -> e[0]));
        return mergeSort(nums, new int[nums.length], 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int[] cache, int left, int right) {
        if (left >= right) return 0;

        int mid = left + ((right - left) >>> 1);
        int count = mergeSort(nums, cache, left, mid) + mergeSort(nums, cache, mid + 1, right);
        int i = left, j = mid + 1, k = left, l = left;
        while (j <= right) {//统计右边子数组中每一个元素能够和左边的子数组中元素构成的翻转对的数量。
            while (l <= mid && nums[l] <= 2L * nums[j]) l++;
            count += mid + 1 - l;

            while (i <= mid && nums[i] < nums[j]) cache[k++] = nums[i++];
            cache[k++] = nums[j++];
        }

        while (i <= mid) cache[k++] = nums[i++];

        System.arraycopy(cache, left, nums, left, right - left + 1);
        return count;
    }

    class SolutionLeft {
        public int reversePairs(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            return mergeSort(nums, new int[nums.length], 0, nums.length - 1);
        }

        public int mergeSort(int[] nums, int[] cache, int left, int right) {
            if (left >= right) return 0;
            int mid = left + ((right - left) >>> 1);
            int count = mergeSort(nums, cache, left, mid) + mergeSort(nums, cache, mid + 1, right);
            int i = left, j = mid + 1, k = left, l = j;
            while (i <= mid) {//统计左边的子数组中的每一个元素能够和右边子数组中元素构成的翻转对的数量。
                while (l <= right && nums[i] > 2L * nums[l]) l++;
                count += l - (mid + 1);

                while (j <= right && nums[j] < nums[i]) cache[k++] = nums[j++];
                cache[k++] = nums[i++];
            }
            while (j <= right) cache[k++] = nums[j++];
            System.arraycopy(cache, left, nums, left, right - left + 1);
            return count;
        }
    }
}