/**
 * 第一遍：2020/07/15周三 ✅
 * 第二遍：2020/07/15周三
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _557_ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] array = s.toCharArray();
        int left = 0, right = 0, length = array.length;
        while (left < length) {
            while (right < length && array[right] != ' ') right++;
            reverse(array, left, right - 1);
            left = ++right;
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