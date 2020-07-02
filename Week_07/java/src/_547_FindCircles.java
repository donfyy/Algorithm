/**
 * 第一遍：2020/07/02周一 ✅
 * 第二遍：2020/06/30周二
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _547_FindCircles {
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
}