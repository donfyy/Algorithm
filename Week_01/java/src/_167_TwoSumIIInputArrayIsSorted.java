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
            int m = (l + r) >>> 1;
            if (numbers[l] > target - numbers[m]) {
                r = m - 1;
            } else if (numbers[r] < target - numbers[m]) {
                l = m + 1;
            } else if (numbers[l] < target - numbers[r]) {
                l++;
            } else if (numbers[l] > target - numbers[r]) {
                r--;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println((Integer.MAX_VALUE) + ":" + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println((Integer.MAX_VALUE + Integer.MAX_VALUE) +
                "\n:" + Integer.toBinaryString(Integer.MAX_VALUE + Integer.MAX_VALUE) +
                "\n:" + Long.toBinaryString((long)Integer.MAX_VALUE + (long)Integer.MAX_VALUE));
        System.out.println((Integer.MAX_VALUE + Integer.MAX_VALUE) >>> 1);
        System.out.println((Integer.MAX_VALUE + Integer.MAX_VALUE) >> 1);
    }
}