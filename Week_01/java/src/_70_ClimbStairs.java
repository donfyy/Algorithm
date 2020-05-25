class _70_ClimbStairs {
    public int climbStairs(int n) {
        if (n < 1) {
            return -1;
        }
        if (n < 2) {
            return 1;
        }
        int fn = 1,fn_1 = 1, fn_2 = 1;
        for (int i = 2; i <= n; i++) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }
}