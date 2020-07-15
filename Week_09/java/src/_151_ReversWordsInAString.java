/**
 * 第一遍：2020/07/15周三 ✅
 * 第二遍：2020/07/15周三
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 * 大概花了一个小时处理空格问题，一开始还想错了。
 * c++原地操作数组的解法
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/c-yuan-di-cao-zuo-fen-xiang-cbiao-zhun-ku-xia-zai-/
 */
class _151_ReversWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] array = s.toCharArray();
        int end = -1;//指向已拷贝数组的最后一个元素,应用了一把partition函数的写法，爽
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ' || (end != -1 && array[end] != ' ')) {
                if (i != ++end) {
                    array[end] = array[i];
                }
            }
        }
        if (end != -1 && array[end] == ' ') end--;

        reverse(array, 0, end);
        int l = 0, r = 0;
        while (l <= end) {
            while (r <= end && array[r] != ' ') r++;
            reverse(array, l, r - 1);
            l = ++r;
        }

        return String.valueOf(array, 0, end + 1);
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