import java.util.*

fun recoverTree(root: TreeNode?): Unit {
    var node = root
    var pre: TreeNode? = null
    var x: TreeNode? = null
    var y: TreeNode? = null
    val stack = LinkedList<TreeNode>()
    while (node != null || stack.isNotEmpty()) {
        while (node != null) {
            stack.push(node)
            node = node.left
        }
        node = stack.pop()
        if (pre != null && pre.`val` > node.`val`) {
            y = node
            if (x == null) {
                x = pre
            } else {
                break
            }
        }
        pre = node
        node = node.right
    }
    if (x != null && y != null) {
        x.`val` = y.`val`.also { y.`val` = x.`val` }
    }
}

class SolutionMorris {
    fun recoverTree(root: TreeNode?): Unit {
        var node = root
        var x: TreeNode? = null
        var y: TreeNode? = null
        var pre: TreeNode? = null
        while (node != null) {
            if (node.left == null) {
                if (pre != null && pre.`val` > node.`val`) {
                    y = node
                    if (x == null) {
                        x = pre
                    }
                }
                pre = node
                node = node.right
            } else {
                var p = node.left
                while (p?.right != null && p.right != node) {
                    p = p.right
                }

                if (p?.right == null) {
                    p?.right = node
                    node = node.left
                } else {
                    p.right = null
                    if (pre != null && pre.`val` > node.`val`) {
                        y = node
                        if (x == null) {
                            x = pre
                        }
                    }
                    pre = node
                    node = node.right
                }
            }
        }

        if (x != null && y != null) {
            x.`val` = y.`val`.also { y.`val` = x.`val` }
        }
    }
}