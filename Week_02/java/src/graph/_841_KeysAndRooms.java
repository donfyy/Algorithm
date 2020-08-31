package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 第一遍：2020/08/31周一 ✅
 * 第二遍：2020/05/31周日
 * 第三遍：2020/06/06周六
 * 第四遍：2020/06/13周六
 */
class _841_KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.isEmpty()) return false;
        final int n = rooms.size();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int count = 1;
        while (!stack.isEmpty()) {
            for (int v : rooms.get(stack.pop())) {
                if (!visited[v]) {
                    visited[v] = true;
                    stack.push(v);
                    if (++count == n) return true;
                }
            }
        }
        return count == n;
    }

    class SolutionBfs {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if (rooms == null || rooms.isEmpty()) return false;
            final int n = rooms.size();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            boolean[] visited = new boolean[n];
            visited[0] = true;
            int count = 1;
            while (!queue.isEmpty()) {
                for (int v : rooms.get(queue.poll())) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.offer(v);
                        if (++count == n) return true;
                    }
                }
            }
            return count == n;
        }
    }
}