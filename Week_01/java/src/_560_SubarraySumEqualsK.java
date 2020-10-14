import java.util.HashMap;

public class _560_SubarraySumEqualsK {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) return -1;
            int n = nums.length, s = 0, ret = 0;
            HashMap<Integer, Integer> t = new HashMap<>();
            t.put(0, 1);
            for (int num : nums) {
                s += num;
                int s1 = s - k;
                ret += t.getOrDefault(s1, 0);
                int cnt = t.getOrDefault(s, 0);
                t.put(s, cnt + 1);
            }
            return ret;
        }
    }
}
