/**
 * 第一遍：2020/06/18周四 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 * 注意二分查找的两种写法，一种是找到一个中间值就进行比较，一种是不断收缩边界最后再进行比较，前一种方式更优。
 */
class _74_SearchA2DMatrix {
    /**
     * 这个叫二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix[0].length;
        int l = 0, h = matrix.length * n - 1;
        while (l <= h) {
            int mid = l + ((h - l) >>> 1);
            int val = matrix[mid / n][mid % n];
            if (val == target) return true;
            if (target < val) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    /**
     * 这种方法叫二分收缩，时间总是稳定在O(logm + logn)，哈哈
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix[0].length;
        int l = 0, h = matrix.length * n - 1;
        while (l < h) {
            int m = ((h + l) >>> 1);
            int val = matrix[m / n][m % n];
            if (val < target) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return matrix[l / n][l % n] == target;
    }

    /**
     * 每一行从左到右递增，每一列从上到下递增。从右上角扫描到左下角，每次排除一列或一行
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix3(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            int val = matrix[row][col];
            if (val == target) {
                return true;
            }
            if (target > val) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    //从左下角出发扫描到右上角
    public boolean searchMatrix4(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int row = m - 1, col = 0;
        while (row >= 0 && col < n) {
            int val = matrix[row][col];
            if (target == val) {
                return true;
            }
            if (target > val) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }
}