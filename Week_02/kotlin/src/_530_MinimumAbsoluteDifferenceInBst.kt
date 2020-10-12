import java.util.*
import kotlin.math.abs

class _530_Dfs_Iterative {
    fun getMinimumDifference(root: TreeNode?): Int {
        val stack = LinkedList<TreeNode>()
        var node = root
        var ret = Integer.MAX_VALUE
        var pre: TreeNode? = null
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                stack.push(node)
                node = node.left
            }
            node = stack.pop()
            if (pre != null) {
                ret = minOf(ret, abs(pre.`val` - node!!.`val`))
            }
            pre = node
            node = node.right
        }
        return ret
    }
}