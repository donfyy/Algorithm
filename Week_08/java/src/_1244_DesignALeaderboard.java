import java.util.HashMap;
import java.util.PriorityQueue;
/**
 * 第一遍：2020/07/12周日 ✅
 * 第二遍：2020/07/08周四
 * 第二遍：2020/07/06周一
 * 第二遍：2020/07/03周五
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _1244_DesignALeaderboard {
    HashMap<Integer,Integer> playerMap = new HashMap<>();
    public _1244_DesignALeaderboard() {

    }
    
    public void addScore(int playerId, int score) {
        Integer s = playerMap.get(playerId);
        if (s == null) {
            s = score;
        } else {
            s += score;
        }
        playerMap.put(playerId, s);
    }
    
    public int top(int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int i = 0;
        for (int player : playerMap.values()) {
            if (queue.size() < K) {
                queue.offer(player);
            } else {
                int minScore = queue.peek();
                if (player > minScore) {
                    queue.poll();
                    queue.offer(player);
                }
            }
        }

        int sum = 0;
        for (int score : queue) {
            sum += score;
        }
        return sum;
    }
    
    public void reset(int playerId) {
        playerMap.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */