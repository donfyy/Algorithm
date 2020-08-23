class _679_24Game____ {
    companion object {
        const val EPSILON = 1e-6
        const val TARGET = 24
    }

    fun judgePoint24(nums: IntArray): Boolean {
        nums.map { it.toDouble() }.apply {
            fun solve(list: List<Double>): Boolean {
                val n = list.size
                if (n == 1) return Math.abs(list[0] - TARGET) < EPSILON
                for (i in 0..n - 2) {
                    for (j in i + 1 until n) {
                        val next = list.filterIndexed { idx, _ -> idx != i && idx != j }.toMutableList()
                        val a = list[i]
                        val b = list[j]
                        mutableListOf(a + b, a - b, b - a, a * b)
                                .apply {
                                    if (Math.abs(a) > EPSILON) add(b / a)
                                    if (Math.abs(b) > EPSILON) add(a / b)
                                }
                                .forEach {
                                    next.add(it)
                                    if (solve(next)) return true
                                    next.removeAt(next.lastIndex)
                                }
                    }
                }
                return false
            }
            return solve(this)
        }
    }
}