/**
 * 第一遍：2020/06/26周五 ✅
 * 第二遍：2020/05/22周五
 * 第二遍：2020/06/01周一
 * 第三遍：2020/05/28周四
 * 第四遍：2020/06/11周四
 */
class _746_MinCostClimbingStairs {
    //一开始理解错了，以为到达cost.length - 1就是楼顶了
    public int minCostClimbingStairs(int[] cost) {
        //f[i] = min(f[i - 1], f[i - 2]) + cost[i]
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }

        int dpi_1 = cost[1];
        int dpi_2 = cost[0];
        for (int i = 2; i < cost.length; i++) {
            int dpi = Math.min(dpi_1, dpi_2) + cost[i];
            dpi_2 = dpi_1;
            dpi_1 = dpi;
        }
        return Math.min(dpi_1, dpi_2);
    }
}