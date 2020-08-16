import java.util.*

class MinStack() {
    /** initialize your data structure here. */
    val stack = LinkedList<Int>()
    val minStack = LinkedList<Int>()

    fun push(x: Int) {
        stack.push(x)
        minStack.push(if (minStack.isEmpty() || minStack.peek() > x) x else minStack.peek())
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }

}
