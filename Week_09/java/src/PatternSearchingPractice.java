import java.util.Arrays;

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

    public static class BoyerMoore {
        public static void main(String[] args) {
//            new BoyerMoore().search(
//                    "AABAACAADAABAABA", "AABA"
//            );
            BoyerMoore bm = new BoyerMoore();
            String pat = "AABA";
            PatternSearching.BoyerMoore pbm = new PatternSearching.BoyerMoore();
            int[] bpos2 = new int[pat.length() + 1];
            int[] shift2 = new int[pat.length() + 1];
            pbm.calculateShiftArrayForGoodSuffix(pat, shift2, bpos2);
            int[] bpos = new int[pat.length() + 1];
            int[] shift = new int[pat.length() + 1];
            bm.shiftArrayForGoodSuffix(
                    pat,
                    bpos,
                    shift
            );
            int[] shift1 = new int[pat.length()];
            bm.shiftArrayForGoodSuffix2(pat, shift1);
            System.out.println("0:" + Arrays.toString(shift2));
            System.out.println("1:" + Arrays.toString(shift));
            System.out.println("2:" + Arrays.toString(shift1));
        }

        void search(String txt, String pat) {
            int m = pat.length();
            int n = txt.length();

            int[] badChar = badCharHeuristic(pat);
            int[] bpos = new int[m + 1];
            int[] goodSuffixShiftArray = new int[m + 1];
            shiftArrayForGoodSuffix(pat, bpos, goodSuffixShiftArray);

            int i = 0;
            while (i <= n - m) {
                int j = m - 1;
                while (j >= 0 && txt.charAt(i + j) == pat.charAt(j)) {
                    j--;
                }
                if (j == -1) {
                    System.out.println("Pattern found at index " + i);
                    int badCharShift = i == n - m ? 1 : Math.max(m - badChar[txt.charAt(i + m)], 1);
                    int goodSuffixShift = goodSuffixShiftArray[0];
                    i += Math.max(badCharShift, goodSuffixShift);
                } else {
                    int badCharShift = Math.max(j - badChar[txt.charAt(i + j)], 1);
                    int goodSuffixShift = goodSuffixShiftArray[j + 1];
                    i += Math.max(badCharShift, goodSuffixShift);
                }
            }
        }

        void shiftArrayForGoodSuffix2(String pat, int[] shift) {
            int m = pat.length();
            int p = m;
            int l = m - 1;
            for (int i = l - 1; i >= 0; i--) {
                int j = 0;
                while (j < l - i && pat.charAt(j) == pat.charAt(i + 1 + j)) {
                    j++;
                }
                if (j == l - i) {
                    p = i + 1;
                }
                shift[i] = l - i + p;
            }

            for (int i = 0; i < l; i++) {
                int j = 0;
                while (j < i && pat.charAt(l - j) == pat.charAt(i - j)) {
                    j++;
                }
                if (pat.charAt(l - j) != pat.charAt(i - j)) {
                    shift[l - j] = j + l - i;
                }
            }
        }


        void shiftArrayForGoodSuffix(String pat, int[] bpos, int[] shift) {
            int m = pat.length();
            //bpos[i]表示[i, m]字符串的最长公共前后缀后缀首字母的位置
            int j = m + 1;
            int i = m;
            bpos[i] = j;
            while (i > 0) {
                if (j <= m && pat.charAt(j - 1) != pat.charAt(i - 1)) {
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
}
