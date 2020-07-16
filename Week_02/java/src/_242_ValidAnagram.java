import java.util.Arrays;

/**
 * 第一遍：2020/05/25周一 ✅
 * 第二遍：2020/05/26周二 ✅
 * 第三遍：2020/07/12周一 ✅
 * 第四遍：2020/07/16周四 ✅
 */
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
