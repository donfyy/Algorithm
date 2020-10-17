class _977_ {
    fun sortedSquares(A: IntArray): IntArray {
        val n = A.size
        val ret = IntArray(n)
        var i = 0
        var j = n - 1
        var k = j
        while (i <= j) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ret[k--] = A[i] * A[i++]
            } else {
                ret[k--] = A[j] * A[j--]
            }
        }
        return ret
    }
}