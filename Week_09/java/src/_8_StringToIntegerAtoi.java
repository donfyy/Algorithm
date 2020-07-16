/**
 * 第一遍：2020/07/15周三 ✅
 * 第二遍：2020/07/16周四 ✅
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _8_StringToIntegerAtoi {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int idx = 0, ret = 0, sign = 1;
        while (idx < str.length() && str.charAt(idx) == ' ') idx++;
        if (idx == str.length()) return 0;
        if (str.charAt(idx) == '-') {
            sign = -1;
            idx++;
        } else if (str.charAt(idx) == '+') {
            idx++;
        }
        while (idx < str.length() && str.charAt(idx) >= '0' && str.charAt(idx) <= '9') {
            int c = str.charAt(idx) - '0';
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && c > Integer.MAX_VALUE % 10)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            ret = ret * 10 + c;
            idx++;
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