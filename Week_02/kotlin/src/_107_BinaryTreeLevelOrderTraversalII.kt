import java.util.*

class _107_Dfs {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        root ?: return emptyList()
        val ret = mutableListOf<MutableList<Int>>()
        fun dfs(node: TreeNode, level: Int) {
            if (level == ret.size) ret += mutableListOf<Int>()
            ret[level].add(node.`val`)
            node.left?.let { dfs(it, level + 1) }
            node.right?.let { dfs(it, level + 1) }
        }
        dfs(root, 0)
        return ret.apply { reverse() }
    }
}

class _107_Bfs {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        root ?: return emptyList()
        val queue = LinkedList<TreeNode>().apply { offer(root) }
        val ret = LinkedList<List<Int>>()
        while (queue.isNotEmpty()) {
            var size = queue.size
            val list = mutableListOf<Int>()
            while (size-- > 0) {
                val node = queue.poll()
                list += node.`val`
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            ret.offerFirst(list)
        }
        return ret
    }
}