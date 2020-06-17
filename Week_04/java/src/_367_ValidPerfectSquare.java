/**
 * 第一遍：2020/06/16周三 ✅
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
 *
 * 这道题必须通过乘法来判断找到的整数是不是完全平方数
 */
class _367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;
        if (num == 1) return true;
        int l = 1, h = num;
        while (l < h) {
            int m = l + ((h - l) >>> 1);
//            long r = m * m;溢出。。。。
            //int的除法是无法判断得到的m是不是num的平方根，所以这里只能用乘法
            long r = (long) m * m;
            if (r == num) return true;
            if (r < num) l = m + 1;
            else h = m;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new _367_ValidPerfectSquare().isPerfectSquare(808201));
        long x = 202051 * 202051;
        System.out.println(Integer.toBinaryString(202051));
        System.out.println(x);
    }
}