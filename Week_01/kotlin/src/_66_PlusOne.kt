fun plusOne(digits: IntArray): IntArray {
    val n = digits.size
    for (i in n - 1 downTo 0) {
        digits[i]++
        digits[i] = digits[i] % 10
        if (digits[i] != 0) return digits
    }
    return IntArray(n + 1) { if (it == 0) 1 else 0 }
}