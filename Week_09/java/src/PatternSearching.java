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
    public static class KMP {
        public void search(String txt, String pat) {
            int[] lps = createLPSArray(pat);
            int m = txt.length();
            int n = pat.length();
            int i = 0;
            int j = 0;
            while (i < m) {
                if (txt.charAt(i) == pat.charAt(j)) {
                    if (j == n - 1) {
                        System.out.println("Pattern Found at index " + (i - j));
                        j = lps[j];
                        continue;
                    }
                    i++;
                    j++;
                } else {
                    if (j != 0) {
                        j = lps[j];
                    } else {
                        i++;
                    }
                }
            }
        }

        public static void main(String[] args) {
            new KMP().search("AABAACAADAABAABA", "AABA");
        }

        public int[] createLPSArray(String pat) {
            int n = pat.length();
            int[] lps = new int[n];
            lps[0] = -1;
            lps[1] = 0;
            //A   B A B C A B A A
            //0   0 1 2 0 1 2 3
            int len = 0;
            int i = 1;
            while (i < n - 1) {
                if (pat.charAt(i) == pat.charAt(len)) {
                    len++;
                    lps[++i] = len;
                } else {
                    if (len > 0) {
                        len = lps[len];
                    } else {
                        lps[++i] = 0;
                    }
                }
            }

            return lps;
        }
    }
}
