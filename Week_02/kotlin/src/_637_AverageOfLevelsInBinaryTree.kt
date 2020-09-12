import java.util.*

class _637_Bfs {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val list = mutableListOf<Double>()
        root?:return list.toDoubleArray()
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            var size = queue.size
            var sum = 0.0
            val count = size
            while (size-- > 0) {
                val node = queue.poll()
                sum += node.`val`
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            list += sum / count
        }
        return list.toDoubleArray()
    }
}