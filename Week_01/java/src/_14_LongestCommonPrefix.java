class _14_LongestCommonPrefix {
    //第一印象想到的解法，取出第一个字符串，然后从头开始取出每一个位置i处的字符c，遍历剩下的字符串比较i处的字符串是否相同，用了15分钟。
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String first = strs[0];
        int i = 0;
        outer:for (; i < first.length(); i++) {
            char c = first.charAt(i);
            boolean equals = true;
            for (int j = 1; j < strs.length; j++) {
                String next = strs[j];
                if (next.length() == i || next.charAt(i) != c) {
                    equals = false;
                    break outer;
                }
            }
        }
        return first.substring(0, i);
    }
}