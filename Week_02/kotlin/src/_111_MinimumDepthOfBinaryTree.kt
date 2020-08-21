fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0

    fun dfs(node: TreeNode?): Int {
        return if (node == null) {
            Integer.MAX_VALUE
        } else {
            if (node.left == null && node.right == null) {
                1
            } else {
                minOf(dfs(node.left), dfs(node.right)) + 1
            }
        }
    }
    return dfs(root)
}