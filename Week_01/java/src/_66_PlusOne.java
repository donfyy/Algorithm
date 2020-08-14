/**
 * 第一遍：2020/08/14周五 ✅
 * 第二遍：2020/05/22周五
 * 第三遍：2020/05/25周一
 * 第四遍：2020/08/13周四
 * 第五遍：2020/08/14周五
 */
class _66_PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}