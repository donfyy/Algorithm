import java.util.Deque;
import java.util.LinkedList;

/**
 * 第一遍：2020/08/03周一 ✅
 * 第二遍：2020/07/17周五
 * 第三遍：2020/07/18周六
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            if (prev != null) {
                prev.left = null;
                prev.right = node;
            }
            stack.push(node.right);
            stack.push(node.left);
            prev = node;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public void flatten(TreeNode root) {
            TreeNode node = root;
            while (node != null) {
                if (node.left != null) {
                    TreeNode next = node.left;
                    TreeNode predecessor = next;
                    while (predecessor.right != null) {
                        predecessor = predecessor.right;
                    }
                    predecessor.right = node.right;
                    node.left = null;
                    node.right = next;
                }
                node = node.right;
            }
        }

    }
}