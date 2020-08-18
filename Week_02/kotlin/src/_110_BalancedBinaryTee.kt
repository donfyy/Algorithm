fun isBalanced(root: TreeNode?): Boolean {
    fun depth(node: TreeNode?): Int {
        if (node == null) return 0
        val l = depth(node.left)
        val r = depth(node.right)
        return if (l == -1 || r == -1 || Math.abs(r - l) > 1) {
            -1
        } else {
            maxOf(l, r) + 1
        }
    }

    return depth(root) != -1
}