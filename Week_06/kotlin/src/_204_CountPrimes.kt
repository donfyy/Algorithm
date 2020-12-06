class _204_CountPrimes_ {
    class Solution {
        fun countPrimes(n: Int): Int {
            val isPrime = BooleanArray(n) { true }
            var ret = 0
            for (i in 2 until n) {
                if (isPrime[i]) {
                    ret++
                    var j = i
                    while (j * i.toLong() < n) {
                        isPrime[j * i] = false
                        j++
                    }
                }
            }
            return ret
        }
    }
}