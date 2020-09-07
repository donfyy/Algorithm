import java.util.*

class _144_Morris {
    // 时间O(n) 空间O(1)
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val ret = mutableListOf<Int>()
        var node = root
        while (node != null) {
            if (node.left == null) {
                ret += node.`val`
                node = node.right
            } else {
                var p = node.left!!
                while (p.right != null && p.right != node) {
                    p = p.right!!
                }
                if (p.right == null) {
                    p.right = node
                    ret += node.`val`
                    node = node.left
                } else {
                    p.right = null
                    node = node.right;
                }
            }
        }
        return ret
    }
}

class _144_Iterative {
    // 时间O(n) 空间O(n)
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val stack = LinkedList<TreeNode>()
        root?.let { stack.push(it) }
        val ret = mutableListOf<Int>()
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            ret += node.`val`
            node.right?.let { stack.push(it) }
            node.left?.let { stack.push(it) }
        }
        return ret
    }
}

class _144_Iterative2 {
    // 时间O(n) 空间O(n)
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val stack = LinkedList<TreeNode>()
        val ret = mutableListOf<Int>()
        var node = root
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                ret += node.`val`
                stack.push(node)
                node = node.left
            }
            node = stack.pop()
            node = node?.right
        }
        return ret
    }
}

class _144_Iterative3 {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val ret = mutableListOf<Int>()
        val stack = LinkedList<TreeNode?>()
        root?.let { stack.push(it) }
        while (stack.isNotEmpty()) {
            val node = stack.peek()
            if (node != null) {
                stack.pop()
                node.right?.let { stack.push(it) }
                node.left?.let { stack.push(it) }
                stack.push(node)
                stack.push(null)
            } else {
                stack.pop()
                stack.pop()?.let { ret += it.`val` }
            }
        }
        return ret
    }
}