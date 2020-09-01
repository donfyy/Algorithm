# 字符串算法
## 实战题目

### 字符串基础问题

- [转换成小写字母](https://leetcode-cn.com/problems/to-lower-case/)
- [最后一个单词的长度](https://leetcode-cn.com/problems/length-of-last-word/)
- [宝石与石头](https://leetcode-cn.com/problems/jewels-and-stones/)
- [字符串中的第一个唯一字符](https://leetcode-cn.com/problems/first-unique-character-in-a-string/)
- [**字符串转换整数 (atoi)**](https://leetcode-cn.com/problems/string-to-integer-atoi/)

### 字符串操作问题

- [最长公共前缀](https://leetcode-cn.com/problems/longest-common-prefix/description/)
- [反转字符串](https://leetcode-cn.com/problems/reverse-string)
- [反转字符串 II ](https://leetcode-cn.com/problems/reverse-string-ii/)
- [**翻转字符串里的单词**](https://leetcode-cn.com/problems/reverse-words-in-a-string/)
  - 空格处理上花了较多时间。
- [反转字符串中的单词 III ](https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/)
- [仅仅反转字母](https://leetcode-cn.com/problems/reverse-only-letters/)
- [同构字符串](https://leetcode-cn.com/problems/isomorphic-strings/)

### 异位词问题

- [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)
- [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)
- [**找到字符串中所有字母异位词**](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)
  - 没看懂题解的代码。。。
  
### 回文串问题

- [验证回文串](https://leetcode-cn.com/problems/valid-palindrome/)
- [验证回文字符串 Ⅱ](https://leetcode-cn.com/problems/valid-palindrome-ii/)
- [最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/) [作业](https://github.com/donfyy/algorithm009-class01/blob/master/Week_06/java/src/longestpalindromicsubstring/_5_LongestPalindromicSubstring.java)
- [回文子串](https://leetcode-cn.com/problems/palindromic-substrings/)
- [回文对](https://leetcode-cn.com/problems/palindrome-pairs/)

### 最长子串、子序列问题

- [最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/) [作业](https://github.com/donfyy/algorithm009-class01/blob/master/Week_06/java/src/longestpalindromicsubstring/_5_LongestPalindromicSubstring.java)
- [最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/) [作业](https://github.com/donfyy/algorithm009-class01/blob/master/Week_06/kotlin/src/_1143_LongestCommonSubsequence.kt)
- [编辑距离](https://leetcode-cn.com/problems/edit-distance/) [作业](https://github.com/donfyy/algorithm009-class01/blob/master/Week_06/java/src/_72_EditDistance.java)

### 字符串+dp

- [正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/) [作业](https://github.com/donfyy/algorithm009-class01/blob/master/Week_06/java/src/_10_RegularExpressionMatching.java)
  - [参考题解](https://leetcode-cn.com/problems/regular-expression-matching/solution/ji-yu-guan-fang-ti-jie-gen-xiang-xi-de-jiang-jie-b/)
- [通配符匹配](https://leetcode-cn.com/problems/wildcard-matching/) [作业](https://github.com/donfyy/algorithm009-class01/blob/master/Week_06/java/src/_44_WildcardMatching.java)
- [不同的子序列](https://leetcode-cn.com/problems/distinct-subsequences/) [作业](https://github.com/donfyy/algorithm009-class01/blob/master/Week_06/java/src/_115_DistinctSequences.java)

### 字符串匹配算法
  
- Rabin-Karp 算法

  在朴素算法中，我们需要挨个比较所有字符，才知道目标字符串中是否包含子串。那么，是否有别的方法可以用来判断目标字符串是否包含子串呢？
  答案是肯定的，确实存在一种更快的方法。为了避免挨个字符对目标字符串和子串进行比较，我们可以尝试一次性判断两者是否相等。因此，我们需要
  一个好的哈希函数（hash function）。通过哈希函数，我们可以算出子串的哈希值，然后将它和目标字符串中的子串的哈希值进行比较。这个新方法
  在速度上比暴力法有显著提升。

  1.假设子串的长度为M(pat)，目标字符串的长度为N(txt)
  2.计算子串的hash值hash_pat
  3.计算目标字符串txt中每个长度为M的子串的hash值(共N - M + 1次)
  4.比较hash值，如果hash值不同，字符串必然不匹配；如果hash值相同，还需要使用朴素算法再次判断

- KMP 算法

  KMP算法(Knuth-Morris-Pratt)的思想就是，当子串与目标字符串不匹配是，其实你已经知道了前面已经匹配成功的那一部分的字符（包括子串
  和目标字符串）。以阮一峰的文章为例，当空格与D不匹配是时，你其实知道前面六个字符是"ABCDAB"。KMP的算法思想是，设法利用这个已知信息
  ，不要把"搜索位置"移回已经比较过的位置，继续把它向后移，这样就提高了效率。
  
    
#### 参考链接
- [Boyer-Moore 算法](https://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html)
- [Sunday 算法](https://blog.csdn.net/u012505432/article/details/52210975)
- [字符串匹配暴力法代码示例](https://shimo.im/docs/8G0aJqNL86wWrPUE)
- [Rabin-Karp 代码示例](https://shimo.im/docs/1wnsM7eaZ6Ab9j9M)
- [KMP 字符串匹配算法视频](https://www.bilibili.com/video/av11866460?from=search&seid=17425875345653862171)
- [字符串匹配的 KMP 算法](http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html)
- [不可变字符串](https://lemire.me/blog/2017/07/07/are-your-strings-immutable/)
- [Atoi 代码示例](https://shimo.im/docs/5kykuLmt7a4DdjSP)

# 2 [动态规划](https://github.com/donfyy/algorithm009-class01/tree/master/Week_06)

# 持续刷题

- [字符串相加](https://leetcode-cn.com/problems/add-strings/)
- [重复的子字符串](https://leetcode-cn.com/problems/repeated-substring-pattern/) 练习KMP算法
- [递增子序列](https://leetcode-cn.com/problems/increasing-subsequences/) 练习Rabin-Karp算法
- [最短回文串](https://leetcode-cn.com/problems/shortest-palindrome/) 练习Rabin-Karp和KMP算法

