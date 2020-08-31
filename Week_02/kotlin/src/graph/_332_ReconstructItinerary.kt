package graph

import java.util.*
import kotlin.collections.HashMap

class _332_Iterative {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val edges = HashMap<String, PriorityQueue<String>>()
        tickets.forEach { (u, v) ->
            edges.computeIfAbsent(u) { PriorityQueue() }.offer(v)
        }
        val stack = LinkedList<String>().apply { offer("JFK") }
        val path = LinkedList<String>()
        while (stack.isNotEmpty()) {
            var edge = edges[stack.peek()]
            while (edge != null && edge.isNotEmpty()) {
                stack.push(edge.poll())
                edge = edges[stack.peek()]
            }
            path.offerFirst(stack.pop())
        }
        return path
    }
}

class _332_Dfs_ {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        if (tickets.isEmpty()) return emptyList()
        val edges = HashMap<String, PriorityQueue<String>>()
        for (ticket in tickets) {
            edges.computeIfAbsent(ticket[0]) { PriorityQueue() }.offer(ticket[1])
        }
        val path = LinkedList<String>()
        fun dfs(u: String) {
            val edge = edges[u]
            while (edge != null && edge.isNotEmpty()) {
                dfs(edge.poll())
            }
            path.offerFirst(u)
        }
        dfs("JFK")
        return path
    }
}