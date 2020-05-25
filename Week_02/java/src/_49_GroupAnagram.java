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

    /**
     * 算术基本定理，又称为正整数的唯一分解定理，
     * 即：每个大于1的自然数，要么本身就是质数，要么可以写为2个以上的质数的积，而且这些质因子按大小排列之后，写法仅有一种方式。
     * 思路：以字符串的质数积作为哈希表的键。
     * 时间：O(nk)
     * 空间：O(nk)
     * 缺点：乘积容易溢出
     */
    public List<List<String>> groupAnagrams3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<Integer, List<String>> map = new HashMap<>();
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};


        for (String s : strs) {
            int key = 1;
            for (int i = 0; i < s.length(); i++) {
                key *= prime[s.charAt(i) - 'a'];
            }

            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(s);
        }

        return new ArrayList<>(map.values());

    }
}
