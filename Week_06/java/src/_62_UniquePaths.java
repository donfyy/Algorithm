/**
 * 第一遍：2020/06/22周一 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 */
class _62_UniquePaths {
    public int uniquePaths(int m, int n) {
        //f(i,j) = f(i-1,j) + f(i, j-1)
        int[] counts = new int[m];
        //边界情况
        for (int i = 0; i < m; i++) {
            counts[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                counts[j] = counts[j] + counts[j - 1];//状态表示与状态转移
            }
        }

        return counts[m - 1];
    }

    // TODO: 2020/6/22 https://leetcode.com/problems/unique-paths/discuss/22981/My-AC-solution-using-formula 
    public int uniquePaths1(int m, int n) {
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        // here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int) res;
    }
}