package twosum;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class _18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i <= n - 4; i++) {
            if (nums[i] > 0 && nums[i] > target) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int t2 = target - nums[i];
            for (int j = i + 1; j <= n - 3; j++) {
                if (nums[j] > 0 && nums[j] > t2) break;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = n - 1;
                while (l < r) {
                    int val = t2 - nums[j] - nums[l] - nums[r];
                    if (val == 0) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r])); 
                        while (l < r && nums[l++] == nums[l]);
                        while (l < r && nums[r--] == nums[r]);
                    }   else if (val < 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return ret;
    }
}