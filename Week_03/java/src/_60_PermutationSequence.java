import java.util.Arrays;

/**
 * 第一遍：2020/09/05周五
 * 第二遍：2020/07/06周一
 * 第三遍：2020/07/08周三
 * 第四遍：2020/07/13周一
 * 第五遍：2020/09/03周四
 */
class _60_PermutationSequence {
    // 时间O(n^2) 空间O(n)
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        k--;
        StringBuilder ret = new StringBuilder();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; i++) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; j++) {
                order -= valid[j];
                if (order == 0) {
                    ret.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ret.toString();
    }
}