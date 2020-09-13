import java.util.*

// 还是kt写起来舒服
class _297_CodecBfs {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val sb = StringBuilder()
        val queue = LinkedList<TreeNode?>().apply { offer(root) }
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node == null) {
                sb.append("$,")
            } else {
                sb.append(node.`val`).append(',')
                queue.offer(node.left)
                queue.offer(node.right)
            }
        }
        return sb.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        var i = 0
        var num = 0
        val n = data.length
        fun readNumber(): Boolean {
            var j = i
            var read = false
            while (j < n && data[j] != ',') j++
            if (i < n && data[i] != '$') {
                num = data.substring(i, j).toInt()
                read = true
            }
            i = j + 1
            return read
        }
        if (!readNumber()) return null
        val root = TreeNode(num)
        var parent: TreeNode
        val queue = LinkedList<TreeNode>().apply { offer(root) }
        while (i < n) {
            parent = queue.poll()
            if (readNumber()) parent.left = TreeNode(num);
            if (readNumber()) parent.right = TreeNode(num);
            parent.left?.let { queue.offer(it) }
            parent.right?.let { queue.offer(it) }
        }
        return root
    }
}
