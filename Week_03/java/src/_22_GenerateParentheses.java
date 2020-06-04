import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 第一遍：2020/06/01周一 ✅
 * 第二遍：2020/06/02周二 ✅
 * 第三遍：2020/06/04周四 ✅
 * 第三遍：2020/06/08周一
 * 第四遍：2020/06/22周一
 */
class _22_GenerateParentheses {
    /**
     * 时间：不到O(n^2n)  空间：O(n)
     */
    public List generateParenthesis(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }

        List<String> ret = new ArrayList<>();
        dfs(0, 0, n, ret, "");
        return ret;
    }

    /**
     *
     * @param left 用掉的左括号的个数
     * @param right 用掉的右括号的个数
     * @param n 左括号与右括号的总数
     * @param ret 保存结果字符串的容器
     * @param s 当前已经生成的字符串
     */
    private void dfs(int left, int right, int n, List<String> ret, String s) {
        if (left == n && right == n) {
            ret.add(s);
            return;
        }
        if (left < n) {
            dfs(left + 1, right, n, ret, s + "(");
        }
        if (right < left) {
            dfs(left, right + 1, n, ret, s + ")");
        }
    }
}