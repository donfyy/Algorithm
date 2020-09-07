import java.util.*

class _102_Bfs {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()
        root?.let { queue.offer(it) }
        while (queue.isNotEmpty()) {
            var size = queue.size
            val list = mutableListOf<Int>()
            while (size-- > 0) {
                val node = queue.poll()
                list += node.`val`
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            ret += list
        }
        return ret
    }
}