## 深度优先搜索和广度优先搜索

### 在树/图/状态集中寻找特定节点

每个节点都要访问一次
每个节点仅被访问一次
对节点的访问顺序不限
- 深度优先DFS
- 广度优先BFS

- 示例代码

```python

visited = set() 
def dfs(node, visited): 
    if node in visited: # terminator 
        # already visited 
        return 
    visited.add(node) 
    # process current node here. 
    # ...
    for next_node in node.children(): 
        dfs(next node, visited)

```

```python

def DFS(self, tree): 
    if tree.root is None: 
        return [] 
    visited, stack = [], [tree.root] 
    while stack: 
        node = stack.pop() 
        visited.add(node) 
        process (node) 
        nodes = generate_related_nodes(node) 
        stack.push(nodes) 
    # other processing work 
    # ...

```

```python
def BFS(graph, start, end): 
    queue = [] 
    queue.append([start]) 
    visited.add(start) 
    while queue: 
        node = queue.pop() 
        visited.add(node) 
        process(node) 
        nodes = generate_related_nodes(node) 
        queue.push(nodes) 
    # other processing work 
    # ...
```

### 实战题目

- [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
  - 练习了3种bfs和递归dfs
- [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/)
  - 2种生成基因的方式各练习了2种dfs和3种bfs，肝了10遍。。。
  - 第一次练习理解错题目了，思路是将起始基因和目标基因不同的字符个数作为最少变化次数。浪费了时间
- [括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
  - 练习了bfs及迭代的dfs
- [在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)
  - 练习了3种bfs以及4种dfs
- [单词接龙](https://leetcode-cn.com/problems/word-ladder/)
  - 练习了单向bfs和双向bfs，遍历字典寻找当前单词的下一层单词用的时间比直接从当前单词生成多。字典中的单词太多了，相反在最小基因变化这道题中基因库的基因反而相对直接生成的方式要少，所以更快。
- [单词接龙 II](https://leetcode-cn.com/problems/word-ladder-ii/)
  - 第一次做用了单向bfs，但是每生成一个节点都要复制一份路径，所以超时了，然后就灰溜溜的抄作业了。练习了单向bfs生成邻接表然后dfs邻接表及双向bfs生成邻接表然后dfs邻接表。
  - 单词接龙和最小基因变化都是最短路径问题。
- [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
- [扫雷游戏](https://leetcode-cn.com/problems/minesweeper/)

### 参考链接

- [DFS 代码模板（递归写法、非递归写法）](https://shimo.im/docs/UdY2UUKtliYXmk8t/)
- [BFS 代码模板](https://shimo.im/docs/ZBghMEZWix0Lc2jQ/)


## 贪心算法

贪心算法是一种在每一步中都采取当前状态最好或最优的选择，从而希望导致结果是全局最好或最优的算法。
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。
动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

贪心算法可以解决一些最优化问题，如求途中的最小生成树，求哈夫曼编码等，但对于工程和生活中的问题，贪心算法一般不能得到我们所要求的答案。
一旦一个问题可以通过贪心算法来解决，那么贪心算法一般是解决这个问题的最好办法。
由于贪心发的高效性以及其所求得的答案比较接近最优结果，贪心算法也可用于辅助算法或者直接解决一些要求结果不特别精确的问题。

问题能够分解成子问题，子问题的最优解能递推到最终问题的最优解。
这种子问题最优解称为最优子结构。

### 实战题目

- [Coin Change](https://leetcode-cn.com/problems/coin-change/)
- [柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/description/)
- [买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/)
- [分发饼干](https://leetcode-cn.com/problems/assign-cookies/)
- [模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/description/)
- [跳跃游戏](https://leetcode-cn.com/problems/jump-game/)
- [跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/)

### 参考链接

- [动态规划定义](https://zh.wikipedia.org/wiki/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92)


## 二分查找

- 目标函数单调性（单调递增或单调递减）
- 存在上下界
- 能够通过索引访问

```python
    left, right = 0, len(array) - 1
    while left <= right:
        mid = (left + right) / 2
        if array[mid] == target: # find the target!! 
            break or return result 
        elif array[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
```

### 实战题目

- [x 的平方根](https://leetcode-cn.com/problems/sqrtx/)
- [有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square/)
- [搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)
- [搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/)
- [寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)

### 参考链接

- [二分查找代码模板](https://shimo.im/docs/xvIIfeEzWYEUdBPD/)
- [Fast InvSqrt() 扩展阅读](https://www.beyond3d.com/content/articles/8/)

# 持续刷题

- [被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)
