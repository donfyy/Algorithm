import 'dart:math';

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
