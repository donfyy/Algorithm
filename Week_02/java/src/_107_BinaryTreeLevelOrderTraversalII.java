import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _107_BinaryTreeLevelOrderTraversalII {
    static class Bfs {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) return Collections.emptyList();
            LinkedList<List<Integer>> ret = new LinkedList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>(size);
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                ret.offerFirst(list);
            }
            return ret;
        }
    }

    static class Dfs {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) return Collections.emptyList();
            ArrayList<List<Integer>> ret = new ArrayList<>();
            dfs(root, 0, ret);
            Collections.reverse(ret);
            return ret;
        }

        void dfs(TreeNode root, int level, List<List<Integer>> ret) {
            if (root == null) return;
            if (level == ret.size()) ret.add(new ArrayList<>());
            ret.get(level).add(root.val);
            dfs(root.left, level + 1, ret);
            dfs(root.right, level + 1, ret);
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
