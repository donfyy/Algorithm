package mergetwosortedlists;

/**
 * 第一遍：2020/08/15周日 ✅
 * 第二遍：2020/08/15周日
 * 第三遍：2020/05/25周一
 * 第四遍：2020/08/13周四
 * 第五遍：2020/08/14周五
 * 从后往前归并，注意逆向思维的应用。
 */
class _88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = n + m - 1;
        while (j >= 0) {
            while (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            }
            nums1[k--] = nums2[j--];
        }
    }
}