import java.util.*

fun flatten(root: TreeNode?): Unit {
    var node = root
    while (node != null) {
        node.left?.let { left ->
            var pre = left
            while (pre.right != null) {
                pre.right?.let { pre = it }
            }
            pre
        }?.let { pre ->
            pre.right = node?.right.also { node?.right = node?.left.also { node?.left = null } }
        }
        node = node.right
    }
}
class _114_PreorderIterative {
    fun flatten(root: TreeNode?): Unit {
        val stack = LinkedList<TreeNode>()
        root?.let { stack.push(it) }
        var pre : TreeNode? = null
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            pre?.let {
                it.right = node
                it.left = null
            }
            pre = node
            node.right?.let { stack.push(it) }
            node.left?.let{ stack.push(it) }
        }
    }
}
class _114_PreorderRecursive {
    fun flatten(root: TreeNode?): Unit {
        dfs(root, null)
    }

    fun dfs(node: TreeNode?, pre: TreeNode?): TreeNode? {
        return node?.let {
            pre?.let {
                it.left = null
                it.right = node
            }
            val right = it.right
            dfs(right, dfs(it.left, it))
        }?: pre
    }
}
class _114_PostorderRecursive {
    fun flatten(root: TreeNode?): Unit {
        dfs(root, null)
    }

    fun dfs(node: TreeNode?, next: TreeNode?): TreeNode? {
        return node?.apply {
            right = dfs(left, dfs(right, next))
            left = null
        }?:next
    }
}
class _114_PostorderIterative {
    fun flatten(root: TreeNode?): Unit {
        val stack = LinkedList<TreeNode>()
        var next: TreeNode? = null
        var node = root
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                stack.push(node)
                node = node.right
            }

            val top = stack.peek()
            if (top.left == null || top.left == next) {
                stack.pop()
                top.right = next
                top.left = null
                next = top
            } else {
                node = top.left
            }
        }
    }
}