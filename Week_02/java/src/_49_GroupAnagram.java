import java.util.*;

public class _49_GroupAnagram {
    /**
     * 思路：以排序后的字符串作为哈希表的键
     * 时间：O(nklogk) n:字符串数组的长度，k:最长字符串的长度
     * 空间：O(nk)
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] key = s.toCharArray();
            Arrays.sort(key);

            List<String> list = map.computeIfAbsent(Arrays.toString(key), k -> new ArrayList<>());
            list.add(s);
        }

        return new ArrayList<>(map.values());

    }

    /**
     * 思路：以计数字符串作为哈希表的键。计数字符串：每个字符从左到右依次表示字符'a','b','c'...的出现次数
     * 时间：O(nk) n:字符串数组的长度，k:最长字符串的长度
     * 空间：O(nk)
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap<>();

        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }

            List<String> list = map.computeIfAbsent(Arrays.toString(count), k -> new ArrayList<>());
            list.add(s);
        }

        return new ArrayList<>(map.values());

    }
}
