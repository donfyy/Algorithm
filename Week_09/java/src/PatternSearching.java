import java.util.Arrays;

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

    public static class BoyerMoore {
        public static void main(String[] args) {
//            new BoyerMoore().search("AABAACAADAABAABA", "AABA");
            String pat = "ABBAB";
            //bpos  3 4 4 5 5 6
            //shift 0 0 0 0 2 1
            // TODO: 2020/7/23 折腾了一天没有理解好后缀的概念，草 
            int[] shift = new int[pat.length() + 1];
            int[] bpos = new int[pat.length() + 1];
            BoyerMoore boyerMoore = new BoyerMoore();
            boyerMoore.preprocessingStrongSuffix(
                    shift,
                    bpos,
                    pat
            );
            boyerMoore.preProcessCash2(shift, bpos, pat);
        }

        public void search(String txt, String pat) {
            int m = pat.length();
            int n = txt.length();
            int[] badChar = badCharHeuristic(pat);

            int i = 0;
            while (i <= n - m) {
                int j = m - 1;
                while (j >= 0 && pat.charAt(j) == txt.charAt(i + j)) j--;
                if (j < 0) {
                    System.out.println("Pattern found at index " + i);
                    i += (i == n - m) ? 1 : m - badChar[txt.charAt(i + m)];
                } else {
                    i += Math.max(1, j - badChar[txt.charAt(i + j)]);
                }
            }
        }

        public void preProcessCash2(int[] shift, int[] bpos, String pat) {
            int m = pat.length();
            for (int i = 0, j = bpos[0]; i <= m; i++) {
                if (shift[i] == 0) {
                    shift[i] = j;
                }
                if (i == j) {
                    j = bpos[j];
                }
            }
            System.out.println(Arrays.toString(bpos));
            System.out.println(Arrays.toString(shift));
        }

        public void preprocessingStrongSuffix(int[] shift, int[] bpos, String pat) {
            int m = pat.length();
            int i = m, j = m + 1;
            bpos[m] = j;
            while (i > 0) {
                while (j <= m && pat.charAt(i - 1) != pat.charAt(j - 1)) {
                    if (shift[j] == 0) {
                        shift[j] = j - i;
                    }
                    j = bpos[j];
                }
                i--;
                j--;
                bpos[i] = j;
            }

        }

        public int[] badCharHeuristic(String pat) {
            int m = pat.length();
            int[] badChar = new int[256];
            Arrays.fill(badChar, -1);
            for (int i = 0; i < m; i++) {
                badChar[pat.charAt(i)] = i;
            }
            return badChar;
        }
    }
}
