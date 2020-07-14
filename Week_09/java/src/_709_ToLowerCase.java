/**
 * 第一遍：2020/07/14周二 ✅
 * 第二遍：2020/07/08周三
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _709_ToLowerCase {
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) return str;
        char[] ret = str.toCharArray();
        final int offset = 'a' - 'A';
        for (int i = 0; i < ret.length; i++) {
            char c = ret[i];
            if (c >= 'A' && c <= 'Z') {
                ret[i] += offset;
            }
        }
        return String.valueOf(ret);
    }
}