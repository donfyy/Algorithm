## 动态规划

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
       
### 动态规划关键点

1. 最优子结构
2. 储存中间状态
3. 递推公式
 
### 实战题目

- [斐波那契数](https://leetcode-cn.com/problems/fibonacci-number)
- [杨辉三角](https://leetcode-cn.com/problems/pascals-triangle/)
- [杨辉三角II](https://leetcode-cn.com/problems/pascals-triangle-ii/)
- [不同路径](https://leetcode-cn.com/problems/unique-paths/)
- [不同路径 II ](https://leetcode-cn.com/problems/unique-paths-ii/)
- [不同路径 III ](https://leetcode-cn.com/problems/unique-paths-iii/)
- [最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)
- [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/description/)
- [使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/)
- [三角形最小路径和](https://leetcode-cn.com/problems/triangle/description/)
- [最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)
- [乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray/description/)
- [零钱兑换](https://leetcode-cn.com/problems/coin-change/description/)
- [打家劫舍](https://leetcode-cn.com/problems/house-robber/)
- [打家劫舍 II ](https://leetcode-cn.com/problems/house-robber-ii/description/)
- [打家劫舍 II ](https://leetcode-cn.com/problems/house-robber-ii/description/)
- [买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description)
- [买卖股票的最佳时机 II ](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)
- [买卖股票的最佳时机 III ](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)
- [最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)
- [买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)
- [买卖股票的最佳时机含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)

- [最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)
- [解码方法](https://leetcode-cn.com/problems/decode-ways)
- [最大正方形](https://leetcode-cn.com/problems/maximal-square/)
- [任务调度器](https://leetcode-cn.com/problems/task-scheduler/)

### 高级DP实战题目

- [完全平方数](https://leetcode-cn.com/problems/perfect-squares/)
- [编辑距离](https://leetcode-cn.com/problems/edit-distance/)
- [跳跃游戏](https://leetcode-cn.com/problems/jump-game/)
- [跳跃游戏 II ](https://leetcode-cn.com/problems/jump-game-ii/)
- [零钱兑换](https://leetcode-cn.com/problems/coin-change/)
- [零钱兑换 II ](https://leetcode-cn.com/problems/coin-change-2/)

- [最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)
- [矩形区域不超过 K 的最大数值和](https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/)
- [青蛙过河](https://leetcode-cn.com/problems/frog-jump/)
- [分割数组的最大值](https://leetcode-cn.com/problems/split-array-largest-sum)
- [学生出勤记录 II ](https://leetcode-cn.com/problems/student-attendance-record-ii/)
- [最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)
- [**戳气球**](https://leetcode-cn.com/problems/burst-balloons/)

- [最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)
- [最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)
- [最大矩形](https://leetcode-cn.com/problems/maximal-rectangle/)
- [不同的子序列](https://leetcode-cn.com/problems/distinct-subsequences/)
- [赛车](https://leetcode-cn.com/problems/race-car/)

- [交错字符串](https://leetcode-cn.com/problems/interleaving-string/)
  - 这道题目很难，第一遍花了近两个小时，只是懂了大概，继续努力.
  - [动态规划套路解决戳气球问题](https://leetcode-cn.com/problems/burst-balloons/solution/dong-tai-gui-hua-tao-lu-jie-jue-chuo-qi-qiu-wen-ti/)
- [**最长回文子串**](https://leetcode-cn.com/problems/longest-palindromic-substring/)
- [回文子串](https://leetcode-cn.com/problems/palindromic-substrings/)
- [**最长公共子序列**](https://leetcode-cn.com/problems/longest-common-subsequence/)

  f(i, j)表示t1\[0, i - 1\]与t2\[0, j - 1\]的最长公共子序列的长度

  则if (t1\[i - 1\] == t2\[j - 1\]) f(i, j) = f(i - 1, j - 1) + 1
  
  else f(i, j) = max(f(i - 1, j), f(i, j - 1))。
  
  如果求最长公共子串的长度则f(i, j)表示t1\[0, i - 1\]与t2\[0, j - 1\]包含t1\[i - 1\]和t2\[j - 1\]的最长公共子串的长度
  
  因此if (t1\[i - 1\] == t2\[j - 1\]) f(i, j) = f(i - 1, j - 1) + 1
  
  else f(i, j) = 0, 我们要返回max(f(i, j))。这个状态的定义和最大子序和的状态定义类似。
  
- [**编辑距离**](https://leetcode-cn.com/problems/edit-distance/)
- [**正则表达式匹配**](https://leetcode-cn.com/problems/regular-expression-matching/)
- [**通配符匹配**](https://leetcode-cn.com/problems/wildcard-matching/)
- [**不同的子序列**](https://leetcode-cn.com/problems/distinct-subsequences/)

  没想明白为什么f(i, j) = f(i - 1, j - 1) + f(i, j - 1)。。。编辑距离相对于不同的子序列就好理解一些。

### 参考链接

- [递归代码模板](https://shimo.im/docs/EICAr9lRPUIPHxsH)
- [分治代码模板](https://shimo.im/docs/zvlDqLLMFvcAF79A)
- [动态规划定义](https://en.wikipedia.org/wiki/Dynamic_programming)
- [MIT 动态规划课程最短路径算法](https://www.bilibili.com/video/av53233912?from=search&seid=2847395688604491997)
- [一个方法团灭 6 道股票问题](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/)

### 持续刷题
- [除数博弈](https://leetcode-cn.com/problems/divisor-game/)
  
  这是一道数学题，奇数先手必败，偶数先手必胜。也可以用动态规划来做，但一开始我没有能正确的定义状态
  f(i)表示黑板上的数字为i时Alice先手是否必胜，则状态的转移需要枚举\[1, i / 2\]的数字找到任意一个i的因数x并且
  f(i - x) == false(对手必败) 则f(i) = true 否则f(i) = false。
  
- [判断子序列](https://leetcode-cn.com/problems/is-subsequence/)