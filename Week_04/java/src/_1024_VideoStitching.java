import java.util.Arrays;

public class _1024_VideoStitching {
    class Dp {
        // O(T * N) O(T)
        public int videoStitching(int[][] clips, int T) {
            // f(i) 覆盖[0, i]所需片段的最小数目
            // 对于任意一个区间[a, b]如果 i > a && i <= b 则[0, i] 可以由[a, b]拼接完成
            // f(i) = f(a) + 1, 因为可能存在多个区间所以
            // f(i) = min(f(a) + 1)
            // 因为是求最小值，所以将数组初始化为一个大整数
            // f(0) = 0
            int[] dp = new int[T + 1];
            Arrays.fill(dp, Integer.MAX_VALUE - 1);
            dp[0] = 0;
            for (int i = 1; i <= T; i++) {
                for (int[] clip : clips) {
                    if (clip[0] < i && i <= clip[1]) {
                        dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                    }
                }
            }
            return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
        }
    }
}
