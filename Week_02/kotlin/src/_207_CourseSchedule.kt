import java.util.*
import kotlin.collections.ArrayList

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val edges = Array(numCourses) { ArrayList<Int>() }
    val inDegrees = IntArray(numCourses)
    for ((v, u) in prerequisites) {
        inDegrees[v]++
        edges[u].add(v)
    }

    val queue = LinkedList<Int>()
    for (u in 0 until numCourses) {
        u.takeIf { inDegrees[it] == 0 }?.let { queue.offer(it) }
    }

    var n = numCourses
    while (queue.isNotEmpty()) {
        val u = queue.poll()
        for (v in edges[u]) {
            v.takeIf { --inDegrees[v] == 0 }?.let { queue.offer(it) }
        }
        n--
    }
    return n == 0
}

class _207_dfs {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        fun dfs(u: Int, edges: Array<ArrayList<Int>>, visited: IntArray): Boolean {
            return when(visited[u]) {
                2 -> true
                1 -> false
                else -> {
                    visited[u] = 1
                    for (v in edges[u]) {
                        if (!dfs(v, edges, visited)) {
                            return false
                        }
                    }
                    visited[u] = 2
                    true
                }
            }
        }
        val edges = Array(numCourses) { ArrayList<Int>() }
        for ((v, u) in prerequisites) {
            edges[u].add(v)
        }
        val visited = IntArray(numCourses)
        for (u in 0 until numCourses) {
            if (!dfs(u, edges, visited)) {
                return false
            }
        }
        return true
    }
}