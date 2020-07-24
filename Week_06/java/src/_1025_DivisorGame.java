/**
 * 第一遍：2020/07/24周五 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 * 没有独立做出来，还多花了1个多小时，严格按照无毒神掌，只给15分钟的思考时间。
 * 这道题目给我的启示有两点 1要学会举几个例子看一下 2千万不能死磕
 */
class _1025_DivisorGame {
    public boolean divisorGame(int N) {
        //奇数先手必败，偶数先手必胜
        // return (N & 1) == 0;
        //f(i)表示当前数字为i时Alice先手是必胜还是必败
        //只要Alice在(0, i)之间找到一个让bob必败的数j就可以了
        //f(1) = false; f(2) = true     
        //i in [3, N]
        if (N < 2) return false;
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

}