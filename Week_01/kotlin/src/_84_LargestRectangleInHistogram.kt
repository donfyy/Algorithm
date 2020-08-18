import java.util.*

fun largestRectangleArea(heights: IntArray): Int {
    val stack = LinkedList<Int>().apply { push(-1) }
    val n = heights.size
    var ret = 0
    for (i in 0..n) {
        val h = if (i == n) 0 else heights[i]
        while (stack.peek() != -1 && heights[stack.peek()] >= h) {
            ret = maxOf(ret, heights[stack.pop()] * (i - stack.peek() - 1));
        }
        stack.push(i)
    }
    return ret
}