import 'dart:math';

/**
 * 题目描述：
小华和小薇一起通过玩积木游戏学习数学。
他们有很多积木，每个积木块上都有一个数字，积木块上的数字可能相同。
小华随机拿一些积木挨着排成一排，请小薇找到这排积木中数字相同且所处位置最远的2块积木块，
计算他们的距离。
小薇请你帮忙替解决这个问题。

输入描述：
第一行输入为N，表示小华排成一排的积木总数。

接下来N行每行一个数字，表示小华排成一排的积木上数字。

输出描述：
相同数字的积木的位置最远距离；
如果所有积木数字都不相同，请返回-1.
补充说明：
0<=积木上的数字<10^9
1<=积木长度<=10^5
 */
main() {
  print(longestDistance([1, 2, 3, 1, 4]));
  print(longestDistance([1, 2, 3, 4, 5]));
}

int longestDistance(List<int> arr) {
  var posMap = <int, int>{};
  var ret = -1;
  for (var i = 0; i < arr.length; i++) {
    if (posMap[arr[i]] == null) {
      posMap[arr[i]] = i;
    } else {
      ret = max(ret, i - posMap[arr[i]]!);
    }
  }
  return ret;
}
