/**
 * 第一遍：2020/07/26周六 ✅
 * 第一遍：2020/07/27周日 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 */
class _91_DecodeWays {
    public int numDecodings(String s) {
        //f(i)前i个字符解码方法的总数
        //if (s[i-1] == '0') 
        //      if (s[i - 2] == '1' || s[i - 2] == '2') f(i) = f(i - 2) else return 0
        //else if (s[i - 2] == '1' || (s[i - 2] == '2' && s[i - 1] <= '6') 
        //      f(i) = f(i - 1) + f(i - 2)
        //else f(i) = f(i - 1)
        //f(0) = 0 f(1) = 1 i in [2, s.length()]
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int length = s.length();
        int leftPreceding = 1;
        int left = 1;
        int dp = 1;
        for (int i = 2; i <= length; i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dp = leftPreceding;
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                    dp = left + leftPreceding;
                } else {
                    dp = left;
                }
            }
            leftPreceding = left;
            left = dp;
        }
        return dp;
    }
}