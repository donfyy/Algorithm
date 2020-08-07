import java.util.*

fun flatten(root: TreeNode?): Unit {
    var node = root
    while (node != null) {
        node.left?.let {
            var pre = it
            while (pre.right != null) {
                pre = pre.right!!
            }
            pre.right = node?.right
            node?.right = node?.left
            node?.left = null
        }
        node = node.right
    }
}

class _114_PreorderIterative {
    fun flatten(root: TreeNode?): Unit {
        val stack = LinkedList<TreeNode>()
        root?.let { stack.push(it) }
        var pre: TreeNode? = null
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            pre?.apply {
                right = node
                left = null
            }
            pre = node
            node.right?.let { stack.push(it) }
            node.left?.let { stack.push(it) }
        }
    }
}

class _114_PreorderRecursive {
    fun flatten(root: TreeNode?): Unit {
        dfs(root, null)
    }

    fun dfs(node: TreeNode?, pre: TreeNode?): TreeNode? {
        return node?.let {
            pre?.apply {
                left = null
                right = node
            }
            val right = it.right
            dfs(right, dfs(it.left, it))
        } ?: pre
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
        } ?: next
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
            if (top.left != null && top.left != next) {
                node = top.left
            } else {
                stack.pop()
                top.right = next
                top.left = null
                next = top
            }
        }
    }
}