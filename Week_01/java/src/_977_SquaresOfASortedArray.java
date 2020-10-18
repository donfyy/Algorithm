public class _977_SquaresOfASortedArray {
    class Solution {
        public int[] sortedSquares(int[] A) {
            if (A == null || A.length == 0) return A;
            int n = A.length;
            int[] ret = new int[n];
            int l = 0, r = n - 1, k = r;
            while (l <= r) {
                if (A[l] * A[l] < A[r] * A[r]) {
                    ret[k--] = A[r] * A[r];
                    r--;
                } else {
                    ret[k--] = A[l] * A[l];
                    l++;
                }
            }
            return ret;
        }
    }
}
