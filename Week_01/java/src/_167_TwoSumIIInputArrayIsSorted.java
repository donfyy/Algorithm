/**
 * 第一遍：2020/07/20周一 ✅
 * 第二遍：2020/05/22周五
 * 第三遍：2020/05/25周一
 * 第四遍：2020/06/08周一
 */
class _167_TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return new int[]{-1, -1};
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int vl = numbers[l];
            int diff = target - numbers[r];
            if (vl == diff) return new int[]{l + 1, r + 1};
            if (vl > diff) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{-1, -1};
    }
}