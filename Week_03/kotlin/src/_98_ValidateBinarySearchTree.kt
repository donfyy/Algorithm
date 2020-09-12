class _98_Morris {
    fun isValidBST(root: TreeNode?): Boolean {
        var node = root
        var prev = Long.MIN_VALUE
        while (node != null) {
            if (node.left == null) {
                if (node.`val` <= prev) return false
                prev = node.`val`.toLong()
                node = node.right
            } else {
                var predecessor = node.left!!
                while (predecessor.right != null && predecessor.right != node) {
                    predecessor = predecessor.right!!
                }
                if (predecessor.right == null) {
                    predecessor.right = node
                    node = node.left
                } else {
                    predecessor.right = null
                    if (node.`val` <= prev) return false
                    prev = node.`val`.toLong()
                    node = node.right
                }
            }
        }
        return true
    }
}