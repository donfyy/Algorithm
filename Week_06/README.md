学习笔记
### 动态规划
- 适用条件（递推的解决问题）
  - 最优子结构
  - 重复子问题
  - 无后效性
    - 接雨水与柱状图中的最大矩形，无法用动态规划，就是因为第i个柱子能接的雨水数量或能形成的最大矩形不仅取决于左边的边界，还取决于右边的元素，我想这便是不能用动态规划的原因吧。
- 编码模板
  - 状态表示
  - 状态转移
    - 其实就是寻找f(i)与f(i-1)之间的关系，斐波那契数列非常典型。最长不含重复字符的子字符串，礼物的最大价值等等。
  - 边界情况
- 解题步骤
  1. 找重复子问题
  2. 定义状态
  3. 定义dp方程
- 每一个动态规划的题目都可以有递归和循环两种写法
    - 自顶向下的递归 会重复计算相同的子问题
        - 自顶向下的记忆化递归
    - 自底向上的循环
        - **自底向上的优化空间后的循环** 这是应该给出的解法
### 实战题目
- [交错字符串](https://leetcode-cn.com/problems/interleaving-string/)
- [**戳气球**](https://leetcode-cn.com/problems/burst-balloons/)
  - 这道题目很难，第一遍花了近两个小时，只是懂了大概，继续努力.
  - [动态规划套路解决戳气球问题](https://leetcode-cn.com/problems/burst-balloons/solution/dong-tai-gui-hua-tao-lu-jie-jue-chuo-qi-qiu-wen-ti/)
- [最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)
- [最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)
  f(i, j)表示t1\[0, i - 1\]与t2\[0, j - 1\]的最长公共子序列的长度
  则if (t1\[i - 1\] == t2\[j - 1\]) f(i, j) = f(i - 1, j - 1) + 1
  else f(i, j) = max(f(i - 1, j), f(i, j - 1))。
  如果求最长公共子串的长度则f(i, j)表示t1\[0, i - 1\]与t2\[0, j - 1]**包含t1\[i - 1]和t2\[j - 1]**的最长公共子串的长度
  因此if (t1\[i - 1\] == t2\[j - 1\]) f(i, j) = f(i - 1, j - 1) + 1
  else f(i, j) = 0, 我们要返回max(f(i, j))。这个状态的定义和最大子序和的状态定义类似。