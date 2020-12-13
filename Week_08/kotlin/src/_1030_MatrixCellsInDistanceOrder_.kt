import java.io.BufferedInputStream
import java.io.FileInputStream
import java.util.*
import kotlin.Comparator

class _1030_ {
    class Solution {
        fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
            val ret = Array<IntArray>(R * C) { IntArray(2) }
            val inputStream = BufferedInputStream(FileInputStream(""))
            inputStream.use { }
            for (i in 0 until R) {
                for (j in 0 until C) {
                    ret[i * C + j][0] = i
                    ret[i * C + j][1] = j
                }
            }
            ret.sortWith(Comparator { l, r -> Math.abs(l[0] - r0) + Math.abs(l[1] - c0) - Math.abs(r[0] - r0) - Math.abs(r[1] - c0) })
            return ret
        }
    }

    class UsingMath {
        fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
            val maxDist = maxOf(r0, R - 1 - r0) + maxOf(c0, C - 1 - c0)
            val ret = ArrayList<IntArray>(R * C) .apply{ add(intArrayOf(r0, c0)) }
            val dirs = arrayOf(intArrayOf(1, 1), intArrayOf(1, -1), intArrayOf(-1, -1), intArrayOf(-1, 1))
            var r = r0
            var c = c0
            for (dist in 1..maxDist) {
                r--
                for (i in 0..3) {
                    while (((i and 1) == 0 && r != r0) || ((i and 1) != 0 && c != c0)) {
                        if (r in 0 until R && c in 0 until C) {
                            ret += intArrayOf(r, c)
                        }
                        r += dirs[i][0]
                        c += dirs[i][1]
                    }
                }
            }
            return ret.toTypedArray()
        }
    }

    class UsingBucketSort {
        fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
            fun dist(r: Int, c : Int) = Math.abs(r - r0) + Math.abs(c - c0)
            val maxDist = maxOf(r0, R - 1 - r0) + maxOf(c0, C - 1 - c0)
            val buckets = Array(maxDist + 1) { LinkedList<IntArray>() }
            val ret = ArrayList<IntArray>(R * C)
            for (i in 0 until R) {
                for (j in 0 until C) {
                    buckets[dist(i, j)].offer(intArrayOf(i, j))
                }
            }
            buckets.forEach { ret.addAll(it) }
            return ret.toTypedArray()
        }
    }
}