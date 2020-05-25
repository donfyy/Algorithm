import java.util.Arrays;

public class _242_ValidAnagram {
    /**
     * time:O(nlogn) space:O(n) String.toCharArray() 创建了一个新的字符数组
     */
    public static boolean isAnagram1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }

    /**
     * time:O(n) space:O(1) 表的大小与字符串的长度无关。
     */
    public static boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {

            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }

        for (int v : hash) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
}
