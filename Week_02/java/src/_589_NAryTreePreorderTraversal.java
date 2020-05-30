import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 * 第一遍：2020/05/30周六 ✅
 * 第二遍：2020/05/31周日
 * 第三遍：2020/06/06周六
 * 第四遍：2020/06/13周六
 */
class _589_NAryTreePreorderTraversal {
    /**
     * 时间：O(n) 空间：O(k)k为树的层数，最差：O(n)
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> ret = new ArrayList<>();
        recursion(root, ret);
        return ret;
    }

    private void recursion(Node node, List<Integer> ret) {
        if (node == null) {
            return;
        }
        ret.add(node.val);

        List<Node> children = node.children;
        if (children != null && !children.isEmpty()) {
            for (Node child : children) {
                recursion(child, ret);
            }
        }

    }
    /**
     * 时间：O(n) 空间：O(k)k为树的层数，最差：O(n)
     */
    public List<Integer> preorder2(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<Node> stack = new LinkedList<>();
        List<Integer> ret = new LinkedList<>();

        stack.offerLast(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();

            ret.add(node.val);

            List<Node> children = node.children;
            if (children != null && !children.isEmpty()) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.offerLast(children.get(i));
                }
            }
        }

        return ret;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}