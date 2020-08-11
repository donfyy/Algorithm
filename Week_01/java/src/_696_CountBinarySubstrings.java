/**
 * 第一遍：2020/08/10周一 ✅
 * 第二遍：2020/08/10周二 ✅
 * 第三遍：2020/07/18周六
 * 第三遍：2020/07/08周四
 * 简单题没想出来啊，菜。。
 */
class _696_CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s == null) return 0;
        int ret = 0;
        int pre = 0;
        int curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                ret += Math.min(curr, pre);
                pre = curr;
                curr = 1;
            }
        }
        return ret + Math.min(curr, pre);
    }
}