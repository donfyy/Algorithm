import java.util.ArrayList;
import java.util.List;

/**
 * 第一遍：2020/08/24周二 ✅
 * 第二遍：2020/08/25周三 ✅
 * 第三遍：2020/06/06周六
 * 第四遍：2020/06/13周六
 * todo: 使用二进制位的解法
 */
class _491_IncreasingSubsequences {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ret;
    }

    void dfs(int i, int last, int[] nums) {
        if (i == nums.length) {
            if (path.size() >= 2) {
                ret.add(new ArrayList<>(path));
            }
            return;
        }
        if (nums[i] >= last) {
            path.add(nums[i]);
            dfs(i + 1, nums[i], nums);
            path.remove(path.size() - 1);
        }
        if (nums[i] != last) {
            dfs(i + 1, last, nums);
        }
    }
}