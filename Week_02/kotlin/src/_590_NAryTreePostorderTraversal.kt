import java.util.*

class _590_Iterative {
    fun postorder(root: Node?): List<Int> {
        val ret = LinkedList<Int>()
        val stack = LinkedList<Node>()
        root?.let { stack.push(it) }
        while (stack.isNotEmpty()) {
            val n = stack.pop()
            ret.offerFirst(n.`val`)
            n.children.forEach {
                it?.let { stack.push(it) }
            }
        }
        return ret
    }
}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}