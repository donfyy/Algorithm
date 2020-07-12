/**
 * 第一遍：2020/07/12周日 ✅
 * 第二遍：2020/07/08周四
 * 第二遍：2020/07/06周一
 * 第二遍：2020/07/03周五
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 * 第一次读题一点想法都没有。。。。。。。。啊
 */
class _1122_RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxValue = arr1[0];
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] > maxValue) {
                maxValue = arr1[i];
            }
        }
        int[] bucket = new int[maxValue + 1];
        for (int value : arr1) {
            bucket[value]++;
        }

        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            int value = arr2[i];
            while (bucket[value] > 0) {
                arr1[j++] = value;
                bucket[value]--;
            }
        }

        for (int i = 0; i <= maxValue; i++) {
            while (bucket[i] > 0) {
                arr1[j++] = i;
                bucket[i]--;
            }
        }
        return arr1;
    }
}