fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}