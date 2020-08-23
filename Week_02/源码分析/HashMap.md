HashMap的实现：数组+链表+红黑树
实现细节：数组的长度总是2的整数次方，这个特性在扩容的时候恰好将链表或红黑树一分为二。

关键成员变量：
table: Node<K, V>[] 节点存放在这个数组中，产生哈希冲突的节点先用链表保存，超出8个节点后，将链表转换成红黑树。
size: int 记录节点总数
loadFactor: float 加载因子。加载因子过大容易产生哈希冲突，加载因子太小又会导致空间利用率底。
threshold: int 扩容阈值，若插入后的size大于该阈值，则扩容数组。该阈值由加载因子和数组长度来决定。

关键成员方法：
putVal(int, K, V , boolean, boolean): V 向哈希表中插入一个节点或更新已有节点的值
removeNode(int, Object, Object, boolean, boolean): V 从哈希表中移除一个节点
getNode(int, Object): Node<K, V> 访问一个节点
resize(): Node<K, V>[] 扩容数组，在上界内总是乘2。
treeifyBin(Node<K, V>[], int): void 将int处的链表转换成红黑树。

源码分析：
```java

//该函数用于计算key的哈希码
static final int hash(Object key) {
    int h;
    //⚠️：这里并没有直接返回key.hashCode()，这么做是为了减少哈希冲突，至于原理我不懂😓
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
//put调用了putVal
public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
}
//插入
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    if ((tab = table) == null || (n = tab.length) == 0)
        // 若Node数组为null或者其长度为0则扩容数组
        n = (tab = resize()).length;
    // 将key的哈希码与上数组的长度减一得到key在数组中的索引i
    if ((p = tab[i = (n - 1) & hash]) == null)
        //若下标i处没有Node，换言之，没有产生哈希冲突，则新建一个Node，存放在i处
        tab[i] = newNode(hash, key, value, null);
    else {
        //i处存在了Node，e表示与key相同的存在表中的Node，k用来记录某个Node的key
        Node<K,V> e; K k;
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            //位于i处的Node的key与要插入的key相同
            e = p;
        else if (p instanceof TreeNode)
            //i处的Node是一个TreeNode，则执行红黑树的插入操作，并返回已存在的与key相等的TreeNode
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {
            //遍历链表
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    //在链表的尾部插入为key,value新建的Node
                    p.next = newNode(hash, key, value, null);
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        //如果链表中的节点数目超过TREEIFY_THRESHOLD(8)那么将链表转换成红黑树
                        treeifyBin(tab, hash);
                    break;
                }
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    //找到了已存在的与key相等的Node
                    break;
                p = e;
            }
        }
        if (e != null) { // existing mapping for key
            //数组中存在key对应的Node
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                //onlyIfAbsent表示如果value已经存在那么不更新value
                //若总是更新value或者value缺席，那么更新value
                e.value = value;
            afterNodeAccess(e);
            //返回旧值
            return oldValue;
        }
    }
    //⚠️：只有在哈希表中真正增加了一个Node，才会增加modCount的值
    ++modCount;
    if (++size > threshold)
        //若Node的数目超过了threshold(这个阈值由数组长度与加载因子决定)，那么扩容数组
        resize();
    afterNodeInsertion(evict);
    return null;
}
//remove调用了removeNode
//删除
public V remove(Object key) {
    Node<K,V> e;
    return (e = removeNode(hash(key), key, null, false, true)) == null ?
        null : e.value;
}
//读完了putVal函数便清楚：若产生哈希冲突，如果冲突处的节点数目不超过8，则用链表存储节点，否则用红黑树来存储。
//在插入一个节点时，若节点数目超出8，则将链表转换成红黑树，反之，删除节点时，会将红黑树转换成链表吗？盲猜会。。。其实不会的，没必要
final Node<K,V> removeNode(int hash, Object key, Object value,
                               boolean matchValue, boolean movable) {
        Node<K,V>[] tab; Node<K,V> p; int n, index;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (p = tab[index = (n - 1) & hash]) != null) {
            //若节点数组不为null，并且节点数组的长度大于0，并且key对应的索引处存在节点
            Node<K,V> node = null, e; K k; V v;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                //i处的节点就是要删除的节点
                node = p;
            else if ((e = p.next) != null) {
                if (p instanceof TreeNode)
                    //从红黑树中查询key对应的节点
                    node = ((TreeNode<K,V>)p).getTreeNode(hash, key);
                else {
                    //顺序遍历链表，查找key对应的节点
                    do {
                        if (e.hash == hash &&
                            ((k = e.key) == key ||
                             (key != null && key.equals(k)))) {
                            node = e;
                            break;
                        }
                        p = e;
                    } while ((e = e.next) != null);
                }
            }
            if (node != null && (!matchValue || (v = node.value) == value ||
                                 (value != null && value.equals(v)))) {
                //要移除的key存在于哈希表中
                if (node instanceof TreeNode)
                    //从红黑树中移除该节点
                    ((TreeNode<K,V>)node).removeTreeNode(this, tab, movable);
                else if (node == p)
                    //重置表中的头节点
                    tab[index] = node.next;
                else
                    //从链表中移除该节点
                    p.next = node.next;
                //修改数量增加
                ++modCount;
                --size;
                afterNodeRemoval(node);
                return node;
            }
        }
        return null;
    }
//查找
public V get(Object key) {
    Node<K,V> e;
    return (e = getNode(hash(key), key)) == null ? null : e.value;
}
final Node<K,V> getNode(int hash, Object key) {
    Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
    if ((tab = table) != null && (n = tab.length) > 0 &&
        (first = tab[(n - 1) & hash]) != null) {
        //当数组不为null并且数组的长度大于0，并且位于索引处的头节点不为空
        if (first.hash == hash && // always check first node
            ((k = first.key) == key || (key != null && key.equals(k))))
            //头节点就是目标节点
            return first;
        if ((e = first.next) != null) {
            //头节点之后还有节点
            if (first instanceof TreeNode)
                //从红黑树中查找目标节点
                return ((TreeNode<K,V>)first).getTreeNode(hash, key);
           //从链表中查找目标节点
           do {
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    return e;
            } while ((e = e.next) != null);
        }
    }
    //要查找的key在哈希表中不存在
    return null;
}
/**
旧数组长度： 8   1000
新数组长度： 16  10000

哈希码         旧索引 新索引
2:10	  	  10    10
10:1010       10    1010
18:10010      10    10
*/
//假设旧数组长度为2的k次方，则只有二进制从右往左数第k位为1的哈希码的索引会在新数组中更新。
//其实只有哈希码第k位为1的节点，其在新数组中的位置需要更新。
final Node<K,V>[] resize() {
    Node<K,V>[] oldTab = table;
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    int oldThr = threshold;
    int newCap, newThr = 0;
    if (oldCap > 0) {
        if (oldCap >= MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return oldTab;
        }
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                 oldCap >= DEFAULT_INITIAL_CAPACITY)
            newThr = oldThr << 1; // double threshold
    }
    else if (oldThr > 0) // initial capacity was placed in threshold
        newCap = oldThr;
    else {               // zero initial threshold signifies using defaults
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
    if (newThr == 0) {
        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                  (int)ft : Integer.MAX_VALUE);
    }
    threshold = newThr;
    @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    table = newTab;
    if (oldTab != null) {
        for (int j = 0; j < oldCap; ++j) {
            Node<K,V> e;
            if ((e = oldTab[j]) != null) {
                oldTab[j] = null;
                if (e.next == null)
                    newTab[e.hash & (newCap - 1)] = e;
                else if (e instanceof TreeNode)
                    //按第k位是否为1将j处的红黑树一分为二
                    //这个函数内部会真的将树退化成链表。。。上面猜对了。当树中节点数量小于7个时，将树转换成链表。
                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                else { // preserve order
                    //按第k位是否为1将j处的链表一分为二
                    Node<K,V> loHead = null, loTail = null;
                    Node<K,V> hiHead = null, hiTail = null;
                    Node<K,V> next;
                    do {
                        next = e.next;
                        //假设旧数组长度为2的k次方，则只有二进制从右往左数第k位为1的哈希码的索引会在新数组中更新。
                        if ((e.hash & oldCap) == 0) {
                            if (loTail == null)
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }
                        else {
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);
                    if (loTail != null) {
                        loTail.next = null;
                        newTab[j] = loHead;
                    }
                    if (hiTail != null) {
                        hiTail.next = null;
                        //看到这里，其实将容量设置为2的k次方的想法很精妙。颇有爱丽丝梦游仙境的感觉，我他么见识太少了。。
                        newTab[j + oldCap] = hiHead;
                    }
                }
            }
        }
    }
    return newTab;
}
    //这是将红黑树一分为二的代码
final void split(HashMap<K,V> map, Node<K,V>[] tab, int index, int bit) {
    TreeNode<K,V> b = this;
    // Relink into lo and hi lists, preserving order
    TreeNode<K,V> loHead = null, loTail = null;
    TreeNode<K,V> hiHead = null, hiTail = null;
    int lc = 0, hc = 0;
    //先转成两个链表
    for (TreeNode<K,V> e = b, next; e != null; e = next) {
        next = (TreeNode<K,V>)e.next;
        e.next = null;
        if ((e.hash & bit) == 0) {
            if ((e.prev = loTail) == null)
                loHead = e;
            else
                loTail.next = e;
            loTail = e;
            ++lc;
        }
        else {
            if ((e.prev = hiTail) == null)
                hiHead = e;
            else
                hiTail.next = e;
            hiTail = e;
            ++hc;
        }
    }

    if (loHead != null) {
        if (lc <= UNTREEIFY_THRESHOLD)
            //将树退化为链表
            tab[index] = loHead.untreeify(map);
        else {
            tab[index] = loHead;
            if (hiHead != null) // (else is already treeified)
                //确实将红黑树一分为二了, 创建一颗红黑树，else情况，树的结构未发生变化，所以不用处理
                loHead.treeify(tab);
        }
    }
    if (hiHead != null) {
        if (hc <= UNTREEIFY_THRESHOLD)
            tab[index + bit] = hiHead.untreeify(map);
        else {
            tab[index + bit] = hiHead;
            if (loHead != null)
               //确实将红黑树一分为二了, 创建一颗红黑树, else情况，树的结构未发生变化，所以不用处理
               hiHead.treeify(tab);
        }
    }
}

```
