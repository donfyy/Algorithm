import java.util.*
import kotlin.collections.HashMap

class _347_Heap {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        val heap = PriorityQueue<Map.Entry<Int, Int>> { l, r -> l.value - r.value }
        map.forEach {
            if (heap.size < k) {
                heap.offer(it)
            } else {
                if (heap.peek().value < it.value) {
                    heap.poll()
                    heap.offer(it)
                }
            }
        }
//        val ret = IntArray(k)
//        repeat(k) { ret[it] = heap.poll().key }
//        return ret
        return heap.toList().map { it.key }.toIntArray()
    }
}