fun numJewelsInStones(J: String, S: String): Int {
    if (J.isEmpty() || S.isEmpty()) return 0
    val map = BooleanArray(122)
    for (c in J) {
        map[c - 'A'] = true
    }
    var count = 0
    for (c in S) {
        if (map[c - 'A']) count++
    }
    return count
}