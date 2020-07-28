import java.util.Arrays;
/**
 * 第一遍：2020/07/27周一 ✅
 * 第二遍：2020/07/28周二 ✅
 * 第三遍：2020/07/27周一
 * 第四遍：2020/07/28周二
 * 第四遍：2020/07/05周日
 */
public class PatternSearchingPractice {
    public static class Naive {
        public static void main(String[] args) {
            new Naive().search(
                    "AABAACAADAABAABA",
                    "AABA"
            );
        }

        //        时间：O(nm)
        public void search(String txt, String pat) {
            int m = pat.length();
            int n = txt.length();
            int i = 0;
            while (i <= n - m) {
                int j = 0;
                while (j < m && pat.charAt(j) == txt.charAt(i + j)) {
                    j++;
                }
                if (j == m) {
                    System.out.println("Pattern found at index " + i);
                }
                i++;
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

            int patHash = 0;
            int txtHash = 0;
            for (int i = 0; i < m; i++) {
                patHash = (D * patHash + pat.charAt(i)) % Q;
                txtHash = (D * txtHash + txt.charAt(i)) % Q;
            }

            int highestPow = 1;
            for (int i = 0; i < m - 1; i++) {
                highestPow = (highestPow * D) % Q;
            }

            for (int i = 0; i <= n - m; i++) {
                if (txtHash == patHash) {
                    int j = 0;
                    while (j < m && pat.charAt(j) == txt.charAt(i + j)) {
                        j++;
                    }
                    if (j == m) {
                        System.out.println("Pattern found at index " + i);
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
        public static void main(String[] args) {
            new KMP().search("AABAACAADAABAABA", "AABA");
        }

        public void search(String txt, String pat) {
            int m = pat.length();
            int n = txt.length();
            int[] lps = createLPSArray(pat);
            int i = 0;
            while (i <= n - m) {
                int j = 0;
                while (j < m && pat.charAt(j) == txt.charAt(i + j)) {
                    j++;
                }
                if (j == m) {
                    System.out.println("Pattern found at index " + i);
                }
                i += j - lps[j];
            }
        }

        public int[] createLPSArray(String pat) {
            int m = pat.length();
            int[] lps = new int[m + 1];
            int len = 0;
            int i = 1;
            lps[0] = -1;
            while (i < m) {
                if (pat.charAt(i) == pat.charAt(len)) {
                    i++;
                    len++;
                    lps[i] = len;
                } else {
                    if (len > 0) {
                        len = lps[len];
                    } else {
                        i++;
                        lps[i] = 0;
                    }
                }
            }
            return lps;
        }
    }

    public static class BoyerMoore {
        public static void main(String[] args) {
            new BoyerMoore().search(
                    "AABAACAADAABAABA", "AABA"
            );
        }

        void search(String txt, String pat) {
            int m = pat.length();
            int n = txt.length();
            int[] badChar = badCharHeuristic(pat);
            int[] shift = goodSuffixHeuristic(pat);

            int i = 0;
            while (i <= n - m) {
                int j = m - 1;
                while (j >= 0 && pat.charAt(j) == txt.charAt(i + j)) {
                    j--;
                }

                if (j == -1) {
                    System.out.println("Pattern found at index " + i);
                    int badCharShift = i == n - m ? 1 : Math.max(m - badChar[txt.charAt(i + m)], 1);
                    int goodSuffixShift = shift[0];
                    i += Math.max(badCharShift, goodSuffixShift);
                } else {
                    int badCharShift = Math.max(1, j - badChar[txt.charAt(i + j)]);
                    int goodSuffixShift = shift[j + 1];
                    i += Math.max(badCharShift, goodSuffixShift);
                }
            }
        }

        int[] goodSuffixHeuristic(String pat) {
            int m = pat.length();
            int j = m + 1;
            int i = m;
            int[] bpos = new int[m + 1];
            int[] shift = new int[m + 1];
            bpos[i] = j;
            while (i > 0) {
                if (j <= m && pat.charAt(i - 1) != pat.charAt(j - 1)) {
                    if (shift[j] == 0) {
                        shift[j] = j - i;
                    }
                    j = bpos[j];
                } else {
                    i--;
                    j--;
                    bpos[i] = j;
                }
            }

            j = bpos[0];
            for (i = 0; i <= m; i++) {
                if (shift[i] == 0) {
                    shift[i] = j;
                }
                if (i == j) {
                    j = bpos[j];
                }
            }
            return shift;
        }

        int[] badCharHeuristic(String pat) {
            int m = pat.length();
            int[] badChar = new int[256];
            Arrays.fill(badChar, -1);
            for (int i = 0; i < m; i++) {
                badChar[pat.charAt(i)] = i;
            }
            return badChar;
        }
    }

    public static class Sunday {
        public static void main(String[] args) {
            new Sunday().search(
                    "AABAACAADAABAABA", "AABA"
            );
        }

        void search(String txt, String pat) {
            int m = pat.length();
            int n = txt.length();

            int[] shift = badCharHeuristic(pat);
            int i = 0;
            while (i <= n - m) {
                int j = 0;
                while (j < m && pat.charAt(j) == txt.charAt(i + j)) {
                    j++;
                }
                if (j == m) {
                    System.out.println("Pattern found at index " + i);
                }
                i += i == n - m ? 1 : shift[txt.charAt(i + m)];
            }
        }

        int[] badCharHeuristic(String pat) {
            int m = pat.length();
            int[] shift = new int[256];
            Arrays.fill(shift, m);
            for (int i = 0; i < m; i++) {
                shift[pat.charAt(i)] = m - i;
            }
            return shift;
        }
    }
}
