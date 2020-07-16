/**
 * 第一遍：2020/07/15周三 ✅
 * 第二遍：2020/07/16周三 ✅
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _541_ReverseStringII {
    public String reverseStr(String s, int k) {
        if (s == null || k < 1) return s;
        int length = s.length();
        char[] array = s.toCharArray();
        for (int i = 0; i < length; i += k << 1) {
            reverse(array, i, Math.min(i + k - 1, length - 1));
        }
        return String.valueOf(array);
    }

    void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}