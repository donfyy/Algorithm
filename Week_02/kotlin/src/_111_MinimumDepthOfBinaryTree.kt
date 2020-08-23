import java.util.*

fun minDepth(root: TreeNode?): Int {
    return if (root == null) {
        0
    } else {
        val l = minDepth(root.left)
        val r = minDepth(root.right)
        if (minOf(l, r) == 0) {
            1 + maxOf(l, r)
        } else {
            1 + minOf(l, r)
        }
    }
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