class _129_SumRootToLeafNumbers_ {
    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    class Solution {
        fun sumNumbers(root: TreeNode?): Int {
            root?:return 0
            var path = 0
            var ret = 0
            fun dfs(node: TreeNode) {
                path = path * 10 + node.`val`
                node.left?.let { dfs(it) }
                node.right?.let { dfs(it) }
                if (node.left == null && node.right == null) {
                    ret += path
                }
                path /= 10
            }
            dfs(root)
            return ret
        }
    }
}