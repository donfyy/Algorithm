import java.util.Arrays;
/**
 * 第一遍：2020/07/25周六 ✅
 * 第二遍：2020/07/26周日 ✅
 * 第三遍：2020/07/27周一 ✅
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 */
class _410_SplitArrayLargestSum {
    //时间O(nnm) 空间O(nm)
    public int splitArray(int[] nums, int m) {
        //数组长度为n，要分成m个非空连续子数组
        //第一次分割有 n - m + 1种，在区间[0, n - 1]选取i分割 [0, i] [i + 1, n - 1] i in [0, n - m]
        //剩下的区间[i + 1, n - 1]有 分割成 m - 1个非空连续子数组.
        //f(i, j)表示区间[i, j] m个子数组各自和的最小的最大值
        //f(i, j) = min(min(sum(i, k), f(k + 1, j))) for k in [i, j - m]
        //花了30分钟得到上面的分析结果
        //花了1个小时没理解题解，草
        //f(i, j)表示将数组前i个数分割为j段所能得到的最大连续子数组和的最小值
        //f(i, j) = min(max(f(i, k), sum(k + 1, j)) k in (0, i))
        //合法的状态是 i >= j, 不合法的状态，i < j 因为要求最小值，我们可以将不合法的状态初始化为最大值
        //f(0, 0) = 0      i in [1, n] j in [1, min(i, m)]
        if (nums == null || m < 0 || nums.length < m) return -1;
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
                }
            }
        }
        return dp[n][m];
    }

    //时间O(n log(sum-max)) 空间 O(1)
    public int splitArrayBinarySearch(int[] nums, int m) {
        //子数组的和的最大值是有范围的，即[max(nums), sum(nums)]
        //l = max(nums) r = sum(nums) mid = (l + r) >>> 1
        //计算数组和最大值小于等于mid的子数组个数cnt，
        //如果cnt > m，说明mid小 所以 l = mid + 1 否则 r = mid
        if (nums == null || m < 1 || nums.length < m) return -1;
        long l = nums[0];
        long r = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            r += nums[i];
            if (nums[i] > l) {
                l = nums[i];
            }
        }
        while (l < r) {
            long mid = (l + r) >>> 1;
            int cnt = 1;
            long s = 0;
            for (int v : nums) {
                s+= v;
                if (s > mid) {
                    s = v;
                    cnt++;
                }
            }
            if (cnt > m) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return (int)l;
    }
}