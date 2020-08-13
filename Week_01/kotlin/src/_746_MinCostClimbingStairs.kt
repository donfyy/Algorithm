fun minCostClimbingStairs(cost: IntArray): Int {
    //f(n)到达第n层的最低花费
    //f(n) = min(f(n - 1), f(n - 2)) + cost[n]
    //min(f(n - 1), f(n - 2))
    //f(0) = coust[0] f(1) = coust[1]
    var p = 0
    var q = 0
    for (v in cost) {
        val r = minOf(p, q) + v
        p = q
        q = r
    }
    return minOf(p, q)
}

fun main() {
    println(minCostClimbingStairs(intArrayOf(10, 15, 20)))
}