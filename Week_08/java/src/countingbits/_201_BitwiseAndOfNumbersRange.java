package countingbits;

/**
 * 第一遍：2020/08/23周日 ✅
 * 第二遍：2020/08/22周六
 * 第三遍：2020/06/06周六
 * 第四遍：2020/06/13周六
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