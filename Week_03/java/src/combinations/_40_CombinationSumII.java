package combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 第一遍：2020/09/10周三 ✅
 * 第二遍：2020/09/10周三
 * 第三遍：2020/06/14周日
 * 第四遍：2020/06/28周日
 * 佩服佩服，多多练习。
 * 这两种方法都挺妙的，从不同的角度去考虑问题。
 * 纵：考虑每一个元素选还是不选
 * 横：一次性考虑多个元素
 */
public class _40_CombinationSumII {
    // 时间 O(n * 2^n) 空间 O(n)
    static class 纵 {
        List<List<Integer>> ret = new ArrayList<>();
        List<int[]> freq = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            for (int candidate : candidates) {
                if (freq.isEmpty() || candidate != freq.get(freq.size() - 1)[0]) {
                    freq.add(new int[]{candidate, 1});
                } else {
                    freq.get(freq.size() - 1)[1]++;
                }
            }
            dfs(0, target);
            return ret;
        }

        void dfs(int i, int target) {
            if (target == 0) {
                ret.add(new ArrayList<>(path));
                return;
            }
            if (i == freq.size() || freq.get(i)[0] > target) return;
            dfs(i + 1, target);
            int num = freq.get(i)[0];
            int most = Math.min(target / num, freq.get(i)[1]);
            for (int j = 1; j <= most; j++) {
                path.add(num);
                target -= num;
                dfs(i + 1, target);
            }
            for (int j = 1; j <= most; j++) {
                path.remove(path.size() - 1);
            }
        }
    }
    // 时间 O(n * n^target) 空间 O(target)
    static class 横 {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(0, candidates, target);
            return ret;
        }

        void dfs(int start, int[] arr, int rest) {
            if (rest == 0) {
                ret.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i < arr.length; i++) {
                if (arr[i] > rest) return;
                if (i > start && arr[i] == arr[i - 1]) continue;
                path.add(arr[i]);
                dfs(i + 1, arr, rest - arr[i]);
                path.remove(path.size() - 1);
            }
        }
    }
}
