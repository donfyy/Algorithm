import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class _515_FindLargestValueInEachTreeRow {
    public List<Integer> largestValuesBfs1(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> ret = new LinkedList<>();
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            int max = Integer.MIN_VALUE;
            while (levelCount-- > 0) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ret.add(max);
        }
        return ret;
    }

    public List<Integer> largestValuesBfs2(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cl = 1, nl = 0, levelMax = Integer.MIN_VALUE;

        List<Integer> ret = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelMax = Math.max(levelMax, node.val);

            if (node.left != null) {
                queue.offer(node.left);
                nl++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nl++;
            }
            cl--;

            if (cl == 0) {
                ret.add(levelMax);

                cl = nl;
                nl = 0;
                levelMax = Integer.MIN_VALUE;
            }
        }
        return ret;
    }

    public List<Integer> largestValuesBfs3(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Queue<TreeNode> cl = new LinkedList<>();
        Queue<TreeNode> nl = new LinkedList<>();
        cl.offer(root);
        List<Integer> ret = new LinkedList<>();
        int levelMax = Integer.MIN_VALUE;
        while (!cl.isEmpty()) {
            TreeNode node = cl.poll();
            levelMax = Math.max(levelMax, node.val);

            if (node.left != null) nl.offer(node.left);
            if (node.right != null) nl.offer(node.right);

            if (cl.isEmpty()) {
                Queue<TreeNode> temp = cl;
                cl = nl;
                nl = temp;

                ret.add(levelMax);
                levelMax = Integer.MIN_VALUE;
            }
        }

        return ret;
    }

    static class RecursiveDfs1 {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            dfs(root, 0, ret);
            return ret;
        }

        void dfs(TreeNode node, int level, List<Integer> ret) {
            if (node == null) return;
            if (ret.size() <= level) ret.add(Integer.MIN_VALUE);
            if (node.val > ret.get(level)) ret.set(level, node.val);

            dfs(node.left, level + 1, ret);
            dfs(node.right, level + 1, ret);
        }
    }

    class RecursiveDfs2 {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            dfs(root, 0, ret);
            return ret;
        }

        void dfs(TreeNode node, int level, List<Integer> ret) {
            if (node == null) return;
            if (ret.size() <= level) ret.add(Integer.MIN_VALUE);

            dfs(node.left, level + 1, ret);
            if (node.val > ret.get(level)) ret.set(level, node.val);
            dfs(node.right, level + 1, ret);
        }
    }

    class RecursiveDfs3 {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            dfs(root, ret, 0);
            return ret;
        }

        void dfs(TreeNode node, List<Integer> ret, int level) {
            if (node == null) return;
            if (ret.size() <= level) ret.add(Integer.MIN_VALUE);

            dfs(node.left, ret, level + 1);
            dfs(node.right, ret, level + 1);

            if (node.val > ret.get(level)) ret.set(level, node.val);
        }
    }

    class IterableDfs {
        class Node {
            Node(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }

            TreeNode node;
            int level;
        }

        public List<Integer> largestValues(TreeNode root) {
            if (root == null) return Collections.emptyList();
            LinkedList<Node> stack = new LinkedList<>();
            stack.offerLast(new Node(root, 0));
            List<Integer> ret = new ArrayList<>();
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                if (ret.size() <= node.level) ret.add(Integer.MIN_VALUE);
                if (node.node.val > ret.get(node.level)) ret.set(node.level, node.node.val);

                if (node.node.right != null) stack.offerLast(new Node(node.node.right, node.level + 1));
                if (node.node.left != null) stack.offerLast(new Node(node.node.left, node.level + 1));
            }
            return ret;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}