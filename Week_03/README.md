## 递归

递归是在一个函数内部调用这个函数自身。而循环则是通过设置计算的初始值及终止条件，在一个范围内重复运算。

通常基于递归实现的代码比基于循环实现的代码要简洁很多，更加容易实现。

递归虽有简洁的优点，但它也有显著的缺点。递归由于是函数调用自身，而函数调用是有时间和空间消耗的：
每一次函数调用都要在内存栈中分配空间以保存参数，返回地址及临时变量，而往栈中压入数据和弹出数据都需要时间。

递归中有可能很多计算都是重复的，从而对性能带来很大的负面影响。
递归的本质是把一个大问题分解为一个或多个更多的小问题。
如果多个小问题存在相互重叠的部分，就存在重复的计算。

通常用动态规划解决问题时我们都是用递归的思路分析问题，但由于递归分解的子问题中存在大量的重复，
因此我们总是用记忆化的方式或自下而上的循环♻️来实现代码。

除了效率之外，递归还有可能引起更严重的问题：调用栈溢出。
前面分析中提到需要为每一次函数调用在内存栈中分配空间，而每个进程的栈的容量是有限的。
当递归调用的层级太多时，就会超出栈的容量，从而导致调用栈溢出。

### 盗梦空间

- 向下进入到不同梦境中；向上又回到原来一层
- 通过声音同步回到上一层
- 每一层的环境和周围的人都是一份拷贝、 主角等几个人穿越不同层级的梦境（发生和携带变化）

### 例1：计算 n!

```python

def Factorial(n): 
    if n <= 1: 
        return 1
    return n * Factorial(n — 1)

```

```java
factorial(6)
6 * factorial(5)
6 * (5 * factorial(4))
6 * (5 * (4 * factorial(3)))
6 * (5 * (4 * (3 * factorial(2))))
6 * (5 * (4 * (3 * (2 * factorial(1)))))
6 * (5 * (4 * (3 * (2 * 1))))
6 * (5 * (4 * (3 * 2)))
6 * (5 * (4 * 6))
6 * (5 * 24)
6 * 120
720
```
### 代码模版

```python

def recur(level, param1, param2, ...): 
    # recursion terminator 
    if level > MAX_LEVEL: 
        # process_result 
        return
    # process logic in current level 
    process(level, data...) 
    # drill down 
    self.recur(level + 1, p1, ...) 
    # reverse the current level status if needed

```

```java
public void recur(int level, int param) {
    // terminator 
    if (level > MAX_LEVEL) {
         // process result 
         return; 
    }
    // process current logic 
    process(level, param);
    // drill down 
    recur( level: level + 1, newParam);
    // restore current status 
}
```

### 思维要点

1. 不要人肉进行递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

### 实战题目

- [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
- [括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
- [翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)
- [验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree)
- [二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree)
- [二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree)
- [二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)
- [二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
- [从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal)
- [组合](https://leetcode-cn.com/problems/combinations/)
- [全排列](https://leetcode-cn.com/problems/permutations/)
- [全排列 II ](https://leetcode-cn.com/problems/permutations-ii/)

## 分治（divide & conquer）

归并排序就是典型的分治。

```python
def divide_conquer(problem, param1, param2, ...): 
    # recursion terminator 
    if problem is None: 
    # print_result 
    return
    # prepare data 
    data = prepare_data(problem) 
    subproblems = split_problem(problem, data) 
    # conquer subproblems 
    subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
    subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
    subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
    # ...
    # process and generate the final result 
    result = process_result(subresult1, subresult2, subresult3, …) 
    # revert the current level states
```

## 回溯

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程
中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将
取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问
题的答案。

回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种
情况：

- 找到一个可能存在的正确的答案
- 在尝试了所有可能的分步方法后宣告该问题没有答案

在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

### 实战题目

- [括号生成问题](https://leetcode-cn.com/problems/generate-parentheses/)
- [Pow(x, n) ](https://leetcode-cn.com/problems/powx-n/)
- [子集](https://leetcode-cn.com/problems/subsets/)
- [多数元素](https://leetcode-cn.com/problems/majority-element/description/)
- [电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)
- [N 皇后](https://leetcode-cn.com/problems/n-queens/)

### 参考链接

- [分治代码模板](https://shimo.im/docs/zvlDqLLMFvcAF79A/)
- [牛顿迭代法原理](http://www.matrix67.com/blog/archives/361)
- [牛顿迭代法代码](http://www.voidcn.com/article/p-eudisdmk-zm.html)

# 持续刷题

- [复原IP地址](https://leetcode-cn.com/problems/restore-ip-addresses/)
- [24 点游戏](https://leetcode-cn.com/problems/24-game/)
- [**递增子序列**](https://leetcode-cn.com/problems/increasing-subsequences/)
- [第k个排列](https://leetcode-cn.com/problems/permutation-sequence/)