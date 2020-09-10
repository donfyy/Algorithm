import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 第一遍：2020/09/10周三 ✅
 * 第二遍：2020/09/03周四
 * 第二遍：2020/06/12周二
 * 第三遍：2020/06/18周四
 * 第四遍：2020/07/02周四
 */
public class _38_字符串的排列 {
    static class Solution {
        List<String> ret = new ArrayList<>();

        public String[] permutation(String s) {
            char[] arr = s.toCharArray();
            dfs(arr, 0);
            return ret.toArray(new String[0]);
        }

        void dfs(char[] arr, int start) {
            if (start == arr.length - 1) {
                ret.add(String.valueOf(arr));
                return;
            }

            Set<Character> set = new HashSet<>();
            for (int i = start; i < arr.length; i++) {
                if (set.contains(arr[i])) continue;
                set.add(arr[i]);
                swap(arr, start, i);
                dfs(arr, start + 1);
                swap(arr, start, i);
            }
        }

        void swap(char[] arr, int i, int j) {
            if (i != j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
