import java.util.*;

/**
 * 第一遍：2020/07/16周四 ✅
 * 第二遍：2020/07/15周三
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 * 我的思路就是判断滑动窗口中的每一个字符出现的次数是否相同。题解的解法没看懂，花了两个小时。卧槽。
 */
class _438_FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || p.length() > s.length()) return Collections.emptyList();
        int[] table = new int[26];
        for (int i = 0; i < p.length(); i++) {
            table[p.charAt(i) - 'a']++;
            table[s.charAt(i) - 'a']--;
        }
        List<Integer> ret = new ArrayList<>(s.length() - p.length() + 1);
        if (isAnagram(table)) ret.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            table[s.charAt(i - p.length()) - 'a']++;
            table[s.charAt(i) - 'a']--;
            if (isAnagram(table)) ret.add(i - p.length() + 1);
        }
        return ret;
    }

    boolean isAnagram(int[] table) {
        for (int v : table) {
            if (v != 0) return false;
        }
        return true;
    }

    class S1 {
        //看不懂的解法一。。。
        public List<Integer> findAnagrams(String s, String t) {
            List<Integer> ret = new ArrayList<>();
            if (t.length() > s.length()) return ret;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int counter = map.size();
            int begin = 0, end = 0;
            while (end < s.length()) {
                char c = s.charAt(end);
                if (map.containsKey(c)) {
                    int count = map.get(c) - 1;
                    map.put(c, count);
                    if (count == 0) counter--;
                }
                end++;
                while (counter == 0) {
                    char temp = s.charAt(begin);
                    if (map.containsKey(temp)) {
                        int count = map.get(temp) + 1;
                        map.put(temp, count);
                        if (count > 0) counter++;
                    }
                    if (end - begin == t.length()) ret.add(begin);
                    begin++;
                }
            }
            return ret;
        }
    }

    class S2 {
        //看不懂的解法2
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ret = new ArrayList<>();
            if (p.length() > s.length()) return ret;
            int[] table = new int[26];
            for (int i = 0; i < p.length(); i++) {
                table[p.charAt(i) - 'a']++;
            }
            int left = 0, right = 0, count = p.length();
            while (right < s.length()) {
                if (table[s.charAt(right++)]-- > 0) count--;
                if (count == 0) ret.add(left);
                if (right - left == p.length() && table[s.charAt(left++)]++ >= 0) count++;
            }
            return ret;
        }
    }
}