class _105_ {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val map = HashMap<Int, Int>()
        inorder.forEachIndexed { idx, v -> map[v] = idx }
        fun dfs(pStart: Int, pEnd: Int, iStart: Int, iEnd: Int): TreeNode? {
            if (pStart > pEnd) return null
            val root = TreeNode(preorder[pStart])
            val idx = map[preorder[pStart]]!!
            val len = idx - iStart
            root.left = dfs(pStart + 1, pStart + len, iStart, idx - 1)
            root.right = dfs(pStart + 1 + len, pEnd, idx + 1, iEnd)
            return root
        }
        return dfs(0, preorder.lastIndex, 0, inorder.lastIndex)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
