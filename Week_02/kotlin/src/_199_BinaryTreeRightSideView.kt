import java.util.*
import kotlin.collections.ArrayList

class _199_Dfs {
    // 根右左
    fun rightSideView(root: TreeNode?): List<Int> {
        val ret = arrayListOf<Int>()
        fun dfs(node: TreeNode?, depth: Int) {
            node ?: return
            if (ret.size == depth) ret += node.`val`
            dfs(node.right, depth + 1)
            dfs(node.left, depth + 1)
        }
        dfs(root, 0)
        return ret
    }

    class Bfs {
        fun rightSideView(root: TreeNode?): List<Int> {
            root ?: return emptyList()
            val q = LinkedList<TreeNode>().apply { offer(root) }
            val ret = ArrayList<Int>()
            while (q.isNotEmpty()) {
                var size = q.size
                while (size-- > 0) {
                    val n = q.poll()
                    n.left?.let { q.offer(it) }
                    n.right?.let { q.offer(it) }
                    if (size == 0) ret += n.`val`
                }
            }
            return ret
        }
    }
}