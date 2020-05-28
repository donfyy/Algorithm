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

    /**
     * 挺难的，炒了一遍，没理解透
     * 时间:O(n) 空间:O(logn) 最差:O(n)
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> ret = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr!= null || !stack.isEmpty()) {
            if (curr != null) {
                ret.offerFirst(curr.val);

                stack.offerLast(curr);
                curr = curr.right;
            } else {
                curr = stack.pollLast();

                curr = curr.left;
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