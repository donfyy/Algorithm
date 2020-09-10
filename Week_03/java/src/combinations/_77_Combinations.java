package combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 第一遍：2020/09/08周二 ✅
 * 第二遍：2020/06/08周一
 * 第三遍：2020/06/14周日
 * 第四遍：2020/06/28周日
 * todo: 理解多种解法
 */
public class _77_Combinations {
    static class UsingSequence {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            dfs(1, n, k);
            return ret;
        }

        void dfs(int i, int n, int k) {
            if (path.size() + n + 1 - i < k) return;
            if (path.size() == k) {
                ret.add(new ArrayList<>(path));
                return;
            }
            path.add(i);
            dfs(i + 1, n, k);
            path.remove(path.size() - 1);
            dfs(i + 1, n, k);
        }
    }
}
