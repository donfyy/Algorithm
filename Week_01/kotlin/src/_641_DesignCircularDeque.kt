class MyCircularDeque(k: Int) {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    val array = IntArray(k + 1)
    var head = 0
    var tail = 0

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    fun insertFront(value: Int): Boolean {
        return if (isFull()) false else {
            head = prevIdx(head)
            array[head] = value
            true
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    fun insertLast(value: Int): Boolean {
        return if (isFull()) false else {
            array[tail] = value
            tail = nextIdx(tail)
            true
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    fun deleteFront(): Boolean {
        return if (isEmpty()) false else {
            head = nextIdx(head)
            true
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    fun deleteLast(): Boolean {
        return if (isEmpty()) false else {
            tail = prevIdx(tail)
            true
        }
    }

    /** Get the front item from the deque. */
    fun getFront(): Int {
        return if (isEmpty()) -1 else array[head]
    }

    /** Get the last item from the deque. */
    fun getRear(): Int {
        return if (isEmpty()) -1 else array[prevIdx(tail)]
    }

    /** Checks whether the circular deque is empty or not. */
    fun isEmpty(): Boolean {
        return head == tail
    }

    /** Checks whether the circular deque is full or not. */
    fun isFull(): Boolean {
        return nextIdx(tail) == head
    }

    fun nextIdx(idx: Int): Int {
        return (idx + 1) % array.size
    }

    fun prevIdx(idx: Int): Int {
        return (idx - 1 + array.size) % array.size
    }
}