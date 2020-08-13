fun minCostClimbingStairs(cost: IntArray): Int {
    //f(i)从i层起跳的最低花费
    //f(i) = min(f(i - 1), f(i - 2)) + cost[i]
    //min(f(n - 1), f(n - 2))
    //f(0) = cost[0] f(1) = cost[1]
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