import java.util.*

class _226_Bfs {
    fun invertTree(root: TreeNode?): TreeNode? {
        root ?: return root
        val queue = LinkedList<TreeNode>().apply { offer(root) }
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            node.left = node.right.also { node.right = node.left }
            node.left?.let { queue.offer(it) }
            node.right?.let { queue.offer(it) }
        }
        return root
    }
}