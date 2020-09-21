public class _538_ConvertBstToGreaterTree {
    class UsingMorris {
        // O(n) O(1)
        public TreeNode convertBST(TreeNode root) {
            int sum = 0;
            TreeNode ret = root;
            while (root != null) {
                if (root.right == null) {
                    sum += root.val;
                    root.val = sum;
                    root = root.left;
                } else {
                    TreeNode p = root.right;
                    while (p.left != null && p.left != root) {
                        p = p.left;
                    }
                    if (p.left == null) {
                        p.left = root;
                        root = root.right;
                    } else {
                        p.left = null;
                        sum += root.val;
                        root.val = sum;
                        root = root.left;
                    }
                }
            }
            return ret;
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
