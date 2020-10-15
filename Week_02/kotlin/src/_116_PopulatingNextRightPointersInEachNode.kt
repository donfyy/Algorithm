class _116_ {
    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    class Solution {
        fun connect(root: Node?): Node? {
            var start = root
            while (start?.left != null) {
                var node = start
                while (node != null) {
                    node.left!!.next = node.right
                    if (node.next != null) {
                        node.right!!.next = node.next!!.left
                    }
                    node = node.next
                }
                start = start.left
            }
            return root
        }
    }

    class Dfs {
        fun connect(root: Node?): Node? {
            root ?: return null
            root.left?.let {
                it.next = root.right
                root.next?.let {
                    root.right!!.next = it.left
                }
                connect(root.left)
                connect(root.right)
            }
            return root
        }
    }
}