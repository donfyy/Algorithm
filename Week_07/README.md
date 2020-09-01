
| 数据结构   | 时间    |         |         |         |         |         | 空间      | 特性                     |
| ---------- | :------ | ------- | ------- | ------- | ------- | ------- | :-------- | :----------------------- |
|            | 平均    |         |         | 最差    |         |         | 最差      |                          |
|            | 访问    | 插入    | 删除    | 访问    | 插入    | 删除    |           |                          |
| 数组       | O(1)    | O(n)    | O(n)    | O(1)    | O(n)    | O(n)    | O(n)      | 在内存中占据连续空间     |
| 链表       | O(n)    | O(1)    | O(1)    | O(n)    | O(1)    | O(1)    | O(n)      | 一个节点指向另外一个节点 |
| 跳表       | O(logn) | O(logn) | O(logn) | O(n)    | O(n)    | O(n)    | O(n logn) | 建立了logn -1级的索引    |
| 栈         | O(n)    | O(1)    | O(1)    | O(n)    | O(1)    | O(1)    | O(n)      | 后进先出                 |
| 队列       | O(n)    | O(1)    | O(1)    | O(n)    | O(1)    | O(1)    | O(n)      | 先进先出                 |
| 哈希表     | O(1)    | O(1)    | O(1)    | O(n)    | O(n)    | O(n)    | O(n)      | 将键映射到表中一个位置   |
| 二叉查找树 | O(logn) | O(logn) | O(logn) | O(n)    | O(n)    | O(n)    | O(n)      | 左子树<根节点<右子树     |
| 红黑树     | O(logn) | O(logn) | O(logn) | O(logn) | O(logn) | O(logn) | O(n)      | 5个性质                  |
| AVL树     | O(logn) | O(logn) | O(logn) | O(logn) | O(logn) | O(logn) | O(n)      | 严格平衡，平衡因子        |


## trie树

又称字典树，单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎用于文本词频统计。

优点是能够最大限度地减少无谓的字符串比较，查询效率比哈希表高。

### 基本性质

1. 节点本身不存完整单词
2. 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串
3. 每个节点的所有子节点路径代表的字符都不相同

### 参考链接

- [二叉树的层次遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
- [实现 Trie](https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/)
- [Tire 树代码模板](https://shimo.im/docs/DP53Y6rOwN8MTCQH)

### 实战题目

- [实现 Trie](https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/)
- [单词搜索 II](https://leetcode-cn.com/problems/word-search-ii/)
- 分析单词搜索II用Trie树实现的时间复杂度
  
## 并查集

### 适用场景

- 组团，配对
- 很快的判断两个个体是不是在集合中

- 两个人是不是同一个朋友圈？
    - 定义朋友圈类，把两个人塞到这个朋友圈里。
    
### 基本操作

- makeSet(s): 建立一个新的并查集，其中包含s个单元素集合。
- unionSet(x, y): 把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并。
- find(x): 找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将他们各自的代表比较一下就可以了

### 代码模版

- [并查集代码模版](https://shimo.im/docs/VtcxL0kyp04OBHak)

### 实战题目

- [朋友圈](https://leetcode-cn.com/problems/friend-circles)
- [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
- [被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)
  
## 高级搜索

### 初级搜索

朴素搜索，遍历每个元素

优化方式：避免重复求解（fibonacci），剪枝（括号生成）, 零钱置换

#### 搜索方向：

##### DFS

###### 递归
 
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

###### 循环

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

##### BFS

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

### 高级搜索

#### 剪枝

某个选择不符合条件，就不选了，也就不用下沉了。这就是剪枝

#### 回溯法

- 回溯法采用试错的思想，尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至上几步的计算，再通过其他的可能的分步解答再次尝试寻找问题的答案。回溯法通常用最简单的递归来实现，在反复重复上述的步骤后可能会出现两种情况：
  - 找到一个可能存在的正确答案
  - 在尝试了所有可能的分步方法后宣告该问题没有答案
- 最坏的情况下，回溯法会导致一次时间复杂度为指数时间的计算。

##### 参考链接

- [AlphaZero Explained](https://nikcheerla.github.io/deeplearningschool/2018/01/01/AlphaZero-Explained/)
- [棋类复杂度](https://en.wikipedia.org/wiki/Game_complexity)
- [BFS 代码模板](https://shimo.im/docs/ZBghMEZWix0Lc2jQ)
- [DFS 代码模板](https://shimo.im/docs/UdY2UUKtliYXmk8t)
  
##### 实战题目

- [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
- [括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
- [N皇后](https://leetcode-cn.com/problems/n-queens/)
- [有效的数独](https://leetcode-cn.com/problems/valid-sudoku/description/)
- [解数独](https://leetcode-cn.com/problems/sudoku-solver/#/description)
  
#### 双向BFS

##### 实战题目

- [单词接龙](https://leetcode-cn.com/problems/word-ladder/)
- [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/)
  
##### 代码模版

```python
def BFS(graph, start, end): 
    startQueue = [] 
    startQueue.append([start]) 
    endQueue = []
    endQueue.append(end)
    visited = set()
    visited.add(start) 
    visited.add(end)
    while startQueue: 
        nextQueue = []
        node = startQueue.pop() 
        process(node) 
        nodes = generate_related_nodes(node) 
        if nodes not in visited:
            visited.add(nodes)
            nextQueue.push(nodes) 
        # other processing work 
        # ...
        startQueue = nextQueue
        if len(startQueue) > len(nextQueue):
           startQueue, nextQueue = nextQueue, startQueue
```      

#### 启发式搜索（A*）

##### 参考链接

- [A* 代码模板](https://shimo.im/docs/8CzMlrcvbWwFXA8r)
- [相似度测量方法](https://dataaspirant.com/2015/04/11/five-most-popular-similarity-measures-implementation-in-python/)
- [二进制矩阵中的最短路径的 A* 解法](https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/313347/A*-search-in-Python)
- [8 puzzles 解法比较](https://zxi.mytechroad.com/blog/searching/8-puzzles-bidirectional-astar-vs-bidirectional-bfs/)

##### 实战题目

- [二进制矩阵中的最短路径](https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/)
- [滑动谜题](https://leetcode-cn.com/problems/sliding-puzzle/)
- [解数独](https://leetcode-cn.com/problems/sudoku-solver/)
       
### 汇总

- [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/) X
- [实现 Trie](https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/)
- [朋友圈](https://leetcode-cn.com/problems/friend-circles)
- [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) X
- [被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/) X
- [有效的数独](https://leetcode-cn.com/problems/valid-sudoku/description/) 
- [括号生成](https://leetcode-cn.com/problems/generate-parentheses/) X
- [单词接龙](https://leetcode-cn.com/problems/word-ladder/)
- [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/)
- [单词搜索 II](https://leetcode-cn.com/problems/word-search-ii/)
- [N皇后](https://leetcode-cn.com/problems/n-queens/) 
- [解数独](https://leetcode-cn.com/problems/sudoku-solver/#/description) X
- [二进制矩阵中的最短路径](https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/) X
- [滑动谜题](https://leetcode-cn.com/problems/sliding-puzzle/) X
 