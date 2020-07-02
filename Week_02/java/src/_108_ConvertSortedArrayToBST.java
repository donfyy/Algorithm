/**
 * 第一遍：2020/07/03周五 ✅
 * 第二遍：2020/05/31周日
 * 第三遍：2020/06/06周六
 * 第四遍：2020/06/13周六
 */
class _108_ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return dfs(nums, 0, nums.length - 1);
    }

    TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int m = l + ((r - l) >>> 1);
        TreeNode node = new TreeNode(nums[m]);
        node.left = dfs(nums, l, m - 1);
        node.right = dfs(nums, m + 1, r);
        return node;
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