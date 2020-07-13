import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

//["Leaderboard","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","addScore","top","reset","reset","addScore","reset"]
//[[],[1,13],[2,93],[3,84],[4,6],[5,89],[6,31],[7,7],[8,1],[9,98],[10,42],[5],[1],[2],[3,76],[4,68],[1],[3],[4],[2,70],[2]]
fun main() {
    val board = Leaderboard()
    board.addScore(1, 1)
    board.addScore(1, 2)
    println(board.top(1))
    /*  board.addScore(1, 13)
      board.addScore(2, 93)
      board.addScore(3,84)
      board.addScore(4,6)
      board.addScore(5,89)
      board.addScore(6,31)
      board.addScore(7,7)
      board.addScore(8,1)
      board.addScore(9,98)
      board.addScore(10,42)
      println(board.top(5))
      board.reset(1)
      board.reset(2)
      board.addScore(3,76)
      board.addScore(4,68)
      println(board.top(1))*/
}
//使用了TreeMap和HashMap，HashSet
class Leaderboard() {
    val playerMap = HashMap<Int, Int>()
    val scoreMap = TreeMap<Int, HashSet<Int>>() { l, r -> r - l }
    fun addScore(playerId: Int, score: Int) {
        var s = playerMap[playerId]
        if (s == null) {
            playerMap[playerId] = score
            scoreMap.computeIfAbsent(score) { HashSet() }.add(playerId)
        } else {
            removeScoreMap(s, playerId)

            s += score
            playerMap[playerId] = s
            val set = scoreMap.computeIfAbsent(s) { HashSet() }
            set.add(playerId)
        }
    }

    private fun removeScoreMap(s: Int?, playerId: Int) {
        val playerSet = scoreMap[s]
        playerSet?.let {
            it.remove(playerId)
            if (it.isEmpty()) {
                scoreMap.remove(s)
            }
        }
    }

    fun top(k: Int): Int {
        var count = k
        var ret = 0
        for (entry in scoreMap.entries) {
            if (entry.value.size <= count) {
                ret += entry.key * entry.value.size
                count -= entry.value.size
            } else {
                ret += entry.key * count
                break
            }
        }
        return ret
    }

    fun reset(playerId: Int) {
        val s = playerMap[playerId]
        removeScoreMap(s, playerId)
        playerMap.remove(playerId)
    }

}
