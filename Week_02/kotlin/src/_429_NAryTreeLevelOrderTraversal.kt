import java.util.*

class _429_Bfs {
    fun levelOrder(root: Node?): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        val queue = LinkedList<Node>()
        root?.let { queue.offer(it) }
        while (queue.isNotEmpty()) {
            var size = queue.size
            val list = mutableListOf<Int>()
            while (size-- > 0) {
                val node = queue.poll()
                list += node.`val`
                node.children.forEach {
                    it?.let { queue.offer(it) }
                }
            }
            ret += list
        }
        return ret
    }
}