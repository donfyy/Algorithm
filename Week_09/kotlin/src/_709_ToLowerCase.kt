fun toLowerCase(str: String): String {
    if (str.isEmpty()) return str
    val array = str.toCharArray()
    val offset = 'a' - 'A'
    for (i in array.indices) {
        val c = array[i]
        if (c in 'A'..'Z') array[i] = (offset + array[i].toInt()).toChar()
    }
    return String(array)
}