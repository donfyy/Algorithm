import java.util.*

fun largestRectangleArea(heights: IntArray): Int {
    val stack = LinkedList<Int>().apply { push(-1) }
    var ret = 0
    for (i in heights.indices) {
        val h = heights[i]
        while (stack.peek() != -1 && heights[stack.peek()] > h) {
            ret = maxOf(ret, heights[stack.pop()] * (i - 1 - stack.peek()))
        }
        stack.push(i)
    }
    val lastIndex = heights.lastIndex
    while (stack.peek() != -1) {
        ret = maxOf(ret, heights[stack.pop()] * (lastIndex - stack.peek()))
    }
    return ret
}