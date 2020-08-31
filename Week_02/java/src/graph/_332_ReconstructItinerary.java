package graph;

import java.util.*;

/**
 * 第一遍：2020/08/27周四 ✅
 * 第二遍：2020/08/27周五 ✅
 * 第三遍：2020/08/27周日 ✅
 * 第四遍：2020/08/31周一 ✅
 * <p>
 * 参考官方题解
 */
class _332_ReconstructItinerary {
    class SolutionDfsRecursive {
        Map<String, PriorityQueue<String>> edges = new HashMap<>();
        LinkedList<String> path = new LinkedList<>();

        // 时间O(mlogm) 空间O(m)
        public List<String> findItinerary(List<List<String>> tickets) {
            if (tickets == null) return path;
            for (List<String> ticket : tickets) {
                edges.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
            }
            dfs("JFK");
            return path;
        }

        void dfs(String u) {
            PriorityQueue<String> edge = edges.get(u);
            while (edge != null && !edge.isEmpty()) {
                dfs(edge.poll());
            }
            path.addFirst(u);
        }
    }

    class SolutionDfsIterative {
        public List<String> findItinerary(List<List<String>> tickets) {
            if (tickets == null) return Collections.emptyList();
            Map<String, PriorityQueue<String>> edges = new HashMap<>();
            for (List<String> ticket : tickets) {
                edges.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
            }
            LinkedList<String> path = new LinkedList<>();
            LinkedList<String> stack = new LinkedList<>();
            stack.push("JFK");
            while (!stack.isEmpty()) {
                PriorityQueue<String> edge = edges.get(stack.peek());
                while (edge != null && !edge.isEmpty()) {
                    String v = edge.poll();
                    stack.push(v);
                    edge = edges.get(v);
                }
                path.addFirst(stack.pop());
            }
            return path;
        }
    }
}