/**
 * 第一遍：2020/07/28周一 ✅
 * 第二遍：2020/06/11周四
 * 第二遍：2020/06/13周六
 * 第三遍：2020/06/17周三
 * 第四遍：2020/07/01周三
 */
class _104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
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