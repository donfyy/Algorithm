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
class _429_NAryTreeLevelOrderTraversal {
    /**
     * 时间：O(n) 每个节点要被访问两次，应该还有一道之字形打印树的题目。
     * 空间：O(n)
     */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<Node> queue = new LinkedList<>();
        int cl = 1;
        int nl = 0;
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> clList = new ArrayList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            clList.add(node.val);
            cl--;
            List<Node> children = node.children;
            if (children != null && !children.isEmpty()) {
                for (Node child : children) {
                    if (child != null) {
                        nl++;
                        queue.offerLast(child);
                    }
                }
            }

            if (cl == 0) {
                cl = nl;
                nl = 0;
                ret.add(clList);
                clList = new ArrayList<>();
            }
        }

        return ret;
    }

    /**
     * 使用两个队列分别记录当前层节点和下一层节点
     * 时间：O(n) 每个节点要被访问两次，应该还有一道之字形打印树的题目。
     * 空间：O(n)
     */
    public List<List<Integer>> levelOrder2(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<List<Integer>> ret = new LinkedList<>();
        LinkedList<Node> cl = new LinkedList<>();
        LinkedList<Node> nl = new LinkedList<>();
        List<Integer> clVal = new LinkedList<>();

        cl.add(root);

        while (!cl.isEmpty()) {
            Node node = cl.pollFirst();

            clVal.add(node.val);

            List<Node> children = node.children;

            if (children != null && !children.isEmpty()) {
                for (Node child : children) {
                    if (child != null) {
                        nl.add(child);
                    }
                }
            }

            if (cl.isEmpty()) {
                LinkedList<Node> temp = cl;
                cl = nl;
                nl = temp;
                ret.add(clVal);
                clVal = new LinkedList<>();
            }
        }
        return ret;
    }

    //还有一种解法是将层数和层结果做一个映射，然后递归每个节点，这个节点自己将数值添加进所属层结果列表。
    //时间：O(n)
    // 空间：  O(logk)k表示层数，最差为O(n);
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