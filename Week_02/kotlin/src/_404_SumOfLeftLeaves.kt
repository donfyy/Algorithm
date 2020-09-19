import java.util.*

class _404_UsingDfsIteration {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        var node = root
        val stack = LinkedList<TreeNode>()
        var ret = 0
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                stack.push(node)
                val left = node.left
                if (left != null && left.left == null && left.right == null) {
                    ret += left.`val`
                    node = null
                } else {
                    node = node.left
                }
            }
            node = stack.pop().right
        }
        return ret
    }
}