class _204_CountPrimes_ {
    class UsingEratostheness {
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

    class Naive {
        fun countPrimes(n: Int): Int {
            var ret = 0
            fun isPrime(x: Int): Boolean {
                var y = 2L
                while (y * y <= x) {
                    if (x % y == 0L) return false
                    y++
                }
                return true
            }
            for (i in 2 until n) {
                if (isPrime(i)) ret++
            }
            return ret
        }
    }
}