# 数组、链表、跳表

| 数据结构 | 时间    |         |         |      |      |      | 空间      | 特性                     |
| -------- | :------ | ------- | ------- | ---- | ---- | ---- | :-------- | :----------------------- |
|          | 平均    |         |         | 最差 |      |      | 最差      |                          |
|          | 访问    | 插入    | 删除    | 访问 | 插入 | 删除 |           |                          |
| 数组     | O(1)    | O(n)    | O(n)    | O(1) | O(n) | O(n) | O(n)      | 在内存中占据连续空间     |
| 链表     | O(n)    | O(1)    | O(1)    | O(n) | O(1) | O(1) | O(n)      | 一个节点指向另外一个节点 |
| 跳表     | O(logn) | O(logn) | O(logn) | O(n) | O(n) | O(n) | O(n logn) | 建立了logn -1级的索引    |
| 栈       | O(n)    | O(1)    | O(1)    | O(n) | O(1) | O(1) | O(n)      | 后进先出                 |
| 队列     | O(n)    | O(1)    | O(1)    | O(n) | O(1) | O(1) | O(n)      | 先进先出                 |

## 跳表

**跳表只能用于元素有序的情况**

跳表对标的是平衡树和二分查找，插入、删除、查询操作都是O(logn)的数据结构。1989年出现。

最大的优势是原理简单、容易实现、方便扩展、效率更高。因此在一些热门的项目里用来代替平衡树，
如Redis、LevelDB等。

跳表的空间复杂度是O(n)。使用升维思想，用空间换时间。

## 工程应用

LRU Cache - LinkedList
- [LRU缓存算法](https://www.jianshu.com/p/b1ab4a170c3c)
- [LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/)

Redis - Skip List
- [为啥 redis 使用跳表(skip list)而不是使用 red-black？](https://www.zhihu.com/question/20202931)
- [跳跃表](https://redisbook.readthedocs.io/en/latest/internal-datastruct/skiplist.html)

这一周使用了切题四件套和五毒神掌刷了12道算法题。

其中盛水最多的容器，接雨水，柱状图中的最大矩形，三数之和花的时间占比最多。

接雨水的双指针解法与栈解法以及柱状图中的最大矩形的栈解法令我印象深刻。

爬楼梯这道题目虽然简单，其中的坑在于存在着大量的子问题的重复计算，可以通过做缓存或自下而上的循环来避免这样重复计算。

最小栈和滑动窗口的最大值提供了实现栈的最小值，最大值，队列的最小值，最大值的一个思路。

移动零的解题思路和Partition函数挺像的，都是用一个j指针来记录下一个目标元素要插入的位置，该指针将数组分成两个部分。

链表的练习题目和源码分析未能完成，下周努力给补上。

#### 实战题目

- [盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)
- [移动零](https://leetcode-cn.com/problems/move-zeroes/)
- [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
- [使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/)
- [两数之和](https://leetcode-cn.com/problems/two-sum/)
     两数之和与回文对这道题目有些相似的地方。暴力法都是枚举两个元素，然后判断两个元素是否满足条件。
     加速的方法则是根据遍历到的元素a去查找符合条件的元素b，在查找b时使用一些数据结构进行加速如trie树和哈希表
- [三数之和](https://leetcode-cn.com/problems/3sum/)
- [删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
- [旋转数组](https://leetcode-cn.com/problems/rotate-array/)
- [加一](https://leetcode-cn.com/problems/plus-one/)

- [反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)
- [两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)
- [环形链表](https://leetcode.com/problems/linked-list-cycle)
- [环形链表 II](https://leetcode.com/problems/linked-list-cycle-ii)
- [K 个一组翻转链表](https://leetcode.com/problems/reverse-nodes-in-k-group/)
- [合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
- [合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

- [有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)
- [最小栈](https://leetcode-cn.com/problems/min-stack/)
- [柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram)
- [滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum)
- [设计循环双端队列](https://leetcode.com/problems/design-circular-deque)
- [接雨水](https://leetcode.com/problems/trapping-rain-water/)
- 用 add first 或 add last 这套新的 API 改写 Deque 的代码
- 分析 Queue 和 Priority Queue 的源码

- [最小区间](https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/) 堆解法+滑动窗口解法

#### 参考链接

- [Java 源码分析（ArrayList）](http://developer.classpath.org/doc/java/util/ArrayList-source.html) 
- [Linked List 的标准实现代码](http://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/) 
- [Linked List 示例代码](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java) 
- [Java 源码分析（LinkedList）](http://developer.classpath.org/doc/java/util/LinkedList-source.html) 

- [Java 的 PriorityQueue 文档](http://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html) 
- [Java 的 Stack 源码](http://developer.classpath.org/doc/java/util/Stack-source.html) 
- [Java 的 Queue 源码](http://fuseyism.com/classpath/doc/java/util/Queue-source.html) 
- [Python 的 heapq](http://docs.python.org/2/library/heapq.html) 
- [高性能的 container 库](http://docs.python.org/2/library/collections.html) 

# 持续刷题

- [计数二进制子串](https://leetcode-cn.com/problems/count-binary-substrings)
