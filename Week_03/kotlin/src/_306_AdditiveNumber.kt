class _306_AdditiveNumber {
    val path = ArrayList<Double>()
    fun isAdditiveNumber(num: String): Boolean {
        return dfs(num, 0)
    }

    fun dfs(num: String, start: Int): Boolean {
        // 处理完最后一位数字
        if (start == num.length && path.size > 2) return true
        // 解析当前的数字，并判断是否符合累加
        for (i in start until num.length) {
            val curr = try {
                num.substring(start, i + 1).toDouble()
            } catch (e: Exception) {
                break
            }
            // 前面已经解析出两个数字了, 判断当前是否符合累加
            if ((path.size < 2 || curr == path[path.size - 1] + path[path.size - 2])) {
                path += curr

                if (!dfs(num,  i + 1)) {
                    path.remove(path.last())
                } else {
                    return true
                }
            }
            if (curr == 0.0) break
            if (i + 1 - start > num.length / 2) break
        }
        return false
    }

}

fun main() {
    println(_306_AdditiveNumber().isAdditiveNumber("101"))
    println(_306_AdditiveNumber().isAdditiveNumber("199100199299498797"))
    println(_306_AdditiveNumber().isAdditiveNumber("121474836472147483648"))
}