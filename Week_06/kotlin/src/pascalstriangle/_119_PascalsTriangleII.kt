package pascalstriangle

fun getRow(rowIndex: Int): List<Int> {
    return if (rowIndex < 0) {
        emptyList()
    } else {
        val ret = MutableList(rowIndex + 1) { 1 }
        for (i in 2..rowIndex) {
            for (j in i - 1 downTo 1) {
                ret[j] = ret[j] + ret[j - 1]
            }
        }
        ret
    }
}