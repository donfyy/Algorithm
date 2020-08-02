package pascalstriangle

fun generate(numRows: Int): List<List<Int>> {
    return if (numRows < 1) {
        emptyList()
    } else {
        val ret = MutableList(numRows) { i -> MutableList(i + 1) { 1 } }
        for (i in 2 until numRows) {
            val list = ret[i]
            val formerList = ret[i - 1]
            for (j in 1 until i) {
                list[j] = formerList[j - 1] + formerList[j]
            }
        }
        ret
    }
}