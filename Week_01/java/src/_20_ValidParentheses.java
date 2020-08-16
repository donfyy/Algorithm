import java.util.LinkedList;

/**
 * 第一遍：2020/08/13周四 ✅
 * 第二遍：2020/08/14周五 ✅
 * 第三遍：2020/08/16周日 ✅
 * 第四遍：2020/08/17周一 ✅
 * 第五遍：2020/08/09周日
 * 第六遍：2020/08/09周一
 * 第七遍：2020/08/12周三
 */
class _20_ValidParentheses {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.offerLast(')');
            } else if (c == '[') {
                stack.offerLast(']');
            } else if (c == '{') {
                stack.offerLast('}');
            } else {
                if (stack.isEmpty() || stack.pollLast() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}