import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 第一遍：2020/06/10周三 ✅
 * 第二遍：2020/06/11周四
 * 第二遍：2020/06/13周六 ✅
 * 第三遍：2020/06/17周三
 * 第四遍：2020/07/01周三
 */
class _102_BinaryTreeLevelOrderTraversal {
    /**
     * 用一个for循环每个节点，一个队列保存所有还未处理的节点，两个计数器分别记录当前层剩余的节点数和下一层要处理的节点数
     * 时间O(n)
     * 空间O(n)
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ret = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        LinkedList<Integer> levelRet = new LinkedList<>();
        int cl = 1;
        int nl = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            levelRet.add(node.val);
            cl--;

            if (node.left != null) {
                queue.offerLast(node.left);
                nl++;
            }
            if (node.right != null) {
                queue.offerLast(node.right);
                nl++;
            }

            if (cl == 0) {
                cl = nl;
                nl = 0;
                ret.add(levelRet);
                levelRet = new LinkedList<>();
            }
        }
        return ret;
    }

    /**
     * 一层for循环遍历每个节点，用两个队列分别记录当前层与下一层的节点
     * 时间O(n)
     * 空间O(n)
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ret = new LinkedList<>();
        List<Integer> levelRet = new LinkedList<>();
        LinkedList<TreeNode> cl = new LinkedList<>();
        LinkedList<TreeNode> nl = new LinkedList<>();
        cl.offerLast(root);
        while (!cl.isEmpty()) {
            TreeNode node = cl.pollFirst();
            levelRet.add(node.val);

            if (node.left != null) {
                nl.offerLast(node.left);
            }
            if (node.right != null) {
                nl.offerLast(node.right);
            }

            if (cl.isEmpty()) {
                LinkedList<TreeNode> temp = cl;
                cl = nl;
                nl = temp;

                ret.add(levelRet);
                levelRet = new LinkedList<>();
            }

        }
        return ret;
    }

    /**
     * 两个for循环，外层是层的for，内层是该层节点的for，代码比较简洁。
     * 时间O(n)
     * 空间O(n)
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) return Collections.emptyList();

        LinkedList<List<Integer>> ret = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            List<Integer> levelRet = new LinkedList<>();
            ret.add(levelRet);
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.remove();
                levelRet.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return ret;
    }

    /**
     * dfs在leetcode中是最快的，相比bfs解法，栈帧的压入弹出比堆中队列的访问要快。
     * 时间O(n)
     * 空间O(logn) 最差O(n)
     */
    public List<List<Integer>> levelOrder4(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> ret = new ArrayList<>();
        dfs(0, root, ret);
        return ret;
    }

    void dfs(int level, TreeNode node, List<List<Integer>> ret) {
        if (node == null) return;
        if (ret.size() <= level) ret.add(new LinkedList<>());

        ret.get(level).add(node.val);
        dfs(level + 1, node.left, ret);
        dfs(level + 1, node.right, ret);
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