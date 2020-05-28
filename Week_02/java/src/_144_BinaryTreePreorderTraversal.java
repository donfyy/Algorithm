import java.util.LinkedList;
import java.util.List;

/**
 * 第一遍：2020/05/27周三 ✅
 * 第二遍：2020/05/28周四 ✅
 * 第三遍：2020/06/03周一
 * 第四遍：2020/06/17周一
 */
class _144_BinaryTreePreorderTraversal {
    /**
     * 时间:O(n) 空间:O(logn) 最差:O(n)
     */
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

    /**
     * 又是一种思路
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                ret.add(curr.val);

                stack.offerLast(curr);
                curr = curr.left;
            } else {
                curr = stack.pollLast();
                curr = curr.right;
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