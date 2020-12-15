import java.util.ArrayList;
import java.util.List;

public class _1030_MatrixCellsInDistanceOrder {
    class UsingBfs {
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
            int[][] ret = new int[R * C][2];
            int idx = 0, r = r0, c = c0;
            ret[idx++] = new int[]{r0, c0};
            int[][] dirs = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
            for (int dist = 1; dist <= maxDist; dist++) {
                // 从上顶点出发，到右顶点，到下顶点，到左顶点，再到上顶点
                r--;
                for (int i = 0; i < 4; i++) {
                    while (((i & 1) == 0 && r != r0) || ((i & 1) != 0 && c != c0)) {
                        if (r >= 0 && r < R && c >= 0 && c < C) {
                            ret[idx++] = new int[]{r, c};
                        }
                        r += dirs[i][0];
                        c += dirs[i][1];
                    }
                }
            }
            return ret;
        }
    }

    class UsingBuckets1 {
        // 桶排序，不需要用桶保存元素。
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            final int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
            int[] buckets = new int[maxDist + 1];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    buckets[dist(i, j, r0, c0)]++;
                }
            }
            for (int i = 1; i <= maxDist; i++) {
                buckets[i] += buckets[i - 1];
            }
            int[][] ret = new int[R * C][2];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    ret[--buckets[dist(i, j, r0, c0)]] = new int[]{i, j};
                }
            }
            return ret;
        }

        private int dist(int r, int c, int r0, int c0) {
            return Math.abs(r - r0) + Math.abs(c - c0);
        }
    }
    class UsingBuckets2 {
        // 桶排序，用桶保存元素。
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            final int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
            List[] buckets = new ArrayList[maxDist + 1];
            for (int i = 0; i <= maxDist; i++) {
                buckets[i] = new ArrayList();
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    buckets[dist(i, j, r0, c0)].add(new int[]{i, j});
                }
            }
            int[][] ret = new int[R * C][2];
            int idx = 0;
            for (List bucket : buckets) {
                for (Object it : bucket) {
                    ret[idx++] = (int[]) it;
                }
            }
            return ret;
        }

        private int dist(int r, int c, int r0, int c0) {
            return Math.abs(r - r0) + Math.abs(c - c0);
        }
    }
}
