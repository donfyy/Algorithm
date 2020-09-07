import java.util.*

class _40_Partition {
    // 时间O(n) 空间O(1) 修改输入数组
    fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
        if (k < 1 || k > arr.size) return IntArray(0)
        fun partition(l: Int, r: Int): Int {
            if (l == r) return l
            val pivot = arr[r]
            var j = l - 1
            for (i in l until r) {
                if (arr[i] < pivot) {
                    j++
                    if (i != j) {
                        arr[i] = arr[j].also { arr[j] = arr[i] }
                    }
                }
            }
            j++
            arr[j] = arr[r].also { arr[r] = arr[j] }
            return j
        }

        var start = 0
        var end = arr.lastIndex
        var idx = partition(start, end)
        while (idx != k - 1) {
            if (idx < k - 1) {
                start = idx + 1
            } else {
                end = idx - 1
            }
            idx = partition(start, end)
        }
        return arr.copyOf(k)
    }
}

class _40_Heap {
    // 时间O(nlogk) 空间O(k) 不会修改输入数组
    fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
        if (k < 1 || arr.size < k) return IntArray(0)
        val heap = PriorityQueue<Int> { l, r -> r - l }
        arr.forEach {
            if (heap.size < k) {
                heap.offer(it)
            } else {
                if (it < heap.peek()) {
                    heap.poll()
                    heap.offer(it)
                }
            }
        }
        return heap.toIntArray()
    }
}