import java.util.Arrays;
import java.util.HashMap;
/**
 * 第一遍：2020/07/13周一 ✅
 * 第二遍：2020/07/08周四
 * 第三遍：2020/07/13周一
 * 第二遍：2020/07/06周一
 * 第二遍：2020/07/03周五
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 * 哈希表 + 排序双指针
 * 哈希表
 * 外部排序+双指针
 */
class _350_IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];

        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int value : nums1) {
            int count = bucket.getOrDefault(value, 0);
            count++;
            bucket.put(value, count);
        }
        int length = nums1.length > nums2.length? nums2.length : nums1.length;
        int[] ret = new int[length];
        int j = 0;

        for (int value : nums2) {
            int count = bucket.getOrDefault(value, 0);
            if (count > 0) {
                ret[j++] = value;
                bucket.put(value, count - 1);
            }
        }
        return Arrays.copyOf(ret, j);
    }
}