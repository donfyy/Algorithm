fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
    if (arr1.isEmpty()) return arr1
    var maxValue = arr1[0]
    for (i in 1 until arr1.size) {
        if (arr1[i] > maxValue) {
            maxValue = arr1[i]
        }
    }

    val bucket = IntArray(maxValue + 1)
    for (value in arr1) {
        bucket[value]++
    }

    var j = 0
    for (value in arr2) {
        while (bucket[value] > 0) {
            arr1[j++] = value
            bucket[value]--
        }
    }

    for (i in 0..maxValue) {
        while (bucket[i] > 0) {
            arr1[j++] = i
            bucket[i]--
        }
    }

    return arr1
}