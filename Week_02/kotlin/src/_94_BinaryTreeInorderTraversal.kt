import java.util.*

class _94_Iterative1 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val ret = mutableListOf<Int>()
        val stack = LinkedList<TreeNode>()
        var node = root
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                stack.push(node)
                node = node.left
            }
            node = stack.pop()
            ret += node!!.`val`
            node = node!!.right
        }
        return ret
    }
}