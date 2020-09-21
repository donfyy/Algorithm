class _433_BiBfs {
    // O(4^8) O(4^8)
    fun minMutation(start: String, end: String, bank: Array<String>): Int {
        val bankSet = bank.toMutableSet()
        if (end !in bankSet) return -1
        var startSet = mutableSetOf(start)
        var endSet = mutableSetOf(end)
        bankSet.remove(start)
        bankSet.remove(end)
        var ret = 1
        val options = charArrayOf('A', 'C', 'G', 'T')
        while (startSet.isNotEmpty()) {
            val nextSet = mutableSetOf<String>()
            for (str in startSet) {
                val arr = str.toCharArray()
                for (i in arr.indices) {
                    val c = arr[i]
                    options.forEach {
                        arr[i] = it
                        val strv = String(arr)
                        if (strv in endSet) {
                            return ret
                        }
                        if (strv in bankSet) {
                            nextSet += strv
                            bankSet.remove(strv)
                        }
                    }
                    arr[i] = c
                }
            }
            if (nextSet.size > endSet.size) {
                startSet = endSet
                endSet = nextSet
            } else {
                startSet = nextSet
            }
            ret++
        }
        return -1
    }
}