
```java
public interface Queue<E> extends Collection<E> {
 
    // 将元素e添加到队列的尾部，如果队列已满则抛出异，如果元素是null并且队列不允许null值，则抛出NPE。
    boolean add(E e);

    // 将元素e添加到队列的尾部，如果e被添加到队列中，则返回true，否则返回false，注意与add(E e)的区别。
    boolean offer(E e);

    // 移除队列的头部元素，如果队列为空，则抛出异常
    E remove();

    // 移除队列的头部元素，如果队列为空，则返回null，注意与remove的区别
    E poll();

    // 读取队列的头部元素，如果队列为空，则抛出异常NoSuchElementException
    E element();

    // 读取队列的头部元素，如果队列为空，则返回null
    E peek();

}
```