package permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 第一遍：2020/09/10周三 ✅
 * 第二遍：2020/09/11周四 ✅
 * 第二遍：2020/09/19周六 ✅
 * 第三遍：2020/06/18周四
 * 第四遍：2020/07/02周四
 * 交换法：
 * 把求序列的排列看成两步
 * 第一步，求出现在第一个位置上的元素，就是将第一个元素与后面的所有元素进行交换
 * 第二步，固定第一个元素，求后面所有元素的排列
 * 先求出出现在第一个位置的所有字符，即将第一个字符与后面所有的字符交换位置。
 * 然后再求出后面整个字符串的排列。
 * 需要多过下遍数
 */
public class _47_PermutationsII {
    static class UsingSwap {
        // O(n * n!) O(n)
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            dfs(nums, 0, ret);
            return ret;
        }

        void dfs(int[] nums, int start, List<List<Integer>> ret) {
            if (start == nums.length - 1) {
                ret.add(toList(nums));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if (duplicate(nums, start, i)) continue;
                swap(nums, start, i);
                dfs(nums, start + 1, ret);
                swap(nums, start, i);
            }
        }

        List<Integer> toList(int[] nums) {
            List<Integer> list = new ArrayList(nums.length);
            for (int num : nums) {
                list.add(num);
            }
            return list;
        }

        boolean duplicate(int[] nums, int start, int i) {
            for (int j = start; j < i; j++) {
                if (nums[j] == nums[i]) {
                    return true;
                }
            }
            return false;
        }

        void swap(int[] nums, int i, int j) {
            if (i != j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
    }
    static class UsingSelection {
        // O(n * n!) O(n)
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            List<Integer> path = new ArrayList<>(nums.length);
            boolean[] vis = new boolean[nums.length];
            Arrays.sort(nums);
            dfs(nums, vis, path, ret);
            return ret;
        }
        void dfs(int[] nums, boolean[] vis, List<Integer> path, List<List<Integer>> ret) {
            if (path.size() == nums.length) {
                ret.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) continue;
                vis[i] = true;
                path.add(nums[i]);
                dfs(nums, vis, path, ret);
                path.remove(path.size() - 1);
                vis[i] = false;
            }
        }
    }
}
