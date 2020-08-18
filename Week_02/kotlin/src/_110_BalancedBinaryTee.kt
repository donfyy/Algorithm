fun isBalanced(root: TreeNode?): Boolean {
    fun depth(root: TreeNode?): Int {
        if (root == null) return 0
        val l = depth(root.left)
        val r = depth(root.right)
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1
        }
        return maxOf(l, r) + 1
    }
    return depth(root) != -1
}