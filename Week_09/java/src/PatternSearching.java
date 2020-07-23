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

    public static class RabinKarp {
        public static void main(String[] args) {
            new RabinKarp().search("AABAACAADAABAABA", "AABA");
        }

        public static final int D = 256;
        public static final int Q = 9997;

        public void search(String txt, String pat) {
            int m = pat.length();
            int n = txt.length();
//            "AABAACAADAABAABA" n = 16
//            "AABA" m = 4
            int patHash = 0, txtHash = 0;
            for (int i = 0; i < m; i++) {
                patHash = (D * patHash + pat.charAt(i)) % Q;
                txtHash = (D * txtHash + txt.charAt(i)) % Q;
            }

            int highestPow = 1;// pow (256, M - 1)
            for (int i = 0; i < m - 1; i++) {
                highestPow = (highestPow * D) % Q;
            }

            for (int i = 0; i <= n - m; i++) {
                if (txtHash == patHash) {
                    int j = 0;
                    while (j < m && pat.charAt(j) == txt.charAt(i + j)) j++;
                    if (j == m) {
                        System.out.println("Pattern Found at index " + i);
                    }
                }

                if (i < n - m) {
                    txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + m)) % Q;
                    if (txtHash < 0) {
                        txtHash += Q;
                    }
                }
            }
        }
    }

    public static class KMP {
        public void search(String txt, String pat) {
            int[] lps = createLPSArray(pat);
            int n = txt.length();
            int m = pat.length();
            int i = 0;
            int j = 0;
            while (i < n) {
                if (txt.charAt(i) == pat.charAt(j)) {
                    if (j == m - 1) {
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
            int m = pat.length();
            int[] lps = new int[m];
            lps[0] = -1;
            lps[1] = 0;
            //A   B A B C A B A A
            //0   0 1 2 0 1 2 3
            int len = 0;
            int i = 1;
            while (i < m - 1) {
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
