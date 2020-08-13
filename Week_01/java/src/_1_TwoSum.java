import java.util.HashMap;
import java.util.Map;

/**
 * 第一遍：2020/05/21周四 ✅
 * 第二遍：2020/05/22周五 ✅
 * 第三遍：2020/05/25周一 ✅
 * 第四遍：2020/08/13周四 ✅
 * 两数之和与回文对这道题目有些相似的地方。暴力法都是枚举两个元素，然后判断两个元素是否满足条件。
 * 加速的方法则是根据遍历到的元素a去查找符合条件的元素b，在查找b时使用一些数据结构进行加速如trie树和哈希表
 */
class _1_TwoSum {

    /**
     * 将目标数字作为键(第一次见到这种解法，居然有些懵逼😄）
     * 将当前数字视为当前数字。。。哈哈
     */
    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(nums[i]);
            if (j != null) {

                return new int[]{i, j};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }

    /**
     * 将自己作为键
     * 将当前数字视为目标数字
     */
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer targetIndex = map.get(target - nums[i]);
            if (targetIndex != null) {
                return new int[]{i, targetIndex};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}