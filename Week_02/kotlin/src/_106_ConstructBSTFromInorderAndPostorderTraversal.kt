class _106_Dfs {
    // O(n) O(n)
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val table = HashMap<Int, Int>().apply { inorder.forEachIndexed { idx, v -> this[v] = idx } }
        fun dfs(iStart: Int, iEnd: Int, pStart: Int, pEnd: Int): TreeNode? {
            if (iStart > iEnd) return null
            val ret = TreeNode(postorder[pEnd])
            val len = table[ret.`val`]!! - iStart
            ret.left = dfs(iStart, iStart + len - 1, pStart, pStart + len - 1)
            ret.right = dfs(iStart + len + 1, iEnd, pStart + len, pEnd - 1)
            return ret
        }
        return dfs(0, inorder.lastIndex, 0, postorder.lastIndex)
    }
}