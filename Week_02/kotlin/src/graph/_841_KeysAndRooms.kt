package graph

import java.util.*

class _841_Dfs {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val n = rooms.size
        val visited = BooleanArray(n)
        var count = 0
        fun dfs(u: Int) {
            if (visited[u]) return
            visited[u] = true;
            count++
            for (v in rooms[u]) {
                dfs(v);
            }
        }
        dfs(0)
        return count == n
    }
}
class _841_Bfs {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val n = rooms.size
        val visited = BooleanArray(n).apply { this[0] = true }
        var count = 1
        val queue = LinkedList<Int>().apply { offer(0) }
        while (queue.isNotEmpty()) {
            val u = queue.poll()
            for (v in rooms[u]) {
                if (!visited[v]) {
                    visited[v] = true
                    count++
                    queue.offer(v)
                }
            }
        }
        return count == n
    }
}