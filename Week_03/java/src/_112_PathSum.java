/**
 * 第一遍：2020/07/07周二 ✅
 * 第二遍：2020/05/28周四
 * 第三遍：2020/06/03周一
 * 第四遍：2020/06/17周一
 * 没有仔细审题，叶子结点是没有子节点的节点
 * 题目要求判断是否存在从根节点到叶子结点的路径，该路径上所有节点值想家等于目标和
 */
class _112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return dfs(root, sum);
    }

    boolean dfs(TreeNode node, int currentSum) {
        if (node == null) return false;
        if (node.left == null && node.right == null) {
            return currentSum - node.val == 0;
        }

        return dfs(node.left, currentSum - node.val)
                || dfs(node.right, currentSum - node.val);
    }
}