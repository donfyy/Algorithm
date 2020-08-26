package countingbits;

/**
 * 第一遍：2020/08/23周日 ✅
 * 第二遍：2020/08/24周一 ✅
 * 第三遍：2020/08/25周二 ✅
 * 第四遍：2020/08/25周四 ✅
 * 常读常新，证明中提到x与x+1相与即可将从第i + 1位开始往后的所有位数清零，
 * 这不就是将x + 1的最低位的1清零吗，也就是bk算法。
 * 就相当于同一事物的不同视角。
 */
class _201_BitwiseAndOfNumbersRange {
    // Brian Kernighan算法
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }

    class SolutionShift {
        public int rangeBitwiseAnd(int m, int n) {
            int shift = 0;
            while (m != n) {
                m >>= 1;
                n >>= 1;
                shift++;
            }
            return m << shift;
        }
    }
}