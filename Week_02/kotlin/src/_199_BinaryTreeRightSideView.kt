class _199_Dfs {
    // 根右左
    fun rightSideView(root: TreeNode?): List<Int> {
        val ret = arrayListOf<Int>()
        fun dfs(node: TreeNode?, depth: Int) {
            node ?: return
            if (ret.size == depth) ret += node.`val`
            dfs(node.right, depth + 1)
            dfs(node.left, depth + 1)
        }
        dfs(root, 0)
        return ret
    }
}