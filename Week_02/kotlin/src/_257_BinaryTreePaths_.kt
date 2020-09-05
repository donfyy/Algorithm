fun binaryTreePaths(root: TreeNode?): List<String> {
    val ret = mutableListOf<String>()
    root ?: return ret
    val path = StringBuilder()
    fun dfs(node: TreeNode) {
        val len = path.length
        if (len != 0) path.append("->")
        path.append(node.`val`)
        if (node.left == null && node.right == null) ret += path.toString()
        node.left?.let { dfs(it) }
        node.right?.let { dfs(it) }
        path.setLength(len)
    }
    dfs(root)
    return ret
}
