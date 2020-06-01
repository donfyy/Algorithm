/**
 * 第一遍：2020/05/21周四 ✅
 * 第二遍：2020/05/22周五
 * 第二遍：2020/06/01周一 ✅
 * 第三遍：2020/05/28周四
 * 第四遍：2020/06/11周四
 */
class _70_ClimbStairs {
    /**
     * 自底向上的循环，递推，动态规划。递归会超时。
     * 时间:O(n),空间:O(1)
     */
    public int climbStairs(int n) {
        if (n < 1) {
            return -1;
        }
        if (n < 2) {
            return 1;
        }
        int fn = 1, fn_1 = 1, fn_2 = 1;
        for (int i = 2; i <= n; i++) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }
}