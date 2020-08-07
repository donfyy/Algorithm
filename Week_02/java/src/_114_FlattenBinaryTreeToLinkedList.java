import java.util.Deque;
import java.util.LinkedList;

/**
 * 第一遍：2020/08/03周一 ✅
 * 第二遍：2020/08/04周二 ✅
 * 第三遍：2020/08/04周四 ✅
 * 第四遍：2020/08/04周五 ✅
 * 第五遍：2020/08/04周五
 */
class _114_FlattenBinaryTreeToLinkedList {
    //先序遍历，神似Morris算法，时间O(n)，空间O(1)
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    //先序遍历，时间O(n)，空间O(n)
    class SolutionPreorderIterative {
        public void flatten(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            TreeNode pre = null;
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node == null) continue;
                stack.push(node.right);
                stack.push(node.left);

                if (pre != null) {
                    pre.left = null;
                    pre.right = node;
                }
                pre = node;
            }
        }
    }

    //先序遍历，时间O(n)，空间O(logn)
    static class SolutionPreorderRecursive {
        public void flatten(TreeNode root) {
            dfs(root, null);
        }

        //将以node为跟节点二叉树转化成链表，并返回链表的尾节点
        //传入node这棵树的转换为链表后的头节点，返回转换后的尾节点
        //左子树的尾节点是右子树的头节点，右子树的尾节点是整棵树的尾节点
        TreeNode dfs(TreeNode node, TreeNode pre) {
            if (node == null) {
                return pre;
            }
            if (pre != null) {
                pre.left = null;
                pre.right = node;
            }

            TreeNode right = node.right;
            return dfs(right, dfs(node.left, node));
        }
    }

    static class SolutionPostOrderRecursive {
        public void flatten(TreeNode root) {
            dfs(root, null);
        }

        //将以node为跟节点二叉树转化成链表，并返回链表的头节点
        //传入node这棵树的转换为链表后的尾节点，返回转换后的头节点
        //右子树的头节点是左子树的尾节点，根节点是整棵树的头节点
        TreeNode dfs(TreeNode node, TreeNode next) {
            if (node == null) {
                return next;
            }

            node.right = dfs(node.left, dfs(node.right, next));
            node.left = null;
            return node;
        }
    }

    //这个解法不理解，需要躲过一遍
    static class SolutionPostOrderIterative {
        public void flatten(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode next = null;
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.right;
                }

                TreeNode top = stack.peek();
                if (top.left == null || top.left == next) {
                    stack.pop();
                    top.right = next;
                    top.left = null;
                    next = top;
                } else {
                    node = top.left;
                }
            }
        }
    }

    public static class TreeNode {
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

}