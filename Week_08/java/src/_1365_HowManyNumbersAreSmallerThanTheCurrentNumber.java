import java.util.Arrays;
import java.util.HashMap;

public class _1365_HowManyNumbersAreSmallerThanTheCurrentNumber {
    class QuickSort {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            // 排序数组
            int[] sorted = Arrays.stream(nums).sorted().toArray();
            // 得到比当前元素小的所有数字，存放在map中
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < sorted.length; i++) {
                freq.putIfAbsent(sorted[i], i);
            }
            // 返回要求的数组
            int[] ret = new int[sorted.length];
            for (int i = 0; i < nums.length; i++) {
                ret[i] = freq.get(nums[i]);
            }
            return ret;
        }
    }

    class CountingSort {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            // 统计每个元素出现的次数
            final int n = nums.length, m = 101;
            int[] bucket = new int[m];
            for (int num : nums) {
                bucket[num]++;
            }
            // 利用前缀和的思想，计算出在[0, i]中所有元素的个数，也就是比 i + 1小的元素的个数
            for (int i = 1; i < m; i++) {
                bucket[i] += bucket[i - 1];
            }
            // 按照原数组的顺序返回元素的数目
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                ret[i] = nums[i] == 0 ? 0 : bucket[nums[i] - 1];
            }
            return ret;
        }
    }
}
