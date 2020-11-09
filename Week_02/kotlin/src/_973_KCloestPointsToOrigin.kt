import java.util.*

class _973_KCloestPointsToOrigin_ {
    class Solution {
        // O(nlogk) O(k)
        fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
            fun cmp(u: IntArray, v: IntArray): Int {
                return u[0] * u[0] + u[1] * u[1] - (v[0] * v[0] + v[1] * v[1])
            }

            val heap = PriorityQueue<IntArray> { u, v -> -cmp(u, v) }
            points.forEach {
                if (heap.size < K) {
                    heap.offer(it)
                } else {
                    if (cmp(heap.peek(), it) > 0) {
                        heap.poll()
                        heap.offer(it)
                    }
                }
            }
            return heap.toTypedArray()
        }
    }
}