class _222_CountCompleteTreeNodes_ {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    class Solution {
        fun countNodes(root: TreeNode?): Int {
            // 二叉树深度h, 节点个数[2^(h - 1), 2^h)
            // 二叉树的节点数为x，则第x个节点(从1开始)的二进制位就是到该节点的路径
            // 因此可以使用二分法
            root ?: return 0
            var h = 0
            var node = root
            while (node?.left != null) {
                h++
                node = node?.left
            }
            if (h == 0) return 1
            var l = 1 shl h
            var r = 1 shl (h + 1)
            while (l < r) {
                val m = (l + r) ushr 1
                if (exists(root, m, h)) {
                    l = m + 1
                } else {
                    r = m
                }
            }
            return l - 1
        }

        fun exists(root: TreeNode?, k: Int, h: Int): Boolean {
            var level = 1 shl (h - 1)
            var node = root
            while (level != 0) {
                if ((level and k) == 0) {
                    node = node?.left
                } else {
                    node = node?.right
                }
                level = level shr 1
            }
            return node != null
        }
    }
}