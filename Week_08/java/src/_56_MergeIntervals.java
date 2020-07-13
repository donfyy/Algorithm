import java.util.Arrays;
import java.util.Comparator;
/**
 * 第一遍：2020/07/12周日 ✅
 * 第二遍：2020/07/13周一 ✅
 * 第二遍：2020/07/06周一
 * 第二遍：2020/07/03周五
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        int length = intervals.length;
        int[][] ret = new int[length][2];
        ret[0] = intervals[0];
        int j = 0;

        for (int i = 1; i < length; i++) {
            int[] current = intervals[i];
            if (current[0] > ret[j][1]) {
                ret[++j] = current;
            } else {
                ret[j][1] = Math.max(ret[j][1], current[1]);
            }
        }
        return Arrays.copyOf(ret, j + 1);
    }
}