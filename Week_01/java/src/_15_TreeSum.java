import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

                    while (l < r && nums[l] == nums[++l]);
                    while (l < r && nums[r] == nums[--r]);
                } else if (sum > 0) {
                    while (l < r && nums[r] == nums[--r]);
                } else {
                    while (l < r && nums[l] == nums[++l]);
                }
            } 
        }
        return ret;
    }
}