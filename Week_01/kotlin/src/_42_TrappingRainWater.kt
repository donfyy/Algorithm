import java.util.*

fun trap(height: IntArray): Int {
    if (height.size < 3) return 0
    var l = 0
    var r = height.lastIndex
    var leftMax = 0
    var rightMax = 0
    var ret = 0
    while (l < r) {
        // 这里l与r相当于左右边界，所以l < r就行了
        if (height[l] < height[r]) {
            //这里已经确保了leftMax小于r或rightMax的
            if (leftMax > height[l]) {
                ret += leftMax - height[l]
            } else {
                leftMax = height[l]
            }
            l++
        } else {
            if (rightMax > height[r]) {
                ret += rightMax - height[r]
            } else {
                rightMax = height[r]
            }
            r--
        }
    }
    return ret
}

fun trapStack(height: IntArray): Int {
    val stack = LinkedList<Int>()
    var ret = 0
    for (i in height.indices) {
        val r = height[i]
        while (stack.isNotEmpty() && height[stack.peek()] < r) {
            val curr = height[stack.pop()]
            if (stack.isEmpty()) break
            val l = height[stack.peek()]
            ret += (minOf(l, r) - curr) * (i - stack.peek() - 1)
        }
        stack.push(i)
    }
    return ret
}

//使用数组存储i左边和右边的最大值(包含i在内)
class _42_Solution1_ {
    fun trap(height: IntArray): Int {
        val n = height.size.takeIf { it > 2 } ?: return 0
        val left = IntArray(n).apply { this[0] = height[0] }
        val right = IntArray(n).apply { this[n - 1] = height[n - 1] }
        for (i in 1 until n) left[i] = maxOf(height[i], left[i - 1])
        for (i in n - 2 downTo 0) right[i] = maxOf(height[i], right[i + 1])
        var ret = 0
        for (i in 1..n - 2) ret += minOf(left[i], right[i]) - height[i]
        return ret
    }
}

class _42_math_ {
    fun trap(height: IntArray): Int {
        var sl = 0
        var sr = 0
        var s = 0
        var ml = 0
        var mr = 0
        val n = height.size
        for (i in height.indices) {
            s += height[i]
            ml = maxOf(ml, height[i]).apply { sl += this }
            mr = maxOf(mr, height[n - 1 - i]).apply { sr += this }
        }
        return sl + sr - ml * n - s
    }
}