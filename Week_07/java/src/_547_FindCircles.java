/**
 * 第一遍：2020/07/02周四 ✅
 * 第二遍：2020/06/03周五 ✅
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _547_FindCircles {
    //时间O(m^2)空间O(m)
    public int findCircleNum(int[][] M) {

        int m = M.length;
        int ret = 0;
        boolean[] visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                ret++;
            }
        }
        return ret;
    }

    void dfs(int[][] M, int i, boolean[] visited) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1) {
                dfs(M, j, visited);
            }
        }
    }

    //    时间O(m^3)空间O(m)
    public int findCircleNum2(int[][] M) {
        if (M == null) {
            return 0;
        }

        int m = M.length;
        UnionFind uf = new UnionFind(m);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}