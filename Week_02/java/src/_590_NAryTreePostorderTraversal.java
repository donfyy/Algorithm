import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 * 第一遍：2020/05/30周六 ✅
 * 第二遍：2020/05/31周日
 * 第二遍：2020/06/02周二 ✅
 * 第三遍：2020/06/06周六
 * 第四遍：2020/06/13周六
 */
class _590_NAryTreePostorderTraversal {
    /**
     * 时间：O(n) 空间：O(k)k为树的层数，最差：O(n)
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> ret = new ArrayList<>();

        recursion(root, ret);
        return ret;
    }

    private void recursion(Node node, List<Integer> ret) {
        if (node == null) {
            return;
        }

        List<Node> children = node.children;

        if (children != null && !children.isEmpty()) {
            for (Node child : children) {
                recursion(child, ret);
            }
        }

        ret.add(node.val);
    }
    /**
     * 时间：O(n) 空间：O(k)k为树的层数，最差：O(n)
     * 挺巧妙的: 先序：根-左-右   后序：左-右-根   后序逆序：根-右-左
     */
    public List<Integer> postorder2(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> ret = new LinkedList<>();

        stack.offerLast(root);

        while (!stack.isEmpty()) {
            Node node = stack.pollLast();

            ret.offerFirst(node.val);

            List<Node> children = node.children;

            if (children != null && !children.isEmpty()) {
                for (Node child : children) {
                    stack.offerLast(child);
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