/**
 * 第一遍：2020/07/15周三 ✅
 * 第二遍：2020/07/16周四 ✅
 * 第三遍：2020/09/03周四 ✅
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _8_StringToIntegerAtoi {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        int i = 0, ret = 0, sign = 1, n = s.length();
        while (i < n && s.charAt(i) == ' ') i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int num = s.charAt(i) - '0';
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ret = ret * 10 + num;
            i++;
        }
        return ret * sign;
    }

    class SulotionWithAutomaton {
        class Automaton {
            public final int STARTED = 0;
            public final int SIGNED = 1;
            public final int IN_NUMBER = 2;
            public final int END = 3;
            private int[][] map = new int[3][4];

            {
                map[STARTED][0] = STARTED;
                map[STARTED][1] = SIGNED;
                map[STARTED][2] = IN_NUMBER;
                map[STARTED][3] = END;

                map[SIGNED][0] = END;
                map[SIGNED][1] = END;
                map[SIGNED][2] = IN_NUMBER;
                map[SIGNED][3] = END;

                map[IN_NUMBER][0] = END;
                map[IN_NUMBER][1] = END;
                map[IN_NUMBER][2] = IN_NUMBER;
                map[IN_NUMBER][3] = END;

            }

            private int state = STARTED;
            private long ans = 0;
            private int sign = 1;

            private int getCol(char c) {
                if (c == ' ') return 0;
                if (c == '+' || c == '-') return 1;
                if (c >= '0' && c <= '9') return 2;
                return 3;
            }

            private boolean consume(char c) {
                if (state == END) return true;
                state = map[state][getCol(c)];
                switch (state) {
                    case IN_NUMBER: {
                        ans = ans * 10 + c - '0';
                        if (sign == 1) {
                            if (ans > Integer.MAX_VALUE) {
                                ans = Integer.MAX_VALUE;
                                state = END;
                            }
                        } else {
                            if (ans > -(long) Integer.MIN_VALUE) {
                                ans = -(long) Integer.MIN_VALUE;
                                state = END;
                            }
                        }
                        break;
                    }
                    case SIGNED: {
                        sign = c == '+' ? 1 : -1;
                        break;
                    }
                    default:
                        break;
                }

                return state == END;
            }

            public int myAtoi(String str) {
                if (str == null) return 0;
                Automaton automaton = new Automaton();
                for (int i = 0; i < str.length(); i++) {
                    if (automaton.consume(str.charAt(i))) {
                        break;
                    }
                }
                return (int) (automaton.sign * automaton.ans);
            }
        }
    }
}