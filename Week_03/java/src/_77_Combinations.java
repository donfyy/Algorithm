import java.util.ArrayList;
import java.util.Collections;
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
        List<List<Integer>> ret;
        List<Integer> path = new ArrayList<>();
        int k;
        int n;

        public List<List<Integer>> combine(int n, int k) {
            if (k > n) return Collections.emptyList();
            ret = new ArrayList<>();
            this.k = k;
            this.n = n;
            dfs(1);
            return ret;
        }

        void dfs(int i) {
            if (path.size() + n - i + 1 < k) return;
            if (path.size() == k) {
                ret.add(new ArrayList<>(path));
                return;
            }
            path.add(i);
            dfs(i + 1);
            path.remove(path.size() - 1);
            dfs(i + 1);
        }
    }
}
