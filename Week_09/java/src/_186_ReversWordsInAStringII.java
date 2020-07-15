/**
 * 第一遍：2020/07/15周三 ✅
 * 第二遍：2020/07/15周三
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _186_ReversWordsInAStringII {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) return;
        int length = s.length;
        reverse(s, 0, length - 1);
        int l = 0, r = 0;
        while (l < length) {
            while (r < length && s[r] != ' ') r++;
            reverse(s, l, r - 1);
            l = ++r;
        }
    }

    void reverse(char[] array, int l, int r) {
        while (l < r) {
            char temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
    }
}