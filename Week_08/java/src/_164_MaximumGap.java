import java.util.Arrays;

public class _164_MaximumGap {
    class Solution {
        public int maximumGap(int[] nums) {
            if (nums == null || nums.length < 2) return 0;
            final int maxVal = Arrays.stream(nums).max().getAsInt(), n = nums.length;
            int[] buf = new int[n];
            for (int div = 1; div <= maxVal; div *= 10) {
                int[] buckets = new int[10];
                for (int it : nums) {
                    buckets[it / div % 10]++;
                }
                for (int i = 1; i < 10; i++) {
                    buckets[i] += buckets[i - 1];
                }
                for (int i = n - 1; i >= 0; i--) {
                    buf[--buckets[nums[i] / div % 10]] = nums[i];
                }
                System.arraycopy(buf, 0, nums, 0, n);
            }
            int ret = 0;
            for (int i = 1; i < n; i++) {
                ret = Math.max(ret, nums[i] - nums[i - 1]);
            }
            return ret;
        }
    }
}
