/**
 * 第一遍：2020/08/04周二 ✅
 * 第二遍：2020/08/06周四 ✅
 * 第三遍：2020/08/07周五 ✅
 * 第三遍：2020/07/08周四
 */
class _415_AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder ret = new StringBuilder();
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int s = a + b + add;
            ret.append(s % 10);
            add = s / 10;
            i--;
            j--;
        }
        return ret.reverse().toString();
    }
}