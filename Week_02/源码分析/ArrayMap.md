ArrayMap的实现：双数组+二分查找 基于android-29
```java
public final class ArrayMap<K, V> implements Map<K, V> {

    private static final int BASE_SIZE = 4;
    int[] mHashes; // 保存 hash 的数组
    // 某个key，其hash在mHashes中的下标为i，则key，value在mArray中的下标分别为 i << 1, (i << 1) + 1
    Object[] mArray; // 保存 key value 的数组   
    int mSize;
    private static int binarySearchHashes(int[] hashes, int N, int hash) {
        try {
            return ContainerHelpers.binarySearch(hashes, N, hash);
        } catch (ArrayIndexOutOfBoundsException e) {
            if (CONCURRENT_MODIFICATION_EXCEPTIONS) {
                throw new ConcurrentModificationException();
            } else {
                throw e; // the cache is poisoned at this point, there's not much we can do
            }
        }
    }

    @UnsupportedAppUsage(maxTargetSdk = 28) // Hashes are an implementation detail. Use indexOfKey(Object).
    int indexOf(Object key, int hash) {
        // 通过二分查找，找到key所在的下标位置
        // 如果产生哈希冲突，则从冲突的下标位置开始，分别向后、向前扫描
        // 如果key已存在则返回key的下标位置
        // 否则返回所有冲突元素中最后一个元素后的那个下标位置
        // O(logn)  最坏 O(n)
        final int N = mSize;

        // Important fast case: if nothing is in here, nothing to look for.
        if (N == 0) {
            return ~0; // -1
        }

        // 二分查找 hash 的下标
        int index = binarySearchHashes(mHashes, N, hash);

        // If the hash code wasn't found, then we have no entry for this key.
        // hash 不存在，也就是key 不存在
        if (index < 0) {
            return index;
        }

        // key 已存在 或者 产生了 hash 冲突
        // If the key at the returned index matches, that's what we want.
        // 当前的下标index就是key的hash下标
        if (key.equals(mArray[index<<1])) {
            return index;
        }

        // Search for a matching key after the index.
        // 产生了hash冲突，从index + 1开始向后顺序遍历元素，如果key已存在，则返回key的hash的下标
        int end;
        for (end = index + 1; end < N && mHashes[end] == hash; end++) {
            if (key.equals(mArray[end << 1])) return end;
        }

        // Search for a matching key before the index.
        // 然后从index - 1开始向前遍历元素，如果key已存在，则返回key的hash的下标
        for (int i = index - 1; i >= 0 && mHashes[i] == hash; i--) {
            if (key.equals(mArray[i << 1])) return i;
        }

        // Key not found -- return negative value indicating where a
        // new entry for this key should go.  We use the end of the
        // hash chain to reduce the number of array entries that will
        // need to be copied when inserting.
        // 查遍了产生冲突的元素集合，key不存在，则返回所有冲突元素后的那个位置
        return ~end;
    }

    @UnsupportedAppUsage(maxTargetSdk = 28) // Use indexOf(null)
    int indexOfNull() {
        final int N = mSize;

        // Important fast case: if nothing is in here, nothing to look for.
        if (N == 0) {
            return ~0;
        }

        int index = binarySearchHashes(mHashes, N, 0);

        // If the hash code wasn't found, then we have no entry for this key.
        if (index < 0) {
            return index;
        }

        // If the key at the returned index matches, that's what we want.
        if (null == mArray[index<<1]) {
            return index;
        }

        // Search for a matching key after the index.
        int end;
        for (end = index + 1; end < N && mHashes[end] == 0; end++) {
            if (null == mArray[end << 1]) return end;
        }

        // Search for a matching key before the index.
        for (int i = index - 1; i >= 0 && mHashes[i] == 0; i--) {
            if (null == mArray[i << 1]) return i;
        }

        // Key not found -- return negative value indicating where a
        // new entry for this key should go.  We use the end of the
        // hash chain to reduce the number of array entries that will
        // need to be copied when inserting.
        return ~end;
    }

    @UnsupportedAppUsage(maxTargetSdk = 28) // Allocations are an implementation detail.
    private void allocArrays(final int size) {
        if (mHashes == EMPTY_IMMUTABLE_INTS) {
            throw new UnsupportedOperationException("ArrayMap is immutable");
        }
        // 复用缓存
        if (size == (BASE_SIZE*2)) {
            synchronized (ArrayMap.class) {
                if (mTwiceBaseCache != null) {
                    final Object[] array = mTwiceBaseCache;
                    mArray = array;
                    mTwiceBaseCache = (Object[])array[0];
                    mHashes = (int[])array[1];
                    array[0] = array[1] = null;
                    mTwiceBaseCacheSize--;
                    if (DEBUG) Log.d(TAG, "Retrieving 2x cache " + mHashes
                            + " now have " + mTwiceBaseCacheSize + " entries");
                    return;
                }
            }
        } else if (size == BASE_SIZE) {
            synchronized (ArrayMap.class) {
                if (mBaseCache != null) {
                    final Object[] array = mBaseCache;
                    mArray = array;
                    mBaseCache = (Object[])array[0];
                    mHashes = (int[])array[1];
                    array[0] = array[1] = null;
                    mBaseCacheSize--;
                    if (DEBUG) Log.d(TAG, "Retrieving 1x cache " + mHashes
                            + " now have " + mBaseCacheSize + " entries");
                    return;
                }
            }
        }

        mHashes = new int[size];
        mArray = new Object[size<<1];
    }

    @UnsupportedAppUsage(maxTargetSdk = 28) // Allocations are an implementation detail.
    private static void freeArrays(final int[] hashes, final Object[] array, final int size) {
        if (hashes.length == (BASE_SIZE*2)) {
            synchronized (ArrayMap.class) {
                if (mTwiceBaseCacheSize < CACHE_SIZE) {
                    array[0] = mTwiceBaseCache;
                    array[1] = hashes;
                    for (int i=(size<<1)-1; i>=2; i--) {
                        array[i] = null;
                    }
                    mTwiceBaseCache = array;
                    mTwiceBaseCacheSize++;
                    if (DEBUG) Log.d(TAG, "Storing 2x cache " + array
                            + " now have " + mTwiceBaseCacheSize + " entries");
                }
            }
        } else if (hashes.length == BASE_SIZE) {
            synchronized (ArrayMap.class) {
                if (mBaseCacheSize < CACHE_SIZE) {
                    // LIFO
                    array[0] = mBaseCache;
                    array[1] = hashes;
                    for (int i=(size<<1)-1; i>=2; i--) {
                        array[i] = null;
                    }
                    mBaseCache = array;
                    mBaseCacheSize++;
                    if (DEBUG) Log.d(TAG, "Storing 1x cache " + array
                            + " now have " + mBaseCacheSize + " entries");
                }
            }
        }
    }

    public ArrayMap(int capacity, boolean identityHashCode) {
        mIdentityHashCode = identityHashCode;

        // If this is immutable, use the sentinal EMPTY_IMMUTABLE_INTS
        // instance instead of the usual EmptyArray.INT. The reference
        // is checked later to see if the array is allowed to grow.
        if (capacity < 0) {
            mHashes = EMPTY_IMMUTABLE_INTS;
            mArray = EmptyArray.OBJECT;
        } else if (capacity == 0) {
            // int[] INT = new int[0];
            // Object[] OBJECT = new Object[0];
            mHashes = EmptyArray.INT;
            mArray = EmptyArray.OBJECT;
        } else {
            allocArrays(capacity);
        }
        mSize = 0;
    }


    /**
     * Retrieve a value from the array.
     * @param key The key of the value to retrieve.
     * @return Returns the value associated with the given key,
     * or null if there is no such key.
     */
    @Override
    public V get(Object key) {
        // O(logn)
        final int index = indexOfKey(key);
        return index >= 0 ? (V)mArray[(index<<1)+1] : null;
    }

    /**
     * Add a new value to the array map.
     * @param key The key under which to store the value.  If
     * this key already exists in the array, its value will be replaced.
     * @param value The value to store for the given key.
     * @return Returns the old value that was stored for the given key, or null if there
     * was no such key.
     */
    @Override
    public V put(K key, V value) {
        // 1.在mHashes数组中查找key的下标
        // 2.如果key已存在，则更新退出，否则跳到3
        // 3.判断是否需要扩容，如果需要扩容，则扩容
        // 4.执行数组的插入操作
        // put操作的平均时间复杂度是O(logn)的，最坏时间复杂度则是O(n)的
        final int osize = mSize;
        final int hash;
        int index;
        if (key == null) {
            hash = 0;
            index = indexOfNull();
        } else {
            hash = mIdentityHashCode ? System.identityHashCode(key) : key.hashCode();
            // 找到 hash 的索引
            index = indexOf(key, hash);
        }
        if (index >= 0) {
            index = (index<<1) + 1;
            final V old = (V)mArray[index];
            mArray[index] = value;
            return old;
        }

        index = ~index;
        // 扩容，会缓存数组，O(n)的拷贝
        if (osize >= mHashes.length) {
            // BASE_SIZE -> BASE_SIZE << 1 -> BASE_SIZE * 1.5
            final int n = osize >= (BASE_SIZE*2) ? (osize+(osize>>1))
                    : (osize >= BASE_SIZE ? (BASE_SIZE*2) : BASE_SIZE);

            if (DEBUG) Log.d(TAG, "put: grow from " + mHashes.length + " to " + n);

            final int[] ohashes = mHashes;
            final Object[] oarray = mArray;
            allocArrays(n);

            if (CONCURRENT_MODIFICATION_EXCEPTIONS && osize != mSize) {
                throw new ConcurrentModificationException();
            }

            if (mHashes.length > 0) {
                if (DEBUG) Log.d(TAG, "put: copy 0-" + osize + " to 0");
                // O(n)的拷贝
                System.arraycopy(ohashes, 0, mHashes, 0, ohashes.length);
                System.arraycopy(oarray, 0, mArray, 0, oarray.length);
            }

            freeArrays(ohashes, oarray, osize);
        }

        if (index < osize) {
            if (DEBUG) Log.d(TAG, "put: move " + index + "-" + (osize-index)
                    + " to " + (index+1));
            // O(n)的移动
            System.arraycopy(mHashes, index, mHashes, index + 1, osize - index);
            System.arraycopy(mArray, index << 1, mArray, (index + 1) << 1, (mSize - index) << 1);
        }

        if (CONCURRENT_MODIFICATION_EXCEPTIONS) {
            if (osize != mSize || index >= mHashes.length) {
                throw new ConcurrentModificationException();
            }
        }
        mHashes[index] = hash;
        mArray[index<<1] = key;
        mArray[(index<<1)+1] = value;
        mSize++;
        return null;
    }
}

```