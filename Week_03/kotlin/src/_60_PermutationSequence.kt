fun getPermutation(n: Int, k_: Int): String {
    var k = k_
    val factorial = IntArray(n).apply { this[0] = 1 }
    for (i in 1 until n) {
        factorial[i] = factorial[i - 1] * i
    }
    k--
    val ret = StringBuilder()
    val valid = IntArray(n + 1) { 1 }
    for (i in 1..n) {
        var order = k / factorial[n - i] + 1;
        for (j in 1..n) {
            order -= valid[j];
            if (order == 0) {
                ret.append(j);
                valid[j] = 0;
                break;
            }
        }
        k %= factorial[n - i];
    }
    return ret.toString()
}