public class PatternSearching {
    public static class Naive {
        public static void main(String[] args) {
            new Naive().search(
                    "AABAACAADAABAABA",
                    "AABA"
            );
        }

        //时间O(nm)
        public void search(String txt, String pat) {
            int n = txt.length(), m = pat.length();
            // "aaa" "aa" m = 3, n = 2 m - n + 1 =2
            for (int i = 0, j = 0; i <= n - m; i++, j = 0) {
                while (j < m && txt.charAt(i + j) == pat.charAt(j)) {
                    j++;
                }
                if (j == m) {
                    System.out.println("Pattern found at index " + i);
                }
            }
        }
    }
    // TODO: 2020/7/21 Rabin-Karp algorithm 
    // TODO: 2020/7/21 KMP algorithm
    public static class KMP {
        public void search(String txt, String pat) {

        }

        public int[] createPrefixTable(String pat) {
           int m = pat.length();
           int[] prefix = new int[m];
           prefix[0] = 0;
           int len = 0;
           int i = 1;
           return prefix;
        }
    }
}
