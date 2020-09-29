class _874_Simulation {
    // O(n) n表示机器人行走的步数与转身数之和 O(m) m表示障碍物的个数
    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(1, 0))
        var ret = 0
        var di = 0
        var x = 0
        var y = 0
        val map = hashMapOf<Int, HashSet<Int>>()
        obstacles.forEach { (x, y) -> map.computeIfAbsent(x) { HashSet() }.add(y) }
        for (cmd in commands) {
            when (cmd) {
                -2 -> di = (di + 1) % 4
                -1 -> di = (di + 3) % 4
                else -> {
                    for (i in 0 until cmd) {
                        val p = x + dirs[di][0]
                        val q = y + dirs[di][1]
                        if (p in map && q in map[p]!!) break;
                        x = p
                        y = q
                        ret = maxOf(ret, x * x + y * y)
                    }
                }
            }
        }
        return ret
    }
}