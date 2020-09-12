private const val Q = 1000000007

// 今天尝试了下竞赛，到第二道简单题就不行了，二分都没写出来，太菜了，😨
// 需要再练习下二分。
class _13_TowPointer {
    // 时间 O(m + n) 空间 O(1)
    fun breakfastNumber(staple: IntArray, drinks: IntArray, x: Int): Int {
        staple.sort()
        drinks.sort()
        val n = staple.size
        val m = drinks.size
        var i = 0
        var j = m - 1
        var ret = 0
        while (i < n && j >= 0) {
            if (staple[i] + drinks[j] <= x) {
                ret = (ret + j + 1) % Q
                i++
            } else {
                j--
            }
        }
        return ret
    }
}

// 唉，还是不会二分。
class _18_BinarySearch {
    // 时间 O(max(nlogn, mlogm, nlogm)) O(1)
    fun breakfastNumber(staple: IntArray, drinks: IntArray, x: Int): Int {
        staple.sort()
        drinks.sort()
        var ret = 0
        for (i in staple.indices) {
            val t = x - staple[i]
            if (t <= 0) break
            var l = 0
            var r = drinks.size
            while (l < r) {
                val m = (l + r) ushr 1
                if (drinks[m] > t) {
                    r = m
                } else {
                    l = m + 1
                }
            }
            if (l == 0) break
            ret = (ret + l) % Q
        }
        return ret
    }
}

fun main() {

}