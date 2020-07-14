import java.util.Arrays;
import java.util.HashMap;

/**
 * 第一遍：2020/07/13周一 ✅
 * 第二遍：2020/07/14周二 ✅
 * 第三遍：2020/07/13周一
 * 第二遍：2020/07/06周一
 * 第二遍：2020/07/03周五
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 * 哈希表 + 排序双指针
 * 哈希表
 * 外部排序+双指针
 * 如果nums1比nums2小很多，则使用哈希表方式更优，用的空间少，只需要使用线性的时间扫描nums2即可
 * 如果nums2的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，那么使用哈希表是一种比较好的办法。
 * 如果nums1和nums2都在磁盘上，并且都比较大，那么可以采用外部排序的方式，使用双指针获取交集。
 */
class _350_IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums2.length == 0 || nums1.length == 0) return new int[0];
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int value : nums1) {
            int count = map.getOrDefault(value, 0);
            map.put(value, count + 1);
        }

        int[] ret = new int[nums1.length];
        int j = 0;
        for (int value : nums2) {
            int count = map.getOrDefault(value, 0);
            if (count > 0) {
                ret[j++] = value;
                map.put(value, count - 1);
            }
        }
        return Arrays.copyOf(ret, j);
    }

    public int[] intersectUsingSort(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums2.length == 0 || nums1.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] ret = new int[Math.min(length1, length2)];
        int k = 0;
        int i = 0, j = 0;
        while (i < length1 && j < length2) {
            int a = nums1[i];
            int b = nums2[j];
            if (a == b) {
                ret[k++] = a;
                i++;
                j++;
            } else if (a < b) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOf(ret, k);
    }
}