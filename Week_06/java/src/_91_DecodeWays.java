/**
 * 第一遍：2020/07/25周六 ✅
 * 第二遍：2020/07/26周日 ✅
 * 第三遍：2020/07/27周一 ✅
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 * 一定要看国外的高票回答，国内好多题解状态定义的不够清晰，水平还是差一点。
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
        for (int i = 2; i <= length; i++) {
            int first = s.charAt(i - 1) - '0';
            int second = (s.charAt(i - 2) - '0') * 10 + first;
            int dp = 0;
            if (first >= 1 && first <= 9) {
                dp = left;
            }
            if (second >= 10 && second <= 26) {
                dp += leftPreceding;
            }
            leftPreceding = left;
            left = dp;
        }
        return left;
    }
}