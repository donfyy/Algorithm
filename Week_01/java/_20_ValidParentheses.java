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