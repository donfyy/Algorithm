import java.util.*

fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0

    fun dfs(node: TreeNode?): Int {
        return if (node == null) {
            Integer.MAX_VALUE
        } else {
            if (node.left == null && node.right == null) {
                1
            } else {
                minOf(dfs(node.left), dfs(node.right)) + 1
            }
        }
    }
    return dfs(root)
}

class _111_BFS_ {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val queue = LinkedList<TreeNode>().apply { offer(root) }
        var ret = 0
        while (queue.isNotEmpty()) {
            var size = queue.size
            while (size-- > 0) {
                val node = queue.poll()
                if (node.left == null && node.right == null) {
                    return ret + 1
                }
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            ret++
        }
        return ret
    }
}