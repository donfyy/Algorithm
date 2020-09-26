class _113_Dfs {
    // O(n^2) O(n)
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val ret = arrayListOf<List<Int>>()
        root ?: return ret
        val path = arrayListOf<Int>()
        fun dfs(node: TreeNode, sum: Int) {
            path += node.`val`
            val rem = sum - node.`val`
            if (node.left == null && node.right == null) {
                if (rem == 0) ret += path.toList()
            } else {
                node.left?.let { dfs(it, rem) }
                node.right?.let { dfs(it, rem) }
            }
            path.removeAt(path.lastIndex)
        }
        dfs(root, sum)
        return ret
    }
}