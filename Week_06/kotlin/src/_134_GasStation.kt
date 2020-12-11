class _134_GasStation_ {
    class Solution {
        fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
            val n = gas.size
            var i = 0
            while (i < n) {
                var cnt = 0
                var g = 0
                var c = 0
                while (cnt < n) {
                    val j = (i + cnt) % n
                    g += gas[j]
                    c += cost[j]
                    if (g < c) break
                    cnt++
                }
                if (cnt == n) return i
                i += cnt + 1
            }
            return -1
        }
    }
}