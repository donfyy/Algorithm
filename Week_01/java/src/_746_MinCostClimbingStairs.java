/**
 * 第一遍：2020/06/26周五 ✅
 * 第二遍：2020/08/13周四 ✅
 * 第二遍：2020/06/01周一
 * 第三遍：2020/05/28周四
 * 第四遍：2020/06/11周四
 */
class _746_MinCostClimbingStairs {
    //一开始理解错了，以为到达cost.length - 1就是楼顶了
    public int minCostClimbingStairs(int[] cost) {
        //f[i] = min(f[i - 1], f[i - 2]) + cost[i]
        if (cost == null) {
            return 0;
        }
        int p = 0;
        int q = 0;
        for (int v : cost) {
            int r = Math.min(p, q) + v;
            p = q;
            q = r;
        }
        return Math.min(p, q);
    }
}