import java.util.LinkedList;
import java.util.List;

/**
 * 时间:O(n) 空间:O(logn) 最差:O(n)
 */
class _144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        recursive(root, ret);
        return ret;
    }
    private void recursive(TreeNode node, List<Integer> ret) {
        if (node == null) {
            return;
        }
        
        ret.add(node.val);
        recursive(node.left, ret);
        recursive(node.right, ret);
    }

    /**
     * 使用一个栈模拟递归
     * 时间:O(n) 空间:O(logn) 最差:O(n)
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            if (node == null) {
                continue;
            }
            ret.add(node.val);

            stack.offerLast(node.right);
            stack.offerLast(node.left);
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