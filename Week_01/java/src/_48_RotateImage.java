/**
 * 脑子转不过来，还用了1小时。。。
 */
public class _48_RotateImage {
    static class UsingNaive {
        public void rotate(int[][] matrix) {
            if (matrix == null || matrix.length < 2) return;
            final int n = matrix.length;
            for (int i = 0; i < n >> 1; i++) {
                for (int j = i; j < n - i - 1; j++) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                    matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                    matrix[j][n - 1 - i] = t;
                }
            }
        }
    }
}
