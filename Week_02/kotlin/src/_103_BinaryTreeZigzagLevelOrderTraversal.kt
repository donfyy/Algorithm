import java.util.*

class _103_BinaryTreeZigzagLevelOrderTraversal_ {
    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    class Solution {
        fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
            root ?: return emptyList()
            val q = LinkedList<TreeNode>().apply { offer(root) }
            val ret = mutableListOf<List<Int>>()
            var isOrderLeft = true
            while (q.isNotEmpty()) {
                val deq = LinkedList<Int>()
                var size = q.size
                while (size-- > 0) {
                    val node = q.poll()
                    if (isOrderLeft) {
                        deq.offer(node.`val`)
                    } else {
                        deq.offerFirst(node.`val`)
                    }
                    node.left?.let { q.offer(it) }
                    node.right?.let { q.offer(it) }
                }
                isOrderLeft = !isOrderLeft
                ret += deq
            }
            return ret
        }
    }
}