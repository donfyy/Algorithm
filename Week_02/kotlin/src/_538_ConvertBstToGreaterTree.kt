import java.util.*

class UsingIterative {
    fun convertBST(root: TreeNode?): TreeNode? {
        var node = root
        val stack = LinkedList<TreeNode>()
        var sum = 0
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                stack.push(node)
                node = node.right
            }
            node = stack.pop()
            sum += node.`val`
            node.`val` = sum
            node = node.left
        }
        return root
    }
}