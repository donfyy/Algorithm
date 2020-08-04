class _337_HouseRobberIII_ {
    fun rob(root: TreeNode?): Int {
        //f(node, 0)在底向上偷到该node节点时， 不偷该节点时的最大金额
        //f(node, 1)自底向上偷到该node节点时， 偷该节点时的最大金额
        //f(node, 0) = max(f(node.left, 0), f(node.left, 1)) + max(f(node.right, 0), f(node.right, 1))
        //f(node, 1) = node.val + f(node.left, 0) + f(node.right, 0)
        //如果节点为null，那么偷或不偷该节点时的最大值就是0

        return robInternal(root).let { it[0].coerceAtLeast(it[1]) }
    }

    fun robInternal(node: TreeNode?): IntArray {
        return node?.let {
            val left = robInternal(it.left)
            val right = robInternal(it.right)
            intArrayOf(
                    left[0].coerceAtLeast(left[1]) + right[0].coerceAtLeast(right[1]),
                    it.`val` + left[0] + right[0]
            )
        } ?: IntArray(2)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}