public class PatternSearchingPractice {
    public static class Naive {
        public static void main(String[] args) {
            new Naive().search(
                    "AABAACAADAABAABA",
                    "AABA"
            );
        }

        public void search(String txt, String pat) {
            int m = pat.length();
            int n = txt.length();
            int i = 0;
            while (i <= n - m) {
                int j = 0;
                while (j < m && txt.charAt(i + j) == pat.charAt(j)) j++;
                if (j == m) {
                    System.out.println("Pattern found at index " + i);
                }
                i++;
            }
        }
    }

    public static class KMP {
        public static void main(String[] args) {
            new KMP().search("AABAACAADAABAABA", "AABA");
        }

        public void search(String txt, String pat) {
            int[] lps = createLPSArray(pat);
            int m = pat.length();
            int n = txt.length();
            int i = 0;
            int j = 0;
            while (i < n) {
                if (pat.charAt(j) == txt.charAt(i)) {
                    if (j == m - 1) {
                        System.out.println("Pattern found at index " + (i - j));
                        j = lps[j];
                        continue;
                    }
                    j++;
                    i++;
                } else {
                    if (j == 0) {
                        i++;
                    } else {
                        j = lps[j];
                    }
                }
            }
        }

        public int[] createLPSArray(String pat) {
            int m = pat.length();
            int[] lps = new int[m + 1];
            int len = 0;
            lps[0] = -1;
            lps[1] = 0;
            int i = 1;
            while (i < m) {
                if (pat.charAt(len) == pat.charAt(i)) {
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
