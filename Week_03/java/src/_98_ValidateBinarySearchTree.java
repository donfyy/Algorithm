/**
 * 第一遍：2020/09/12周六 ✅
 * 第二遍：2020/09/11周四
 * 第二遍：2020/06/12周二
 * 第三遍：2020/06/18周四
 * 第四遍：2020/07/02周四
 * 虽然磨磨唧唧的做出来了，但是也开心啊
 */
public class _98_ValidateBinarySearchTree {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return recursive(root);
        }

        private long pre = -Long.MAX_VALUE;

        private boolean recursive(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (!recursive(root.left)) {
                return false;
            }


            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            return recursive(root.right);
        }
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
