class _146_LRUCache_ {
    class LRUCache(var capacity: Int) {
        class DLinkedNode(var key:Int = 0, var value: Int = 0) {
            var prev: DLinkedNode? = null
            var next: DLinkedNode? = null
        }
        val map = HashMap<Int, DLinkedNode>()
        var size = 0
        val head = DLinkedNode()
        val tail = DLinkedNode()
        init {
            head.next = tail
            tail.prev = head
        }

        fun get(key: Int): Int {
            val node = map[key]
            node?: return -1
            moveToHead(node)
            return node.value
        }

        fun put(key: Int, value: Int) {
            var node = map[key]
            if (node == null) {
                node = DLinkedNode(key, value)
                map[key] = node
                size++
                addToHead(node)
                if (size > capacity) {
                    node = removeTail()
                    map.remove(node?.key)
                    size--
                }
            } else {
                node.value = value
                moveToHead(node)
            }
        }
        fun removeNode(node: DLinkedNode) {
            node?.prev?.next = node?.next
            node?.next?.prev = node?.prev
        }
        fun addToHead(node: DLinkedNode) {
            head.next?.prev = node
            node.next = head.next
            node.prev = head
            head.next = node
        }
        fun moveToHead(node: DLinkedNode) {
            removeNode(node)
            addToHead(node)
        }
        fun removeTail(): DLinkedNode? {
            val ret = tail.prev
            tail.prev = ret?.prev
            ret?.prev?.next = tail
            return ret
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * var obj = LRUCache(capacity)
     * var param_1 = obj.get(key)
     * obj.put(key,value)
     */
}