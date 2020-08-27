package graph;

import java.util.*;

/**
 * 第一遍：2020/08/27周四 ✅
 * 第二遍：2020/08/25周三
 * 第三遍：2020/06/06周六
 * 第四遍：2020/06/13周六
 * <p>
 * 参考官方题解
 */
class _332_ReconstructItinerary {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> itinerary = new LinkedList<>();

    // 时间O(mlogm) 空间O(m)
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String u = ticket.get(0);
            String v = ticket.get(1);
            PriorityQueue<String> heap = map.computeIfAbsent(u, k -> new PriorityQueue<>());
            heap.offer(v);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String u) {
        PriorityQueue<String> heap = map.get(u);
        while (heap != null && !heap.isEmpty()) {
            dfs(heap.poll());
        }
        itinerary.add(u);
    }

    class SolutionIterative {
        public List<String> findItinerary(List<List<String>> tickets) {
            Map<String, PriorityQueue<String>> map = new HashMap<>();
            for (List<String> ticket : tickets) {
                map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
            }
            LinkedList<String> ret = new LinkedList<>();
            Deque<String> stack = new LinkedList<>();
            stack.push("JFK");
            while (!stack.isEmpty()) {
                PriorityQueue<String> heap = map.get(stack.peek());
                while (heap != null && !heap.isEmpty()) {
                    String v = heap.poll();
                    stack.push(v);
                    heap = map.get(v);
                }
                ret.add(0, stack.pop());
            }
            return ret;
        }
    }
}