import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 时间：O(n) 空间：O(logn)
 */
class _94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<>();
        recursive(root, ret);
        return ret;
    }

    private void recursive(TreeNode node, List<Integer> ret) {
        if (node == null) {
            return;
        }
        recursive(node.left, ret);
        ret.add(node.val);
        recursive(node.right, ret);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> ret = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.offerLast(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pollLast();
            ret.add(node.val);

            if (node.right != null) {
                cur = node.right;
            }


        }
        return ret;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}