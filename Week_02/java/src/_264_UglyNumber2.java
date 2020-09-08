import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 第一遍：2020/07/27周一 ✅
 * 第二遍：2020/09/08周二 ✅
 * 第三遍：2020/07/29周二
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 */
class _264_UglyNumber2 {
    /**
     * 不断的生成新的丑数，然后放到小顶堆里，注意需要set去重
     * 时间：O(n^2) 空间：O(n)
     */
    public int nthUglyNumber1(int n) {
        if (n < 1) {
            return -1;
        }
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        int[] primes = new int[]{2, 3, 5};
        heap.offer(1L);
        for (int i = 1; i < n; i++) {
            long min = heap.poll();
            set.remove(min);

            for (int j : primes) {
                long v = j * min;
                if (!set.contains(v)) {
                    heap.offer(v);
                    set.add(v);
                }
            }
        }
        return heap.poll().intValue();
    }

    /**
     * 时间：O(n) 空间：O(n)
     */
    public int nthUglyNumber2(int n) {
        if (n < 1) {
            return -1;
        }
        int[] array = new int[n];
        array[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < n; i++) {
            int min = Math.min(array[i2] * 2, Math.min(array[i3] * 3, array[i5] * 5));
            array[i] = min;
            while (array[i2] * 2 <= min) i2++;
            while (array[i3] * 3 <= min) i3++;
            while (array[i5] * 5 <= min) i5++;
        }

        return array[n - 1];
    }


}