import java.util.*

class _225_MyStack() {

    /** Initialize your data structure here. */
    private var q1 = LinkedList<Int>()
    private var q2 = LinkedList<Int>()

    /** Push element x onto stack. */
    fun push(x: Int) {
        q2.offer(x);
        while (q1.isNotEmpty()) {
            q2.offer(q1.poll());
        }
        val t = q1
        q1 = q2
        q2 = t
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        return q1.poll()
    }

    /** Get the top element. */
    fun top(): Int {
        return q1.peek()
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return q1.isEmpty()
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */