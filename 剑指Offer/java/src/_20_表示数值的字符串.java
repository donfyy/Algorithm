/**
 * 第一遍：2020/09/02周三 ✅
 * 第二遍：2020/09/03周四 ✅
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

    class Solution2 {
        public boolean isNumber(String s) {
            if (s == null || s.isEmpty()) return false;
            char[] arr = s.trim().toCharArray();
            boolean isNumber = false, hasDot = false, hasExponent = false;
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                if (c >= '0' && c <= '9') {
                    isNumber = true;
                } else if (c == '.') {
                    if (hasDot || hasExponent) return false;
                    hasDot = true;
                } else if (c == 'e' || c == 'E') {
                    if (!isNumber || hasExponent) return false;
                    hasExponent = true;
                    isNumber = false;
                } else if (c == '-' || c == '+') {
                    if (i != 0 && arr[i - 1] != 'e' && arr[i - 1] != 'E') return false;
                } else {
                    return false;
                }
            }
            return isNumber;
        }
    }
}
