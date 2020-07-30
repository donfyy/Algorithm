class _337_HouseRobberIII_ {
    fun rob(root: TreeNode?): Int {
        //f(node, 0)在底向上偷到该node节点时， 不偷该节点时的最大金额
        //f(node, 1)自底向上偷到该node节点时， 偷该节点时的最大金额
        //f(node, 0) = max(f(node.left, 0), f(ndoe.left, 1)) + max(f(node.right, 0), f(node.right, 1))
        //f(node, 1) = node.val + f(node.left, 0) + f(node.right, 0)
        //如果节点为null，那么偷或不偷该节点时的最大值就是0

        val amount = robInternal(root)
        return amount[0].coerceAtLeast(amount[1])
    }

    fun robInternal(node: TreeNode?): IntArray {
        if (node == null) {
            return IntArray(2)
        }

        val left = robInternal(node.left)
        val right = robInternal(node.right)

        val ret = IntArray(2)
        ret[0] = left[0].coerceAtLeast(left[1]) + right[0].coerceAtLeast(right[1])
        ret[1] = node.`val` + left[0] + right[0]
        return ret
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}