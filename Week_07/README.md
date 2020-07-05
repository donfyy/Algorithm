学习笔记


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





重要知识点回顾

- 哈希表
  - 哈希表将键值映射到表中一个位置，这种映射由映射函数或散列函数来完成。不同的键值可能映射到相同的位置，这种情况被称为哈希冲突，产生冲突的元素通常用链表保存起来。不同的哈希表实现对此有不同的处理，比如说HashMap，HashMap将冲突的元素先用链表保存起来，当元素的数量超过8个后，再将链表转换成红黑树。再比如说ThreadLocalMap，ThreadLocalMap将冲突的元素顺延至数组中下一个为空的位置。
  - 当我们在分析问题的时候，如果遇到类似字符出现的次数，元素出现的频率这种特点的时候，我们应当想到哈希表这种结构。
  - 相关的练习题目包括：有效的字母异位词，字母异位词分组，前k个高频元素
- 树
  - 多叉树
    - dfs
      - 前序
      - 后序
    - bfs
  - 二叉树
    - 二叉搜索树
      - 左子树所有节点小于根节点
      - 右子树所有节点大于根节点
      - 左右子树也分别为二叉搜索树
      - 保证性能的关键
        - 保证二维维度 左右子树也是节点平衡的
        - https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree
    - AVL树
      - 发明家G.M.Adelson-Velsky和Evgenii Landis
      - 任意节点的左右子树的深度之差不会超过1
      - Balance Factor (平衡因子) {-1, 0, 1} : 左子树的高度减去右子树的高度（有时相反）
      - 通过旋转操作来进行平衡
        - 左左子树 -> 右旋
        - 左右子树 -> 左右旋
        - 右右子树 -> 左旋
        - 右左子树 -> 右左旋
        - https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree
      - 总结
        - 平衡二叉搜索树
        - 每个节点存放 balance factor = {-1, 0, 1}
        - 四种旋转操作
        - 不足：需要一个int来存储平衡因子，且调整次数频繁
    - 红黑树
      - 是一种近似平衡的二叉搜索树，它能够确保任何一个节点的高度差小于两倍。
      - 5个性质
        - 节点要么是黑色，要么是红色
        - 根节点是黑色
        - 叶子节点(空节点)为黑色
        - 红节点的两个子节点为黑色(不能有两个邻接的红色节点)
        - 树中任一节点到其每个叶子节点的所有路径都包含相同数量的黑色节点
      - 关键性质
        - 从根节点到叶子节点的最长路径不会多于最短路径的两倍长
      - 两种关键操作
        - 左旋：将支点的右子节点置为支点的父节点，支点变为右子节点的左子节点，右子节点的左子节点变为支点的右子节点。
        - 右旋：将支点的左子节点置为支点的父节点，支点变为左子节点的右子节点，左子节点的右子节点变为支点的左子节点。
    - AVL树和红黑树的比较
      - 查询：AVL树的查询速度快于红黑树，因为AVL树是严格平衡的而红黑树是近似平衡
      - 插入和删除：红黑树的插入和删除速度更快，原因同上，红黑树的调整次数相对较少
      - 存储：AVL树需要1个int来保存节点的平衡因子而红黑树只要1个bit来区分节点的颜色
      - 应用：红黑树多用在语言的库函数里（C++的map，multimap，multset，java的HashMap）而红黑树多用在数据库中，因为数据库的读操作相对与写操作更频繁 
    - dfs
      - 前序：根左右
      - 中序：左根右
      - 后序：左右根
    - bfs
  - 树的解法多是递归的原因，是因为从根节点到子节点的过程和函数调用的过程一样，并且根节点和子节点的处理逻辑是一致的，所以不停的调用自己，这也就是递归。
  - 相关的练习题目包括：二叉树的前序，中序，后序及N叉树的前序后序的递归及循环解法。
- 堆：用O(1)的时间取出最大值或最小值。插入删除的时间复杂度不超过O(logn)。
  - 常见的实现
    - 二叉堆
      - 是一颗完全二叉树
      - 树中任意节点的值总是大于等于子节点的值
      - 实现细节
        - 使用数组作为容器
        - 假设堆顶元素位于索引0处，则
          - i处的左子节点的索引为 i<<1+1
          - i处的右子节点的索引为 i<<1+2
          - i处的父节点的索引 i >>> 1
        - 插入：新元素插入堆的尾部，然后将新元素依次上浮，也就是向上调整堆的结构
        - 删除：将堆尾元素置于被删除元素处，然后将堆尾元素依次下沉，也就是向下调整堆的结构
      - 二叉堆是一种常见且简单的实现，但不是最优的实现。PriorityQueue的实现就是一个二叉堆。
    - 严格的斐波那契堆，在堆的各种实现中性能最好，只有删除堆顶元素的时间为O(logn)其余皆为O(1)。
  - 相关的题目包括：前k个高频元素，滑动窗口的最大值，最小的k个数。
- 图：由点和边组成，点有入度和出度，点与点之间是否连通。边分为有向和无向，边长可以带有权重。
  - 无向无权图
  - 有向无权图
  - 无向有权图
  - 有向有权图？
