class _657_ {
    fun judgeCircle(moves: String): Boolean {
        var x = 0
        var y = 0
        moves.forEach {
            when (it) {
                'R' -> x++
                'L' -> x--
                'U' -> y++
                'D' -> y--
            }
        }
        return x == 0 && y == 0
    }
}