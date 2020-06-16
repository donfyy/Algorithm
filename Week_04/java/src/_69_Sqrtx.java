/**
 * 第一遍：2020/06/16周二 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 * 这道题需要注意4点
 * 1. l == h - 1的时候，m永远等于l
 * 2. 加法int溢出
 * 3. 乘法int溢出
 * 4. 边界条件 0,1
 * 这样的题目才是面试应该考的题目，太经典了。
 * 除了二分法还有位运算法和牛顿迭代法。
 * 速度的区别在于除2时用除法还是位运算。
 */
class _69_Sqrtx {
    /**
     * 简洁的牛顿迭代法
     */
    public int mySqrt3(int x) {
        long r = x;
        while (r * r > x) r = (r + x / r) >> 1;
        return (int) r;
    }

    public int mySqrt2(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;
        if (x == 1) return 1;
        int l = 1, h = x;
        while (l < h) {
            int m = l + ((h - l) >> 1);
            int d = x / m;
            if (d == m) {
                return m;
            }
            if (d > m) l = m + 1;
            else h = m;
        }
        return l - 1;
    }

    //不成熟的代码
    public int mySqrt1(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        int l = 1, h = x;
        while (l < h - 1) {
            int mid = l + ((h - l) >> 1);
            int mSqrt = x / mid;
            if (mSqrt == mid) {
                return mid;
            } else if (mSqrt < mid) {
                h = mid;
            } else {
                l = mid;
            }
        }

        return l;
    }

}