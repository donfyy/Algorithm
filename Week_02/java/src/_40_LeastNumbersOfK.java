import java.util.PriorityQueue;
import java.util.Random;

/**
 * 第一遍：2020/05/30周六 ✅
 * 第二遍：2020/05/31周日
 * 第三遍：2020/06/06周六
 * 第四遍：2020/06/13周六
 */
class _40_LeastNumbersOfK {
    /**
     * 使用堆来保存最小的k个数
     * 时间：O(nlogk) 空间：O(k)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (arr == null || k <= 0 || arr.length < k) {
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((l, r) -> r - l);

        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.offer(arr[i]);
            } else {
                int max = queue.peek();
                if (arr[i] < max) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }

        int[] ret = new int[k];
        int idx = 0;
        for (int i : queue) {
            ret[idx++] = i;
        }
        return ret;
    }

    /**
     * 这是基于partition函数的解法，不能说成快排，和快排思想类似，但不是快排，只是一次分组。
     * 时间：O(n) 最差：O(n^2)
     * 空间：O(1)
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || k < 1 || arr.length < k) {
            return new int[0];
        }
        if (arr.length == k) {
            return arr;
        }

        int start = 0;
        int end = arr.length - 1;
        int idx = partition(arr, start, end);
        while (idx != k - 1) {
            if (idx < k - 1) {
                start = idx + 1;
            } else {
                end = idx - 1;
            }

            idx = partition(arr, start, end);
        }

        int[] ret = new int[k];
        System.arraycopy(arr, 0, ret, 0, k);
        return ret;
    }

    private int partition(int[] arr, int start, int end) {
        if (arr == null || start < 0 || end >= arr.length) {
            return -1;
        }
        int index = new Random().nextInt(end - start + 1) + start;
        swap(arr, index, end);
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                swap(arr, i, ++j);
            }
        }

        j++;
        swap(arr, j, end);
        return j;
    }

    /**
     * 交换两个数字有三种解法
     * 1。使用临时变量
     * 2。亦或操作
     * 3。加减法
     * 其中2和3不需要声明临时变量
     */
    private void swap(int[] arr, int i, int j) {
        if (j != i) {
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
        }
    }

}