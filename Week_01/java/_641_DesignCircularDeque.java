class _641_DesignCircularDeque {
    private int[] array;
    private int head;
    private int tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public _641_DesignCircularDeque(int k) {
        if (k < 1) {
            throw new RuntimeException("k cannot less than 1");
        }
        array = new int[k + 1];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        int expectedHead = getPreviousIndex(head);
        if (expectedHead == tail) {
            return false;
        }
        array[expectedHead] = value;
        head = expectedHead;
        return true;

    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        int expectedTail = getNextIndex(tail);
        if (expectedTail == head) {
            return false;
        }    
        array[tail] = value;
        tail = expectedTail;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        head = getNextIndex(head);
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        tail = getPreviousIndex(tail);
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[head];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return array[getPreviousIndex(tail)];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head == tail;

    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return head == getNextIndex(tail);
    }

    private int getNextIndex(int index) {
        return (index + 1) % array.length;
    }
    private int getPreviousIndex(int index) {
        return (index - 1 + array.length) % array.length;
    }
}

/**
 * Your _641_DesignCircularDeque object will be instantiated and called as such:
 * _641_DesignCircularDeque obj = new _641_DesignCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */