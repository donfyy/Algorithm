import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 第一遍：2020/05/27周三 ✅
 * 第二遍：2020/05/28周四 ✅
 * 第三遍：2020/09/07周一 ✅
 * 第四遍：2020/06/17周一
 */
class _145_BinaryTreePostorderTraversal {
    /**
     * 时间:O(n) 空间:O(logn) 最差:O(n)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<Integer> ret = new ArrayList<>();

        recursive(root, ret);
        return ret;
    }

    private void recursive(TreeNode node, List<Integer> ret) {
        if (node == null) {
            return;
        }
        recursive(node.left, ret);
        recursive(node.right, ret);
        ret.add(node.val);
    }

    static class Morris {
        // 时间:O(n) 空间:O(n)
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> ret = new LinkedList<>();
            while (root != null) {
                if (root.right == null) {
                    ret.offerFirst(root.val);
                    root = root.left;
                } else {
                    TreeNode p = root.right;
                    while (p.left != null && p.left != root) {
                        p = p.left;
                    }
                    if (p.left == null) {
                        p.left = root;
                        ret.offerFirst(root.val);
                        root = root.right;
                    } else {
                        p.left = null;
                        root = root.left;
                    }
                }
            }
            return ret;
        }
    }

    static class Iterative1 {
        // 时间:O(n) 空间:O(logn) 最差:O(n)
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> ret = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                if (root == null) continue;
                ret.offerFirst(root.val);
                stack.push(root.left);
                stack.push(root.right);
            }
            return ret;
        }

    }

    static class Iterative2 {
        /**
         * 挺难的，炒了一遍，没理解透
         * 时间:O(n) 空间:O(logn) 最差:O(n)
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> ret = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    ret.offerFirst(root.val);
                    stack.push(root);
                    root = root.right;
                }
                root = stack.pop();
                root = root.left;
            }
            return ret;
        }

    }

    static class Iterative3 {
        // 时间:O(n) 空间:O(logn) 最差:O(n)
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> ret = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            if (root != null) stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.peek();
                if (root != null) {
                    stack.push(null);
                    if (root.right != null) stack.push(root.right);
                    if (root.left != null) stack.push(root.left);
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