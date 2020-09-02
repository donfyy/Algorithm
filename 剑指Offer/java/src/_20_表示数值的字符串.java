/**
 * 第一遍：2020/09/02周三 ✅
 * 第二遍：2020/06/21周日
 * 第二遍：2020/06/12周二
 * 第三遍：2020/06/18周四
 * 第四遍：2020/07/02周四
 */
public class _20_表示数值的字符串 {
    class Solution {
        int i;

        public boolean isNumber(String s) {
            if (s == null || s.isEmpty()) return false;
            while (i < s.length() && s.charAt(i) == ' ') i++;
            boolean numeric = scanInteger(s);
            if (i < s.length() && s.charAt(i) == '.') {
                i++;
                numeric = scanUnsignedInteger(s) || numeric;
            }
            if (i < s.length() && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
                i++;
                numeric = numeric && scanInteger(s);
            }
            while (i < s.length() && s.charAt(i) == ' ') i++;
            return numeric && i == s.length();
        }

        boolean scanInteger(String s) {
            if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            return scanUnsignedInteger(s);
        }

        boolean scanUnsignedInteger(String s) {
            int iBefore = i;
            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                i++;
            }
            return i > iBefore;
        }

    }
}
