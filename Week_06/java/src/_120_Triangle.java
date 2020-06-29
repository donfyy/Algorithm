import java.util.List;
/**
 * 第一遍：2020/06/26周五 ✅
 * 第二遍：2020/06/27周六 ✅
 * 第三遍：2020/06/28周日 ✅
 * 第四遍：2020/06/29周一 ✅
 * 第四遍：2020/07/05周日
 * 自顶向下的代码冗长，且性能比自底向上的代码略逊一筹，其多用了O(n)的时间找最小路径，因为多计算了O(n-1)个节点。
 */
class _120_Triangle {
    //自底向上不修改原列表 时间O(n^2) 空间O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        //f(i, j)表示到达i层第j个节点的最小路径和
        //f(i, j) = Min(f(i + 1, j), f(i + 1, j + 1)) + value(i, j)
        if (triangle == null || triangle.isEmpty()) {
            return -1;
        }
        int m = triangle.size();
        int[] dp = new int[m + 1];
        for (int level = m - 1; level >= 0; level--) {
            List<Integer> list = triangle.get(level);
            for (int i = 0; i < list.size(); i++) {
                dp[i] = list.get(i) + Math.min(dp[i], dp[i + 1]);
            }
        }
        return dp[0];
    }
    //自底向上并且修改输入原列表 时间O(n^2) 空间O(1)
    public int minimumTotal2(List<List<Integer>> triangle) {
        //bottom up && modify triangle
        for (int level = triangle.size() - 2; level >= 0; level--) {
            List<Integer> row = triangle.get(level);
            List<Integer> bottomRow = triangle.get(level + 1);
            for (int i = 0; i < row.size(); i++) {
                row.set(i, Math.min(bottomRow.get(i), bottomRow.get(i + 1)) + row.get(i));
            }
        }
        return triangle.get(0).get(0);
    }
    //自顶向下并且修改原列表 时间O(n^2) 空间O(1)
    public int minimumTotal3(List<List<Integer>> triangle) {
        //top to bottom && modify triangle
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            List<Integer> topRow = triangle.get(i - 1);
            for (int j = 0; j < row.size(); j++) {
                if (j == 0) {
                    row.set(j, topRow.get(j) + row.get(j));
                } else if (j == row.size() - 1) {
                    row.set(j, topRow.get(j - 1) + row.get(j));
                } else {
                    row.set(j, Math.min(topRow.get(j), topRow.get(j - 1)) + row.get(j));
                }
            }
        }

        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        int ret = lastRow.get(0);
        for (int i = 1; i < lastRow.size(); i++) {
            if (lastRow.get(i) < ret) {
                ret = lastRow.get(i);
            }
        }
        return ret;
    }
    //自顶向下，不修改原列表 时间O(n^2) 空间O(n)
    public int minimumTotal4(List<List<Integer>> triangle) {
        //dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + value[i][j]
        int m = triangle.size();
        int[] dp = new int[m];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            List<Integer> row = triangle.get(i);

            for (int j = row.size() - 1; j >= 0; j--) {
                if (j == row.size() -1) {
                    dp[j] = dp[j-1] + row.get(j);
                } else if (j == 0) {
                    dp[j] = dp[j] + row.get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + row.get(j);
                }
            }
        }
        int ret = dp[0];
        for (int i = 1; i < m; i++) {
            if (dp[i] < ret) {
                ret = dp[i];
            }
        }
        return ret;
    }
}