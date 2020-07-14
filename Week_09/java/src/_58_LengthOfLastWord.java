/**
 * 第一遍：2020/07/14周二 ✅
 * 第二遍：2020/07/15周三 ✅
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}