- trie树
    - 又称字典书，单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎用于文本词频统计。
    - 优点是能够最大限度地减少无谓的字符串比较，查询效率比哈希表高。
    - 基本性质
        1. 节点本身不存完整单词
        2. 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串
        3. 每个节点的所有子节点路径代表的字符都不相同
    - 参考链接
      - [二叉树的层次遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
      - [实现 Trie](https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/)
      - [Tire 树代码模板](https://shimo.im/docs/DP53Y6rOwN8MTCQH)
    - 实战题目
      - [实现 Trie](https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/)
      - [单词搜索 II](https://leetcode-cn.com/problems/word-search-ii/)
      - 分析单词搜索II用Trie树实现的时间复杂度
      
- 并查集
    - 适用场景
        - 组团，配对
        - 很快的判断两个个体是不是在集合中
    - 两个人是不是同一个朋友圈？
        - 定义朋友圈类，把两个人塞到这个朋友圈里。
    - 基本操作
        - makeSet(s): 建立一个新的并查集，其中包含s个单元素集合。
        - unionSet(x, y): 把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并。
        - find(x): 找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将他们各自的代表比较一下就可以了
    - 代码模版
      - [并查集代码模版](https://shimo.im/docs/VtcxL0kyp04OBHak)
    - 实战题目
      - [朋友圈](https://leetcode-cn.com/problems/friend-circles)
      - [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
      - [被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)
- 初级搜索
  - 朴素搜索，遍历每个元素
  - 优化方式：避免重复求解（fibonacci），剪枝（括号生成）, 零钱置换
  - 搜索方向：
    - DFS
      - 递归
        ```python
        visited = set() 
        def dfs(node, visited): 
        if node in visited: # terminator 
        # already visited 
        return 
         visited.add(node) 
        # process current node here. 
        ...
        for next_node in node.children(): 
         dfs(next node, visited)
        ```
      - 循环
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
        ...
        ```
    - BFS
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
        ...
        ```
 - 高级搜索
  - 剪枝
    - 某个选择不符合条件，就不选了，也就不用下沉了。这就是剪枝
    - 回溯法
      - 回溯法采用试错的思想，尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至上几步的计算，再通过其他的可能的分步解答再次尝试寻找问题的答案。回溯法通常用最简单的递归来实现，在反复重复上述的步骤后可能会出现两种情况：
        - 找到一个可能存在的正确答案
        - 在尝试了所有可能的分步方法后宣告该问题没有答案
      - 最坏的情况下，回溯法会导致一次时间复杂度为指数时间的计算。
    - 参考链接
      - [AlphaZero Explained](https://nikcheerla.github.io/deeplearningschool/2018/01/01/AlphaZero-Explained/)
      - [棋类复杂度](https://en.wikipedia.org/wiki/Game_complexity)
    - 实战题目
      - [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
      - [括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
      - [N皇后](https://leetcode-cn.com/problems/n-queens/)
      - [有效的数独](https://leetcode-cn.com/problems/valid-sudoku/description/)
      - [解数独](https://leetcode-cn.com/problems/sudoku-solver/#/description)
  - 双向BFS
    - 实战题目
      - [单词接龙](https://leetcode-cn.com/problems/word-ladder/)
      - [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/)
    - 代码模版
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
         node = queue.pop() 
         process(node) 
         nodes = generate_related_nodes(node) 
         if nodes not in visited:
            visited.add(nodes)
            nextQueue.push(nodes) 
        # other processing work 
        ...
         startQueue = nextQueue
         if len(startQueue) > len(nextQueue):
            startQueue, nextQueue = nextQueue, startQueue
        ```      
  - 启发式搜索（A*）
    - 参考链接
      - [A* 代码模板](https://shimo.im/docs/8CzMlrcvbWwFXA8r)
      - [相似度测量方法](https://dataaspirant.com/2015/04/11/five-most-popular-similarity-measures-implementation-in-python/)
      - [二进制矩阵中的最短路径的 A* 解法](https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/313347/A*-search-in-Python)
      - [8 puzzles 解法比较](https://zxi.mytechroad.com/blog/searching/8-puzzles-bidirectional-astar-vs-bidirectional-bfs/)
    - 实战题目
      - [二进制矩阵中的最短路径](https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/)
      - [滑动谜题](https://leetcode-cn.com/problems/sliding-puzzle/)
      - [解数独](https://leetcode-cn.com/problems/sudoku-solver/)
- 作业
  - [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/) X
  - [实现 Trie](https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/)
  - [朋友圈](https://leetcode-cn.com/problems/friend-circles)
  - [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) X
  - [被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/) X
  - [有效的数独](https://leetcode-cn.com/problems/valid-sudoku/description/) X
  - [括号生成](https://leetcode-cn.com/problems/generate-parentheses/) X
  - [单词接龙](https://leetcode-cn.com/problems/word-ladder/)
  - [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/)
  - [单词搜索 II](https://leetcode-cn.com/problems/word-search-ii/)
  - [N皇后](https://leetcode-cn.com/problems/n-queens/) X
  - [解数独](https://leetcode-cn.com/problems/sudoku-solver/#/description) X
  - [二进制矩阵中的最短路径](https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/) X
  - [滑动谜题](https://leetcode-cn.com/problems/sliding-puzzle/) X
 