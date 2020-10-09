public class _19_秋叶收藏集 {
    class Dp0 {
        public int minimumOperations(String leaves) {
            // 最少调整次数->动态规划
            // 状态f[i][j] 表示对leaves[0, i]进行调整，并且第i片叶子处于状态j时所需要的最少调整次数
            // f[i][0] = f[i - 1][0] + isYellow(i)
            // f[i][1] = min(f[i - 1][0], f[i - 1][1]) + isRed(i)
            // f[i][2] = min(f[i - 1][1], f[i - 1][2]) + isYellow(i)
            // f[0][0] = isYellow(0)
            // f[i][j] = n i < j
            if (leaves == null) return -1;
            int n = leaves.length();
            int[][] f = new int[n][3];
            f[0][1] = f[0][2] = f[1][2] = n;
            f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
            for (int i = 1; i < n; i++) {
                int y = leaves.charAt(i) == 'y' ? 1 : 0;
                int r = leaves.charAt(i) == 'r' ? 1 : 0;
                f[i][0] = f[i - 1][0] + y;
                f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + r;
                f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + y;
            }
            return f[n - 1][2];
        }
    }
    class Dp1 {
        public int minimumOperations(String leaves) {
            // 最少调整次数->动态规划
            // 状态f[i][j] 表示对leaves[0, i]进行调整，并且第i片叶子处于状态j时所需要的最少调整次数
            // f[i][0] = f[i - 1][0] + isYellow(i)
            // f[i][1] = min(f[i - 1][0], f[i - 1][1]) + isRed(i)
            // f[i][2] = min(f[i - 1][1], f[i - 1][2]) + isYellow(i)
            // f[0][0] = isYellow(0)
            // f[i][j] = n i < j
            if (leaves == null) return -1;
            int n = leaves.length(), f1, f2, f3;
            f1 = leaves.charAt(0) == 'y' ? 1 : 0;
            f2 = f3 = n;
            for (int i = 1; i < n; i++) {
                int y = leaves.charAt(i) == 'y' ? 1 : 0;
                int r = leaves.charAt(i) == 'r' ? 1 : 0;
                int g1, g2, g3;
                g1 = f1 + y;
                g2 = Math.min(f1, f2) + r;
                g3 = Math.min(f2, f3) + y;
                f1 = g1;
                f2 = g2;
                f3 = g3;
            }
            return f3;
        }
    }
}
