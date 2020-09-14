import java.util.ArrayList;
import java.util.List;

/**
 * 第一遍：2020/09/14周一 ✅
 * 第二遍：2020/06/21周日
 * 第二遍：2020/06/12周二
 * 第三遍：2020/06/18周四
 * 第四遍：2020/07/02周四
 */
public class _77_Subsets {
    static class UsingBits {
        // 时间 O(2^n * n) 空间 O(1)
        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            int max = 1 << n;
            List<List<Integer>> ret = new ArrayList<>(max);
            for (int i = 0; i < max; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0, k = i; j < n; j++, k >>>= 1) {
                    if ((k & 1) == 1) {
                        list.add(nums[j]);
                    }
                }
                ret.add(list);
            }
            return ret;
        }
    }
}
