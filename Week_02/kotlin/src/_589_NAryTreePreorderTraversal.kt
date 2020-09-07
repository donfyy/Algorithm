import java.util.*

class _589_Itarative {
    fun preorder(root: Node?): List<Int> {
        val ret = mutableListOf<Int>()
        val stack = LinkedList<Node>()
        root?.let { stack.push(it) }
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            ret += node.`val`
            val lastIndex = node.children.lastIndex
            for (i in lastIndex downTo 0) {
                node.children[i]?.let { stack.push(it) }
            }
        }
        return ret
    }
}