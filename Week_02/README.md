

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





## 哈希表

- 哈希表将键值映射到表中一个位置，这种映射由映射函数或散列函数来完成。
  不同的键值可能映射到相同的位置，这种情况被称为哈希冲突，产生冲突的元素通常用链表保存起来。
  不同的哈希表实现对此有不同的处理，比如说HashMap，HashMap将冲突的元素先用链表保存起来，
  当元素的数量超过8个后，再将链表转换成红黑树。
  再比如说ThreadLocalMap，ThreadLocalMap将冲突的元素顺延至数组中下一个为空的位置。
- 当我们在分析问题的时候，如果遇到类似字符出现的次数，元素出现的频率这种特点的时候，我们应当想到哈希表这种结构。
- 相关的练习题目包括：有效的字母异位词，字母异位词分组，前k个高频元素

### 工程实践

- 电话号码簿
- 用户信息表
- 缓存（LRU Cache）
- 键值对存储（Redis）

### 实战题目

- [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/)
- [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)
- [两数之和](https://leetcode-cn.com/problems/two-sum/description/)

### 参考链接

- [养成收藏精选代码的习惯（示例）](http://shimo.im/docs/R6g9WJV89QkHrDhr)

## 树

### 多叉树
- dfs
  - 前序
  - 后序
- bfs
### 二叉树

#### 遍历

- dfs
  - 前序：根左右
  - 中序：左根右
  - 后序：左右根
- bfs

#### 二叉搜索树

- 左子树所有节点小于根节点
- 右子树所有节点大于根节点
- 左右子树也分别为二叉搜索树
- 保证性能的关键
  - 保证二维维度 左右子树也是节点平衡的
  - https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree
    
#### AVL树

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
  
#### 红黑树

- 是一种近似平衡的二叉搜索树，它能够确保任何一个节点左右子树的高度差小于两倍。
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
  
#### AVL树和红黑树的比较
- 查询：AVL树的查询速度快于红黑树，因为AVL树是严格平衡的而红黑树是近似平衡
- 插入和删除：红黑树的插入和删除速度更快，原因同上，红黑树的调整次数相对较少
- 存储：AVL树需要1个int来保存节点的平衡因子而红黑树只要1个bit来区分节点的颜色
- 应用：红黑树多用在语言的库函数里（C++的map，multimap，multset，java的HashMap）而AVL树多用在数据库中，因为数据库的读操作相对与写操作更频繁 


- 树的解法多是递归的原因，是因为从根节点到子节点的过程和函数调用的过程一样，并且根节点和子节点的处理逻辑是一致的，所以不停的调用自己，这也就是递归。
- 相关的练习题目包括：二叉树的前序，中序，后序及N叉树的前序后序的递归及循环解法。

#### 实战题目

- [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)
- [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
- [二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)
- [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
- [N 叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)
- [N 叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/)
- [N 叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

#### 参考链接

- [二叉搜索树Demo](https://visualgo.net/zh/bst?slide=1)
- [平衡树](https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree)

### 堆

用O(1)的时间取出最大值或最小值。插入删除的时间复杂度不超过O(logn)。

#### 常见的实现

##### 二叉堆
- 是一颗完全二叉树
- 树中任意节点的值总是大于等于子节点的值
- 实现细节
  - 使用数组作为容器
  - 假设堆顶元素位于索引0处，则
    - i处的左子节点的索引为 (i<<1)+1
    - i处的右子节点的索引为 (i<<1)+2
    - i处的父节点的索引 (i - 1) >>> 1
  - 插入：新元素插入堆的尾部，然后将新元素依次上浮，也就是向上调整堆的结构
  - 删除：将堆尾元素置于被删除元素处，然后将堆尾元素依次下沉，也就是向下调整堆的结构
- 二叉堆是一种常见且简单的实现，但不是最优的实现。PriorityQueue的实现就是一个二叉堆。

##### 严格的斐波那契堆

在堆的各种实现中性能最好，只有删除堆顶元素的时间为O(logn)其余皆为O(1)。

#### 实战题目

- [最小的 k 个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)
- [滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)
- [HeapSort](https://www.geeksforgeeks.org/heap-sort/)
- [丑数](https://leetcode-cn.com/problems/ugly-number-ii/)
- [前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)

#### 参考链接

- [维基百科：堆（Heap）](https://en.wikipedia.org/wiki/Heap_(data_structure))
- [堆的实现代码](https://shimo.im/docs/Lw86vJzOGOMpWZz2/)

### 图

由点和边组成，点有入度和出度，点与点之间是否连通。边分为有向和无向，边长可以带有权重。

- 无向无权图
- 有向无权图
- 无向有权图
- 有向有权图？

#### 二分图

如果能将一个图的节点集合分割成两个独立的子集，并使图中每一条边的两个节点分别来自两个独立的子集，则称该图为二分图。

#### 欧拉回路 / 欧拉通路

- 通过图中所有边恰好一次且行遍所有顶点的通路称为欧拉通路
- 通过图中所有边恰好一次且行遍所有顶点的回路称为欧拉回路
- 具有欧拉回路的无向图称为欧拉图
- 具有欧拉通路但不具有欧拉回路的无向图称为半欧拉图

#### 实战题目

- [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
- [判断二分图](https://leetcode-cn.com/problems/is-graph-bipartite/)
- [矩阵中的最长递增路径](https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/)
- [重新安排行程](https://leetcode-cn.com/problems/reconstruct-itinerary/)
- [破解保险箱](https://leetcode-cn.com/problems/cracking-the-safe/)

#### 参考链接

- [二分图详解](https://zhuanlan.zhihu.com/p/89972891)
- [拓扑排序](https://zhuanlan.zhihu.com/p/34871092)
- [最短路径](https://www.bilibili.com/video/av25829980?from=search&seid=13391343514095937158)
- [最小生成树](https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051)
  
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

# 持续刷题

- [课程表](https://leetcode-cn.com/problems/course-schedule/)
- [恢复二叉搜索树](https://leetcode-cn.com/problems/recover-binary-search-tree/)
- [二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
- [不同的二叉搜索树II](https://leetcode-cn.com/problems/unique-binary-search-trees-ii/)
  - [参考题解](https://leetcode.wang/leetCode-95-Unique-Binary-Search-TreesII.html#%E8%A7%A3%E6%B3%95%E4%B8%89-%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92)
- [二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)
- [二叉树的层平均值](https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/)
- [左叶子之和](https://leetcode-cn.com/problems/sum-of-left-leaves/)
- [把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/)
- [合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees/)

