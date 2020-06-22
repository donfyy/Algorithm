/**
 * 第一遍：2020/06/22周一 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 */
class _63_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //f(i, j) = f(i-1,j) + f(i,j-1);
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] counts = new int[col];
        //边界情况
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            counts[i] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    counts[j] = 0;
                } else {
                    if (j != 0) {
                        //状态表示与状态转移
                        counts[j] += counts[j - 1];
                    }
                }
            }
        }

        return counts[col - 1];
    }
}