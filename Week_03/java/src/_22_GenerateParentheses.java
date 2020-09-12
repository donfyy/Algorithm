import java.util.*;

/**
 * 第一遍：2020/06/01周一 ✅
 * 第二遍：2020/06/02周二 ✅
 * 第三遍：2020/06/04周四 ✅
 * 第四遍：2020/06/13周六 ✅
 * 第三遍：2020/09/12周六 ✅
 * 第四遍：2020/06/22周一
 */
class _22_GenerateParentheses {
    /**
     * 时间：不到O(n^2n)  空间：O(n)
     */
    public List generateParenthesis(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }

        List<String> ret = new ArrayList<>();
        dfs(0, 0, n, ret, "");
        return ret;
    }

    /**
     * @param left  用掉的左括号的个数
     * @param right 用掉的右括号的个数
     * @param n     左括号与右括号的总数
     * @param ret   保存结果字符串的容器
     * @param s     当前已经生成的字符串
     */
    private void dfs(int left, int right, int n, List<String> ret, String s) {
        if (left == n && right == n) {
            ret.add(s);
            return;
        }
        if (left < n) {
            dfs(left + 1, right, n, ret, s + "(");
        }
        if (right < left) {
            dfs(left, right + 1, n, ret, s + ")");
        }
    }

    static class SolutionBfs {
        static class Node {
            Node(String val, int leftRemains, int rightRemains) {
                this.val = val;
                this.leftRemains = leftRemains;
                this.rightRemains = rightRemains;
            }

            String val;
            int leftRemains;
            int rightRemains;
        }

        public List<String> generateParenthesis(int n) {
            if (n < 1) return Collections.emptyList();

            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node("", n, n));
            List<String> ret = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.leftRemains == 0 && node.rightRemains == 0) {
                    ret.add(node.val);
                    continue;
                }

                if (node.leftRemains > 0)
                    queue.offer(new Node(node.val + "(", node.leftRemains - 1, node.rightRemains));
                if (node.rightRemains > node.leftRemains)
                    queue.offer(new Node(node.val + ")", node.leftRemains, node.rightRemains - 1));
            }
            return ret;
        }
    }

    static class SolutionDfsIterable {
        static class Node {
            Node(String val, int leftRemains, int rightRemains) {
                this.val = val;
                this.leftRemains = leftRemains;
                this.rightRemains = rightRemains;
            }

            String val;
            int leftRemains;
            int rightRemains;
        }

        public List<String> generateParenthesis(int n) {
            if (n < 1) return Collections.emptyList();

            Deque<Node> stack = new LinkedList<>();
            List<String> ret = new LinkedList<>();

            stack.offerLast(new Node("", n, n));
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();

                if (node.leftRemains == 0 && node.rightRemains == 0) {
                    ret.add(node.val);
                    continue;
                }
                //根右左，😄
                if (node.leftRemains > 0)
                    stack.offerLast(new Node(node.val + "(", node.leftRemains - 1, node.rightRemains));
                if (node.rightRemains > node.leftRemains)
                    stack.offerLast(new Node(node.val + ")", node.leftRemains, node.rightRemains - 1));
            }

            return ret;
        }
    }
}