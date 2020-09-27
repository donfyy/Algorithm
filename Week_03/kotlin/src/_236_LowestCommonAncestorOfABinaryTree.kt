class _236_Recur {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var ret: TreeNode? = null
        fun dfs(node: TreeNode?): Boolean {
            node ?: return false
            val left = dfs(node.left)
            val right = dfs(node.right)
            if ((left && right) || ((node == p || node == q) && (left || right))) {
                ret = node
            }
            return left || right || node == p || node == q
        }
        dfs(root)
        return ret
    }
}

class _236_ReturnTreeNode {
    // 返回值表示p和q的最近公共祖先，或者p或q，或者null
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root == p || root == q) return root
        val l = lowestCommonAncestor(root.left, p, q)
        val r = lowestCommonAncestor(root.right, p, q)
        return when {
            l != null && r != null -> root
            l != null -> l
            r != null -> r
            else -> null
        }
    }
}

