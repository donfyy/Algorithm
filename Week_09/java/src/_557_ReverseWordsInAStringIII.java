/**
 * 第一遍：2020/07/15周三 ✅
 * 第二遍：2020/07/16周四 ✅
 * 第三遍：2020/08/30周日 ✅
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _557_ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) return s;
        char[] arr = s.toCharArray();
        int i = 0, j = 0, n = arr.length;
        while (i < n) {
            while (j < n && arr[j] != ' ') j++;
            int next = j-- + 1;
            while (i < j) {
                char c = arr[i];
                arr[i++] = arr[j];
                arr[j--] = c;
            }
            i = next;
            j = next;
        }
        return new String(arr);
    }
}