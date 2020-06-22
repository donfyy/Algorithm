/**
 * 第一遍：2020/06/22周一 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 */
class _509_FibonacciNumber {
    //动态规划
    public int fib(int N) {
//f(i) = f(i - 1) + f(i - 2);
        if (N < 2) {
            return N;
        }
        //边界情况
        int fi_1 = 1;
        int fi_2 = 0;
        int fi = 0;
        for (int i = 2; i <= N; i++) {
            //状态表示
            fi = fi_1 + fi_2; 
            //状态转移
            fi_2 = fi_1;
            fi_1 = fi;
        }

        return fi;     
    }
    //记忆化搜索
    int fib(int N, int[] memo) {
        if (N < 2) {
            return N;
        }
        if (memo[N] == 0) {
            memo[N] = fib(N - 1, memo) + fib(N - 2, memo);
        }
        return memo[N];
    }
}