/**
 * 第一遍：2020/06/08周一 ✅
 * 第二遍：2020/06/09周二
 * 第三遍：2020/06/15周一
 * 第四遍：2020/06/29周一
 */
class _236_LowestCommonAncestorOfABinaryTree {
    private TreeNode ancestor;

    /**
     * 时间O(n)
     * 空间O(logn) 最差O(n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ancestor;
    }

    /**
     * 如果node是p和q的最低公共祖先，
     * 则node的左子树包含p或q并且node的右子树包含p或者q，
     * 或者 node是p或q并且node的左子树或右子树包含p或q
     *
     * @return true表示node这棵树包含p或q
     */
    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        boolean l = dfs(node.left, p, q);
        boolean r = dfs(node.right, p, q);
        if ((l && r) || ((r || l) && (node.val == q.val || node.val == p.val))) {
            ancestor = node;
        }
        return node.val == q.val || node.val == p.val || l || r;
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