/**
 * 第一遍：2020/06/02周二 ✅
 * 第二遍：2020/06/04周四 ✅
 * 第三遍：2020/09/15周二 ✅
 * 第四遍：2020/06/23周二
 * <p>
 * 需要注意最小的负整数,这道题看似简单，容易错在这里。
 * 这道题过了3个月就忘了。。这道题对我来说不简单。
 */
class _50_PowXN {
    /**
     * 时间：O(logn) 空间：O(logn)
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n < 0) {
            return 1 / cal(x, -(long) n);
        } else {
            return cal(x, n);
        }
    }

    private double cal(double x, long n) {
        if (n == 0) {
            return 1;
        }

        //自顶向下分解,不断地二分n. x^7 = x * x^3 * x^3
        double temp = cal(x, n >>> 1);
        return ((n & 1) == 1) ? x * temp * temp : temp * temp;
    }

    private double cal2(double x, long n) {
        if (n == 0) {
            return 1;
        }

        //自顶向下分解，二分n的同时，将x乘上x.  x^7 = x * (x^2)^3
        double temp = cal(x * x, n >>> 1);
        return ((n & 1) == 1) ? x * temp : temp;
    }

    static class UsingIteration {
        // 时间：O(logn) 空间：O(1)
        public double myPow(double x, int n) {
            long N = n < 0 ? -(long) n : n;
            double ret = 1;
            while (N > 0) {
                if ((N & 1) == 1) {
                    ret *= x;
                }
                x *= x;
                N >>= 1;
            }
            return n < 0 ? 1 / ret : ret;
        }
    }

    //错误示例==============================================================================================================
    public static void main(String[] args) {
        System.out.println(new _50_PowXN().myPow2(2, -2147483648));

        int n = -2147483648;
        System.out.println(Integer.toBinaryString(-2147483648));
        System.out.println(Long.toBinaryString(-(long) n));
        System.out.println(Long.toBinaryString(n));
        System.out.println(Integer.toBinaryString(2147483647));
        System.out.println(Integer.toBinaryString(-2147483647));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-3));
    }

    //错误解法 -2147483648 -> 1
    public double myPow2(double x, int n) {
        if (x == 0) return 0;
        // int 范围太小 -2147483648 取反加一之后还是他自己，菜了
        int np = n;
        if (n < 0) {
            np = -n;
        }
        double ret = 1;
        double lx = x;
        while (np > 0) {
            if ((np & 1) == 1) ret *= lx;
            lx *= lx;
            np >>>= 1;
        }

        return n < 0 ? 1 / ret : ret;
    }
}