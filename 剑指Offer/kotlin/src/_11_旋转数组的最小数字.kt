fun minArray(numbers: IntArray): Int {
    if (numbers.isEmpty()) return -1;
    var l = 0
    var r = numbers.size - 1
    while (l < r && numbers[l] >= numbers[r]) {
        val m = (l + r) ushr 1
        when {
            numbers[m] > numbers[r] -> {
                l = m + 1
            }
            numbers[m] < numbers[l] -> {
                r = m
            }
            else -> {
                r--
            }
        }
    }
    return numbers[l]
}