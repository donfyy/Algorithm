import java.util.LinkedList;
import java.util.Queue;

/**
 * 第一遍：2020/08/21周五 ✅
 * 第二遍：2020/08/22周六 ✅
 * 第三遍：2020/06/06周六
 * 第四遍：2020/06/13周六
 */
class _111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ret = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return ret + 1;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ret++;
        }
        return ret;
    }

    class SolutionDFS {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            return depth(root);
        }

        int depth(TreeNode root) {
            if (root == null) return Integer.MAX_VALUE;
            if (root.left == null && root.right == null) return 1;
            return Math.min(depth(root.left), depth(root.right)) + 1;
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