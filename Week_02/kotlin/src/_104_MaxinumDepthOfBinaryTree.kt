fun maxDepth(root: TreeNode?): Int {
    return if (root == null) 0 else Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}