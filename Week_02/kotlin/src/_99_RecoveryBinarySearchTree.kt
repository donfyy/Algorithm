import java.util.*

fun recoverTree(root: TreeNode?): Unit {
    val stack = LinkedList<TreeNode>()
    var node = root
    var x: TreeNode? = null
    var y: TreeNode? = null
    var pre: TreeNode? = null
    while (node != null || stack.isNotEmpty()) {
        while (node != null) {
            stack.push(node)
            node = node.left
        }
        node = stack.pop()
        if (pre != null && pre.`val` > node?.`val`!!) {
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

    x?.`val` = y?.`val`?.also { y.`val` = x?.`val`!! }!!
}

class SolutionMorris {
    fun recoverTree(root: TreeNode?): Unit {
        var x: TreeNode? = null
        var y: TreeNode? = null
        var pre: TreeNode? = null
        var node = root
        while (node != null) {
            if (node.left != null) {
                var predecessor = node.left
                while (predecessor?.right != null && predecessor.right != node) {
                    predecessor = predecessor.right
                }

                if (predecessor?.right == null) {
                    predecessor?.right = node
                    node = node.left
                } else {
                    predecessor.right = null
                    // process root logic
                    if (pre != null && pre.`val` > node.`val`) {
                        y = node
                        if (x == null) {
                            x = pre
                        }
                    }
                    pre = node
                    node = node.right
                }
            } else {
                // process root logic
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

        x?.`val` = y?.`val`?.also { y.`val` = x?.`val`!! }!!
    }
}