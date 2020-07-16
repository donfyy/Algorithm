import java.util.LinkedList;

/**
 * 第一遍：2020/07/16周四 ✅
 * 第二遍：2020/07/16周四
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _785_IsGraphBipartite {
    //2ms
    //时间复杂度O(N + M)N：表示点数 M：表示边数 空间O(N)  为什么时间复杂度要加上边数？
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return false;
        int length = graph.length;
        int[] color = new int[length];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int k = 0; k < length; k++) {
            if (color[k] != 0) continue;
            color[k] = 1;
            queue.offer(k);
            while (!queue.isEmpty()) {
                int i = queue.poll();
                for (int j : graph[i]) {
                    if (color[j] == 0) {
                        color[j] = -color[i];
                        queue.offer(j);
                    } else if (color[j] == color[i]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    class Solution_DFS {
        //0ms
        public boolean isBipartite(int[][] graph) {
            if (graph == null || graph.length == 0) return false;
            int length = graph.length;
            int[] color = new int[length];
            for (int k = 0; k < length; k++) {
                if (color[k] != 0) continue;
                color[k] = 1;
                if (!dfs(graph, k, color)) return false;
            }

            return true;
        }

        boolean dfs(int[][] graph, int i, int[] color) {
            for (int j : graph[i]) {
                if (color[j] == 0) {
                    color[j] = -color[i];
                    if (!dfs(graph, j, color)) return false;
                } else if (color[j] == color[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}