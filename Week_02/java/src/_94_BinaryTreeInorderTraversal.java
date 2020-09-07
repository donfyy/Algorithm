import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 第一遍：2020/05/27周三 ✅
 * 第二遍：2020/05/28周四 ✅
 * 第三遍：2020/06/03周一
 * 第四遍：2020/06/17周一
 */
class _94_BinaryTreeInorderTraversal {
    /**
     * 时间：O(n) 空间：O(logn 最差:O(n))
     */
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

    /**
     * 需要左根右读值，但最先被访问的是根左。
     * 根左顺序访问，逆序读值-->先进后出
     * 时间：O(n) 空间：O(logn 最差:O(n)))
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) return Collections.emptyList();
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> ret = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ret.add(root.val);
            root = root.right;
        }
        return ret;
    }

    static class SolutionMorris {
        // 时间O(n) 空间O(1)
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return Collections.emptyList();
            List<Integer> ret = new LinkedList<>();
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
                        p.right = root;
                        root = root.left;
                    } else {
                        p.right = null;
                        ret.add(root.val);
                        root = root.right;
                    }
                }
            }
            return ret;
        }
    }

    /**
     * 每个节点都会入栈两次，效率并不高
     */
    static class InorderIterative2 {
        // 时间O(n) 空间O(n)
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            if (root != null) stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.peek();
                if (root != null) {
                    stack.pop();
                    if (root.right != null) stack.push(root.right);
                    stack.push(root);
                    stack.push(null);
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