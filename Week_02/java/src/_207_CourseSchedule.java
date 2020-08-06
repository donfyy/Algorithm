import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 第一遍：2020/08/04周二 ✅
 * 第二遍：2020/08/04周二
 * 第三遍：2020/07/18周六
 * 第三遍：2020/07/08周四
 */
class _207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        int[] indegrees = new int[numCourses];
        for (int[] pair : prerequisites) {
            indegrees[pair[0]]++;
            edges.get(pair[1]).add(pair[0]);
        }

        int n = numCourses;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : edges.get(u)) {
                if (--indegrees[v] == 0) {
                    queue.offer(v);
                }
            }
            n--;
        }
        return n == 0;
    }

    class SolutionDfs {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> edges = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }
            int[] visited = new int[numCourses];
            for (int[] pair : prerequisites) {
                edges.get(pair[1]).add(pair[0]);
            }

            for (int i = 0; i < numCourses; i++) {
                if (!dfs(i, edges, visited)) {
                    return false;
                }
            }
            return true;
        }

        // true 表示从顶点u出发的图是DAG， false 表示从顶点u出发的图不是DAG，也就是找到了环。
        boolean dfs(int u, List<List<Integer>> edges, int[] visited) {
            if (visited[u] == 1) return false;
            if (visited[u] == 2) return true;
            visited[u] = 1;
            for (int v : edges.get(u)) {
                if (!dfs(v, edges, visited)) return false;
            }
            visited[u] = 2;
            return true;
        }
    }
}