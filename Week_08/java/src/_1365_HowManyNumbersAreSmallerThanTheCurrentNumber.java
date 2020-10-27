import java.util.Arrays;
import java.util.HashMap;

public class _1365_HowManyNumbersAreSmallerThanTheCurrentNumber {
    class Solution {
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
}
