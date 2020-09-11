package combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 第一遍：2020/09/09周三 ✅
 * 第二遍：2020/09/10周三 ✅
 * 第三遍：2020/09/11周三 ✅
 * 第四遍：2020/06/28周日
 */
public class _39_CombinationSum {
    static class Solution1 {
        // 时间O(n * 2^n) 空间O(target)
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> ret = new ArrayList<>();
            dfs(candidates, 0, path, target, ret);
            return ret;
        }

        void dfs(int[] arr, int i, List<Integer> path, int target, List<List<Integer>> ret) {
            if (i == arr.length) return;
            if (target == 0) {
                ret.add(new ArrayList<>(path));
                return;
            }

            if (arr[i] <= target) {
                path.add(arr[i]);
                dfs(arr, i, path, target - arr[i], ret);
                path.remove(path.size() - 1);
            }
            dfs(arr, i + 1, path, target, ret);
        }
    }

    static class Solution2 {
        // 时间O(n * n^target) 空间O(target)
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> ret = new ArrayList<>();
            dfs(candidates, 0, path, target, ret);
            return ret;
        }

        void dfs(int[] arr, int start, List<Integer> path, int target, List<List<Integer>> ret) {
            if (target == 0) {
                ret.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i < arr.length; i++) {
                if (target < arr[i]) continue;
                path.add(arr[i]);
                dfs(arr, i, path, target - arr[i], ret);
                path.remove(path.size() - 1);
            }
        }
    }
}
