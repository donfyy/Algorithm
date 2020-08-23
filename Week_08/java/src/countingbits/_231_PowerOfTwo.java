package countingbits;

/**
 * 第一遍：2020/07/07周三 ✅
 * 第二遍：2020/07/08周四 ✅
 * 第三遍：2020/07/13周一 ✅
 * 第二遍：2020/07/03周五
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}