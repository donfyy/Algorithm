## 位运算

### 位运算符

- 按位与(&) 0011 & 1011 -> 0011
- 按位或(|) 0011 | 1011 -> 1011
- 按位取反(~) ~0011 -> 1100
- 按位异或(^) 0011 ^ 1011 -> 1000
  - x ^ 0 = x
  - x ^ 1s = ~x
  - x ^ (~x) = 1s
  - x ^ x = 0
  - c = a ^ b => b = a ^ c, a = b ^ c 
  - a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c
- 指定位置的位运算
  - 将x最右边的n位清零：x & (~0 << n)
  - 获取x的第n位值（0或者1）：(x >> n) & 1
  - 获取x的第n位的幂值：x & (1 << n)
  - 仅将第n位置为1：x | (1 << n) 
  - 仅将第n位置为0：x & (~(1 << n))
  - 将x最高位至第n位（含）清零：x & ((1<<n) - 1)
- 实战位运算要点
  - 判断奇偶
    - x % 2 == 1 -> (x & 1) == 1
    - x % 2 == 0 -> (x & 1) == 0
    - 使用java或高级语言的话，编译器足够智能，写成%的话也会被编译成&操作
    - 没有啊。。。我看生成的字节码使用%的话使用的是irem指令还是取模运算啊。
  - x >> 1 -> x / 2 即： x = x / 2; -> x = x >> 1 . mid = (left + right) / 2; -> mid = (left + right) >> 1;
  - x = x & (x - 1) 清零最低位的1 : 100 & 011 -> 000 101 & 100 -> 100
  - x & -x 得到最低位的1 : 100 & 100 -> 100 011 & 101 -> 001
  - x & ~x -> 0
  
### 参考链接

