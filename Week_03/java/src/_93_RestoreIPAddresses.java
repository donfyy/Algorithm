import java.util.ArrayList;
import java.util.List;

/**
 * 第一遍：2020/08/09周日 ✅
 * 第二遍：2020/08/09周日
 * 第三遍：2020/07/18周六
 * 第三遍：2020/07/08周四
 * 自己做出来了，但是是枚举的三种情况。。。
 */
class _93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        dfs(s, 0, 4, new StringBuilder(), ret);
        return ret;
    }

    void dfs(String s, int l, int count, StringBuilder sb, List<String> ret) {
        if (l == s.length() && count == 0) {
            sb.deleteCharAt(sb.length() - 1);
            ret.add(sb.toString());
            sb.append('.');
            return;
        }

        if (count == 0) {
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (l + i > s.length() || (i > 1 && s.charAt(l) == '0')
                    || (i == 3 && (s.charAt(l) - '0') * 100 + (s.charAt(l + 1) - '0') * 10 + (s.charAt(l + 2) - '0') > 0xFF)) {
                break;
            }

            sb.append(s, l, l + i).append('.');
            dfs(s, l + i, count - 1, sb, ret);
            sb.delete(sb.length() - i - 1, sb.length());
        }
    }
}