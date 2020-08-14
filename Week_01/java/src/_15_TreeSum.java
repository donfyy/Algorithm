import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 第一遍：2020/05/21周四 ✅
 * 第二遍：2020/05/22周五 ✅
 * 第三遍：2020/05/25周一 ✅
 * 第四遍：2020/08/13周四 ✅
 * 第五遍：2020/08/14周五 ✅
 * 排序和双指针
 */
class _15_TreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = length - 1;
            int curr = nums[i];
            while (l < r) {
                int sum = curr + nums[l] + nums[r];
                if (sum == 0) {

                    ret.add(Arrays.asList(curr, nums[l], nums[r]));

                    while (l < r && nums[l] == nums[++l]) ;
                    while (l < r && nums[r] == nums[--r]) ;
                } else if (sum > 0) {
                    while (l < r && nums[r] == nums[--r]) ;
                } else {
                    while (l < r && nums[l] == nums[++l]) ;
                }
            }
        }
        return ret;
    }
}