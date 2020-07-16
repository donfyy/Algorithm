/**
 * 第一遍：2020/07/16周四 ✅
 * 第二遍：2020/07/16周四
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _917_ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        if (S == null) return S;
        char[] array = S.toCharArray();
        int l = 0, r = array.length - 1;
        while (l < r) {
            while (l < r && !Character.isLetter(array[l])) l++;
            while (l < r && !Character.isLetter(array[r])) r--;
            char temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
        return String.valueOf(array);
    }
}