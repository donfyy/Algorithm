import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 第一遍：2020/05/27周三 ✅
 * 第二遍：2020/05/28周四 ✅
 * 第三遍：2020/09/07周一 ✅
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

    static class Morris {
        // 时间:O(n) 空间:O(1)
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            while (root != null) {
                if (root.left == null) {
                    ret.add(root.val);
                    root = root.right;
                } else {
                    TreeNode p = root.left;
                    while (p.right != null && p.right != root) {
                        p = p.right;
                    }
                    if (p.right == null) {
                        ret.add(root.val);
                        p.right = root;
                        root = root.left;
                    } else {
                        p.right = null;
                        root = root.right;
                    }
                }
            }
            return ret;
        }
    }

    static class Iterative1 {
        // 时间:O(n) 空间:O(logn) 最差:O(n)
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
    }

    static class Iterative2 {
        // 时间:O(n) 空间:O(n)
        public List<Integer> preorderTraversal(TreeNode root) {
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
    }

    static class Iterative3 {
        // 时间:O(n) 空间:O(n)
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            if (root != null) stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.peek();
                if (root != null) {
                    stack.pop();
                    if (root.right != null) stack.push(root.right);
                    if (root.left != null) stack.push(root.left);
                    stack.push(root);
                    stack.push(null);
                } else {
                    stack.pop();
                    root = stack.pop();
                    ret.add(root.val);
                }
            }
            return ret;
        }
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