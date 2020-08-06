fun addStrings(num1: String, num2: String): String {
    var i = num1.length - 1
    var j = num2.length - 1
    val ret = StringBuilder()
    var add = 0
    while (i >= 0 || j >= 0 || add != 0) {
        val a = if (i >= 0) num1[i] - '0' else 0
        val b = if (j >= 0) num2[j] - '0' else 0
        val s = a + b + add
        ret.append(s % 10)
        add = s / 10
        i--
        j--
    }
    return ret.reverse().toString()
}