/**
 * 第一遍：2020/07/14周二 ✅
 * 第二遍：2020/07/15周三 ✅
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _771_JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0) return 0;
        boolean[] jewels = new boolean[100];
        for (int i = 0; i < J.length(); i++) {
            jewels[J.charAt(i) - 'A'] = true;
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (jewels[S.charAt(i) - 'A']) {
                count++;
            }
        }
        return count;
    }
}