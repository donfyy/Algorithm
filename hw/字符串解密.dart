/**
 * 题目描述：
    给定两个字符串string1和string2。
    string1是一个被加扰的字符串。string1由小写英文字母（'a'~'z'）和数字字符（'0'~'9'）组成，而加扰字符串由'0'~'9'、'a'~'f'组成。string1里面可能包含0个或多个加扰子串，剩下可能有0个或多个有效子串，这些有效子串被加扰子串隔开。
    string2是一个参考字符串，仅由小写英文字母（'a'~'z'）组成。
    你需要在string1字符串里找到一个有效子串，这个有效子串要同时满足下面两个条件：
    （1）这个有效子串里不同字母的数量不超过且最接近于string2里不同字母的数量，即小于或等于string2里不同字母的数量的同时且最大。
    （2）这个有效子串是满足条件（1）里的所有子串（如果有多个的话）里字典序最大的一个。
    如果没有找到合适条件的子串的话，请输出"Not Found"

示例：
输入字符串string1为"thisisanewday111forme"，输入字符串string2为"good"。string1里有效子串和加扰子串分割后可表示为："thisis"+"a"+"n"+"e"+"w"+"da"+"y"+"111f"+"orm"+"e"，
去除加扰子串（"a"、"e"、"da"、"111f"、"e"）后的有效子串候选为("thisis", "n", "w", "y", "orm")。输入字符串string2里不同字母的数量为3（'g'、'o'、'd'），从有效子串候选里可以找出"orm"满足要求，其不同字母的数量为3，最接近于string2不同字母的数量。

输入描述：
input_string1
input_string2
说明：输入为两个字符串，第1行是题目里的string1（被加扰的字符串），第2行是题目里的string2（参考字符串）

输出描述：
output_string
说明：输出为一个字符串（有效字符串）
补充说明：
输入字符串string1的长度在1~100000之间，string2的长度在1~500之间
 */

void main(List<String> args) {
  print(largestSubString("thisisanewday111forme", "good"));
  print(largestSubString("thisisanewday111formexyz", "good"));
  print(largestSubString("thisisanewday111formegzz", "good"));
}

String largestSubString(String str1, String pivot) {
  var pivotNum = distinctCharNum(pivot, 0, pivot.length - 1);
  var subStart = -1;
  var i = 0;
  var ret = "";
  var input = str1 + "0";
  while (i < input.length) {
    var c = input.codeUnitAt(i);
    if (!((c >= '0'.codeUnitAt(0) && c <= '9'.codeUnitAt(0)) ||
        (c >= 'a'.codeUnitAt(0) && c <= 'f'.codeUnitAt(0)))) {
      if (subStart == -1) {
        subStart = i;
      }
    } else {
      if (subStart != -1) {
        var sub = input.substring(subStart, i);
        var subNum = distinctCharNum(sub, 0, sub.length - 1);
        if (subNum <= pivotNum) {
          if (sub.length > ret.length ||
              (sub.length == ret.length && sub.compareTo(ret) > 0)) {
            ret = sub;
          }
        }
        subStart = -1;
      }
    }
    i++;
  }

  return ret.isEmpty ? "Not Found" : ret;
}

int distinctCharNum(String str, int start, int end) {
  var ret = 0;
  var set = <int>{};
  for (var i = start; i <= end; i++) {
    if (!set.contains(str.codeUnitAt(i))) {
      ret++;
      set.add(str.codeUnitAt(i));
    }
  }
  return ret;
}
