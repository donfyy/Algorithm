class _117_ {
    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    class Solution {
        fun connect(root: Node?): Node? {
            var dummy = Node(-1)
            var node = root
            while (node != null) {
                var curr = node
                var pre = dummy.apply { next = null }
                while (curr != null) {
                    curr.left?.let {
                        pre.next = it
                        pre = it
                    }
                    curr.right?.let {
                        pre.next = it
                        pre = it
                    }
                    curr = curr.next
                }
                node = dummy.next
            }
            return root
        }
    }
}