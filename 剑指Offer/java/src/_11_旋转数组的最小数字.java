/**
 * 第一遍：2020/07/22周三 ✅
 * 第二遍：2020/06/21周日
 * 第二遍：2020/06/12周二
 * 第三遍：2020/06/18周四
 * 第四遍：2020/07/02周四
 */
class _11_旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (numbers[m] > numbers[r]) {
                l = m + 1;
            } else if (numbers[m] == numbers[r] && numbers[m] == numbers[l]) {
                r--;
            } else {
                r = m;
            }
        }
        return numbers[l];
    }
}