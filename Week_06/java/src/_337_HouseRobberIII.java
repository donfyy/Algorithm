/**
 * 第一遍：2020/07/29周三 ✅
 * 第二遍：2020/06/29周一
 * 第三遍：2020/07/29周三
 * 第四遍：2020/07/05周日
 */
class _337_HouseRobberIII {
    public int rob(TreeNode root) {
        //f(node,0)表示自底向上，node不被偷的最大金额
        //f(node,1)表示自底向上，node被偷的最大金额
        //f(node,0) = max(f(node.left, 0), f(node.left,1) + max(f(node.right, 0), f(node.right, 1)
        //f(node,1) = v(node) + f(node.left, 0) + f(node.right, 1)
        int[] ret = dfs(root);
        return Math.max(ret[0], ret[1]);
    }

    int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] ret = new int[2];
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        ret[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ret[1] = node.val + left[0] + right[0];
        return ret;
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