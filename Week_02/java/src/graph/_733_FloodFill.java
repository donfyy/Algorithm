package graph;

import java.util.LinkedList;

/**
 * 第一遍：2020/08/17周一 ✅
 * 第二遍：2020/05/31周日
 * 第三遍：2020/06/06周六
 * 第四遍：2020/06/13周六
 */
class _733_FloodFill {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    //时间O(m * n) 空间O(m * n)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        int m = image.length;
        int n = image[0].length;
        dfs(image, sr, sc, newColor, oldColor);
        return image;
    }

    void dfs(int[][] image, int i, int j, int newColor, int oldColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor) {
            return;
        }
        image[i][j] = newColor;
        for (int[] dir : dirs) {
            dfs(image, i + dir[0], j + dir[1], newColor, oldColor);
        }
    }

    class SolutionBfs {
        //时间O(m * n) 空间O(m * n)
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int oldColor = image[sr][sc];
            if (oldColor == newColor) {
                return image;
            }
            int m = image.length;
            int n = image[0].length;
            LinkedList<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{sr, sc});
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            while (!queue.isEmpty()) {
                int[] p = queue.poll();
                int i = p[0], j = p[1];
                image[i][j] = newColor;
                for (int[] dir : dirs) {
                    int in = i + dir[0];
                    int jn = j + dir[1];
                    if (in >= 0 && in < m && jn >= 0 && jn < n && image[in][jn] == oldColor) {
                        queue.offer(new int[]{in, jn});
                    }
                }
            }
            return image;
        }
    }
}