import java.util.*
import kotlin.Comparator

class _406_QueueReconstructionByHeight_ {
    class Solution {
        fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
            people.sortWith(Comparator { l, r -> if (l[0] == r[0]) l[1] - r[1] else r[0] - l[0] })
            val list = LinkedList<IntArray>()
            people.forEach { list.add(it[1], it) }
            return list.toTypedArray()
        }
    }
}