import java.util.*

fun trap(height: IntArray): Int {
    if (height.size < 3) return 0
    var l = 0
    var r = height.lastIndex
    var leftMax = 0
    var rightMax = 0
    var ret = 0
    while (l < r) {
        if (height[l] < height[r]) {
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

fun trap1(height: IntArray): Int {
    if (height.size < 3) return 0
    val stack = LinkedList<Int>()
    var ret = 0
    for (i in height.indices) {
        val curr = height[i]
        //少了一个等号，速度提升了30ms，kotlin太慢
        while (!stack.isEmpty() && height[stack.peek()] < curr) {
            val topIdx = stack.poll()
            if (stack.isEmpty()) break
            ret += (minOf(height[stack.peek()], curr) - height[topIdx]) * (i - stack.peek() - 1)
        }
        stack.push(i)
    }
    return ret
}