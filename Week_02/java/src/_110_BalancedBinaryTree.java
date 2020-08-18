/**
 * 第一遍：2020/08/17周一 ✅
 * 第二遍：2020/08/19周三 ✅
 * 第三遍：2020/06/06周六
 * 第四遍：2020/06/13周六
 */
class _110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    int depth(TreeNode node) {
        if (node == null) return 0;
        int l = depth(node.left);
        int r = depth(node.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}