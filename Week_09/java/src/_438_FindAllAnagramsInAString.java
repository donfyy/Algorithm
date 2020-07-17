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

    static class S1 {
        public List<Integer> findAnagrams11(String s, String p) {
            if (s == null || p == null || p.length() > s.length()) return Collections.emptyList();
            Map<Character, Integer> map = new HashMap<>();
            int length = p.length();
            for (int i = 0; i < length; i++) {
                map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
            }
            int counter = map.size();
            int left = 0, right = 0;
            List<Integer> ret = new ArrayList<>();
            while (right < s.length()) {
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) counter--;
                }
                right++;
                while (counter == 0) {
                    char l = s.charAt(left);
                    if (map.containsKey(l)) {
                        if (map.get(l) == 0) counter++;
                        map.put(l, map.get(l) + 1);
                    }
                    if (right - left == length) ret.add(left);
                    left++;
                }
            }
            return ret;
        }

        //看不懂的解法一。。。昨天状态不好，今天很容易就看懂了
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

    public static void main(String[] args) {
        System.out.println(new S1().findAnagrams11("cbaebabacd", "abc"));
        System.out.println(new S1().findAnagrams("baa", "aba"));
//        System.out.println(new S2().findAnagrams("baa", "aba"));
        System.out.println(new S1().findAnagrams("bba", "aba"));
//        System.out.println(new S2().findAnagrams("bba", "aba"));
        System.out.println(new S2().findAnagrams("cbaebabacd", "abc"));
    }

    static class S2 {

        //看不懂的解法2
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ret = new ArrayList<>();
            if (p.length() > s.length()) return ret;
            int[] table = new int[256];
            for (int i = 0; i < p.length(); i++) {
                table[p.charAt(i)]++;
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