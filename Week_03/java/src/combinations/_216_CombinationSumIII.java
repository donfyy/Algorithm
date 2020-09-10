package combinations;

import java.util.ArrayList;
import java.util.LinkedList;
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
public class _216_CombinationSumIII {
    // 时间O(2^10) == O(1) 空间 O(1)
    static class 纵 {
        List<List<Integer>> ret = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            dfs(1, n, k);
            return ret;
        }

        void dfs(int i, int n, int k) {
            if (n == 0 && k == 0) {
                ret.add(new ArrayList<>(path));
                return;
            }
            if (k <= 0 || i > n || i == 10) return;
            path.offerLast(i);
            dfs(i + 1, n - i, k - 1);
            path.pollLast();
            dfs(i + 1, n, k);
        }
    }

    // 时间O(10^10) == O(1) 空间 O(1)
    static class 横 {
        List<List<Integer>> ret = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            dfs(1, n, k);
            return ret;
        }

        void dfs(int start, int n, int k) {
            if (n == 0 && k == 0) {
                ret.add(new ArrayList<>(path));
                return;
            }
            if (k <= 0) return;
            for (int i = start; i <= 9; i++) {
                if (i > n) return;
                path.offerLast(i);
                dfs(i + 1, n - i, k - 1);
                path.pollLast();
            }
        }
    }
}