- [如何从十进制转换为二进制](https://zh.wikihow.com/%E4%BB%8E%E5%8D%81%E8%BF%9B%E5%88%B6%E8%BD%AC%E6%8D%A2%E4%B8%BA%E4%BA%8C%E8%BF%9B%E5%88%B6)
- [N 皇后位运算代码示例](https://shimo.im/docs/YzWa5ZZrZPYWahK2)
  
### 实战题目

- [位 1 的个数](https://leetcode-cn.com/problems/number-of-1-bits/)
- [2 的幂](https://leetcode-cn.com/problems/power-of-two/)
- [颠倒二进制位](https://leetcode-cn.com/problems/reverse-bits/)
- [N 皇后](https://leetcode-cn.com/problems/n-queens/description/)
- [N 皇后 II](https://leetcode-cn.com/problems/n-queens-ii/description/)
- [比特位计数](https://leetcode-cn.com/problems/counting-bits/description/)
  
### 持续刷题

- [数字范围按位与](https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/)

  将范围内所有数字的按位与转换成求范围内所有数字的公共前缀
    
- [汉明距离](https://leetcode-cn.com/problems/hamming-distance/)

## 布隆过滤器

- 和哈希表类似。只需要知道某个元素有或没有
- 一个很长的**二进制**向量和一系列**随机映射函数**。用于检索一个元素是否存在一个集合中
  - 将每个元素映射到一组二进制位索引，所以对于某个元素如果对应的一组二进制位索引都为1则该元素可能存在，否则该元素一定不存在。
- 优点：空间效率和查询时间都远远超过一般的算法
- 缺点：有一定的误识别率和删除困难
- 应用：放在最外面当作一个缓存使用，挡在机器前面的快速查询的缓存。
- 案例
  - 比特币网络
  - 分布式系统（Map-Reduce）-Hadoop search engine
  - Redis缓存
  - 垃圾邮件，评论等的过滤
- Python 的实现 bitarray 
  - 哈希算法： hash(element, seed) % array.size
  
### 参考链接

- [布隆过滤器的原理和实现](https://www.cnblogs.com/cpselvis/p/6265825.html)
- [使用布隆过滤器解决缓存击穿、垃圾邮件识别、集合判重](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877)
- [布隆过滤器 Python 代码示例](https://shimo.im/docs/UITYMj1eK88JCJTH)
- [布隆过滤器 Python 实现示例](https://www.geeksforgeeks.org/bloom-filters-introduction-and-python-implementation/)
- [高性能布隆过滤器 Python 实现示例](https://github.com/jhgg/pybloof)
- [布隆过滤器 Java 实现示例 1](https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java)
- [布隆过滤器 Java 实现示例 2](https://github.com/Baqend/Orestes-Bloomfilter)
  
## LRU缓存

  - xxx
  
### 参考链接

  - [Understanding the Meltdown exploit](https://www.sqlpassion.at/archive/2018/01/06/understanding-the-meltdown-exploit-in-my-own-simple-words/)
  - [替换算法总揽](https://en.wikipedia.org/wiki/Cache_replacement_policies)
  - [LRU Cache Python 代码示例](https://shimo.im/docs/CoyPAyXooGcDuLQo)
  
### 实战题目
  - [LRU 缓存机制](https://leetcode-cn.com/problems/lru-cache/#/)
  
## 排序算法

|排序方法|时间复杂度(平均)|时间复杂度(最坏)|时间复杂度(最好)|空间复杂度|稳定性  |
|-------|:------------:|:------------:|:------------:|:-------:|------:|
|插入排序|O(n^2)        |O(n^2)        |O(n^2)        |O(1)     |稳定    |
|希尔排序|O(n^1.3)      |O(n^2)        |O(n)          |O(1)     |不稳定  |
|选择排序|O(n^2)        |O(n^2)        |O(n^2)        |O(1)     |不稳定    |
|冒泡排序|O(n^2)        |O(n^2)        |O(n)          |O(1)     |稳定    |
|**快速排序**|O(nlogn)      |O(n^2)        |O(n)          |O(logn) |不稳定    |
|**堆排序** |O(nlogn)      |O(nlogn)      |O(nlogn)      |O(1)     |不稳定    |
|**归并排序**|O(nlogn)      |O(nlogn)      |O(nlogn)      |O(n)     |稳定    |
|       |              |              |              |         |       |
|计数排序|O(n+k)        |O(n+k)        |O(n+k)        |O(n+k)   |稳定    |
|桶排序  |O(n+k)        |O(n^2)        |O(n)          |O(n+k)   |稳定    |
|基数排序|O(n\*k)        |O(n\*k)      |O(n\*k)        |O(n\*k)   |稳定    |

### 比较类排序

通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn),因此也称为非线性时间比较类排序。
  
#### 交换排序

##### 冒泡排序:嵌套循环，每次查看相邻的元素如果逆序，则交换。

```java
public static void bubbleSort(int[] array) {
    for (int i = array.length - 1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}
```
##### 快速排序

从数组中选取一个枢纽pivot，将小元素放在pivot的左边，将大元素放在pivot的右边，然后对pivot左边的数组和pivot右边的数组执行同样的操作。

```java    
public static void quickSort(int[] array, int begin, int end) {
    if (begin >= end) {
       return;
    }
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}

public static int partition(int[] array, int begin, int end) {
    int pivot = end;
    int j = begin - 1;
    for (int i = begin; i < end; i++) {
        if (array[i] < array[pivot]) {
            swap(array, i, ++j);
        }
    }
    swap(array, ++j, pivot);
    return j;
}

public static void swap(int[] array, int i, int j) {
    if (i != j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
```
#### 插入排序

从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

##### 简单插入排序
```java
public static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
        int value = array[i];
        int j = i - 1;
        while (j >= 0 && array[j] > value) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = value;
    }
}
```
##### 希尔排序

是简单插入排序的改进版。
与简单插入排序的不同之处在于，会优先比较距离较远的元素。
又叫缩小增量排序。希尔排序的核心在于间隔序列的设定。
既可以提前设定好间隔序列，也可以动态的定义间隔序列。

```java
public static void shellSort(int[] array) {
     for (int gap = array.length >>> 1; gap > 0; gap >>>= 1) {
         for (int i = gap; i < array.length; i++) {
             int j = i - gap;
             int value = array[i];
             while (j >= 0 && array[j] > value) {
                 array[j + gap] = array[j];
                 j -= gap;
             }
             array[j + gap] = value;
         }
     }
}
```
#### 选择排序

##### 简单选择排序:不断地将未排序序列的最小值放到未排序序列的起始位置。

```java
public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
        int min = i;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[min]) {
                min = j;
            }
        }

        if (min != i) {
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }
}
```
##### 堆排序 - 插入删除O(logn),取最大最小值O(1)
  
  1.遍历数组建立小顶堆
  
  2.依次取出堆顶元素，并删除
  
```java
//时间O(nlogn) 空间O(n)
public static void heapSort(int[] array) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(array.length);
    for (int i = 0; i < array.length; i++) {
        priorityQueue.offer(array[i]);
    }
    for (int i = 0; i < array.length; i++) {
        array[i] = priorityQueue.poll();
    }
}
```
[手动维护堆的版本](https://github.com/donfyy/algorithm009-class01/blob/master/Week_08/java/src/HeapSort.java)

#### 归并排序-分治

##### 二路归并排序

1. 把长度为n的输入序列分成两个长度为n/2的子序列
2. 对两个子序列分别采用归并排序
3. 将两个排序好的子序列合并为一个排序序列
  
```java
public static void mergeSort(int[] array) {
    mergeSort(array, new int[array.length], 0, array.length - 1);
}

public static void mergeSort(int[] array, int[] temp, int left, int right) {
    if (left >= right) {
        return;
    }

    int mid = left + ((right - left) >> 1);
    mergeSort(array, temp, left, mid);
    mergeSort(array, temp, mid + 1, right);
    merge(array, temp, left, mid, right);
}

private static void merge(int[] array, int[] temp, int left, int mid, int right) {
    int i = left, j = mid + 1, k = left;
    while (i <= mid && j <= right) {
        temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
    }
    while (i <= mid) {
        temp[k++] = array[i++];
    }
    while (j <= right) {
        temp[k++] = array[j++];
    }
    System.arraycopy(temp, left, array, left, right - left + 1);
}
```
##### 多路归并排序

#### 与快排的比较

- 归并与快排具有相似性，但步骤顺序相反
  - 归并：先排序左右子数组，然后合并两个有序子数组
  - 快排：先调配出左右子数组，然后对左右子数组进行排序
- 快排在分解到最下层的时候就排序完成了，而归并在回归到最上层的时候才排序完成。
递归分为两个过程，自顶向下分解与自底向上回归。
快排在自顶向下分解时就在排序，而归并在自底向上回归时排序。
快排类似与树的前序遍历，归并类似于树的后序遍历。
      
### 非比较类排序

- 不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。
- 一般来说只能用于整型类型的排序，一般用额外的辅助空间。

#### 计数排序

将输入的数据值转化为键值存储在额外开辟的数组中。
作为一种线性时间复杂度的排序，计数排序要求输入的数据是有确定范围的整数。
当k不是很大且序列比较集中时，计数排序是一个很有效的排序算法。

```c++
void countingSort(vector<int> &nums)
{
    // 注意，修改nums的元素, *pmax是动态变化的
    const auto [pmin, pmax] = minmax_element(nums.begin(), nums.end());
    int min = *pmin, max = *pmax;
    vector<int> bucket(max - min + 1, 0);
    for (int num : nums) {
        bucket[num - min]++;
    }
    int j = 0;
    for (int i = min; i <= max; i++) {
        int cnt = bucket[i - min];
        while (cnt-- > 0) {
            nums[j++] = i;
        }
    }
}
```
#### 桶排序

桶排序是计数排序的升级版。
它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶在分别排序。

```c++
void bucketSort(vector<int> &nums)
{
    // 注意，修改nums的元素, *pmax是动态变化的
    const auto [pmin, pmax] = minmax_element(nums.begin(), nums.end());
    const int min = *pmin, max = *pmax;
    const int bucketSize = 3, bucketCount = (max - min) / bucketSize + 1;
    // 创建桶
    vector<vector<int>> buckets(bucketCount, vector<int>());
    // 将元素映射到桶中
    for (int num : nums) {
        buckets[(num - min) / bucketSize].push_back(num);
    }
    // 对每一个桶中的元素进行排序，然后取出桶中的元素
    for (int i = 0, j = 0; i < bucketCount; i++) {
        auto bucket = buckets[i];
        sort(bucket.begin(), bucket.end());
        for (int v : bucket) {
            nums[j++] = v;
        }
    }
}
```

#### 基数排序

按照低位先排序，然后收集；再按高位排序，然后再收集；依此类推，直到最高位。
有些时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。
最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
基数排序的性能比桶排序要略差，每一次关键字的桶分配都需要O(n)的时间复杂度，而且分配后得到的新的关键字序列又需要(n)的时间复杂度。
假如待排序序列可以分为d个关键字，则基数排序的时间复杂度将是O(d * 2n)，d远远小于n，因此时间复杂度还是线性级别。
空间复杂度为O(n+k),其中k为桶的数量。

```java
public static void radixSort(int[] array) {
    //找到最大元素
    int max = findMaxValue(array);
    //找到最高位
    int maxDigit = 0;
    while (max > 0) {
        max /= 10;
        maxDigit++;
    }
    //对每一位进行计数排序
    LinkedList[] bucket = new LinkedList[10];
    for (int i = 0; i < bucket.length; i++) {
        bucket[i] = new LinkedList();
    }
    for (int digit = 0, dev = 1, mod = 10; digit < maxDigit; digit++, mod *= 10, dev *= 10) {
        //将元素放到对应的桶中
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = array[i] % mod / dev;
            bucket[bucketIndex].offer(array[i]);
        }
        //再从桶中将元素恢复到数组里
        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            LinkedList list = bucket[i];
            while (!list.isEmpty()) {
                array[k++] = (int) list.poll();
            }
        }
    }
}
```

- 数组prepend操作的优化：多申请一些内存，然后在数组的开始预留一部分空间，prepend操作则是把头下标向前移动一位。

### 参考链接

- [十大经典排序算法](https://www.cnblogs.com/onepixel/p/7674659.html)
- [9 种经典排序算法可视化动画](https://www.bilibili.com/video/av25136272)
- [6 分钟看完 15 种排序算法动画展示](https://www.bilibili.com/video/av63851336)
- [快速排序代码示例](https://shimo.im/docs/TX9bDbSC7C0CR5XO)
- [归并排序代码示例](https://shimo.im/docs/sDXxjjiKf3gLVVAU)
- [堆排序代码示例](https://shimo.im/docs/M2xfacKvwzAykhz6)
  
### 实战题目

- [数组的相对排序](https://leetcode-cn.com/problems/relative-sort-array/)
- [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)
- [力扣排行榜](https://leetcode-cn.com/problems/design-a-leaderboard/)
- [合并区间](https://leetcode-cn.com/problems/merge-intervals/)
- [翻转对](https://leetcode-cn.com/problems/reverse-pairs/)
- [计算右侧小于当前元素的个数](https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/)
