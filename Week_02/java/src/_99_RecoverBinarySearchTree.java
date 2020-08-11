import java.util.Deque;
import java.util.LinkedList;

/**
 * 第一遍：2020/08/08周六 ✅
 * 第二遍：2020/08/09周日 ✅
 * 第三遍：2020/08/11周二 ✅
 * 第三遍：2020/07/08周四
 * 抄起来挺简单，但我自己想不出来啊。。。
 */
class _99_RecoverBinarySearchTree {
    class SolutionMorris {
        public void recoverTree(TreeNode root) {
            TreeNode x = null, y = null, pre = null, predecessor = null, node = root;
            while (node != null) {
                if (node.left != null) {
                    predecessor = node.left;
                    while (predecessor.right != null && predecessor.right != node) {
                        predecessor = predecessor.right;
                    }

                    if (predecessor.right == null) {
                        predecessor.right = node;
                        node = node.left;
                    } else {
                        if (pre != null && pre.val > node.val) {
                            y = node;
                            if (x == null) {
                                x = pre;
                            }
                        }
                        predecessor.right = null;
                        pre = node;
                        node = node.right;
                    }
                } else {
                    if (pre != null && pre.val > node.val) {
                        y = node;
                        if (x == null) {
                            x = pre;
                        }
                    }
                    pre = node;
                    node = node.right;
                }
            }

            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null, x = null, y = null, node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (pre != null && pre.val > node.val) {
                y = node;
                if (x == null) {
                    x = pre;
                } else {
                    break;
                }
            }
            pre = node;
            node = node.right;
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
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
}