class _976_LargestPerimeterTriangle_ {
    class Solution {
        fun largestPerimeter(A: IntArray): Int {
            // 考虑选择的三个数 a b c 则有 a <= b <= c
            // 这三个数组成面积不为0的三角形的充分必要条件就是 a + b > c
            // 考虑枚举最长边c，从贪心的角度考虑，我们选择小于等于c的最大的两个整数作为边长a和b
            // 此时最有可能满足 a + b > c 使得三个数组成三角形，此时三角形的周长也是最大的
            // 因此我们对数组排序，倒序枚举第i个数作为最长边，如果A[i - 2] + A[i - 1] > A[i]
            // 我们就找到了最长周长
            A.sort()
            for (i in A.lastIndex downTo 2) {
                if (A[i - 2] + A[i - 1] > A[i]) {
                    return A[i - 2] + A[i - 1] + A[i]
                }
            }
            return 0
        }
    }
}