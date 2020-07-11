import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] a1 = {1, 5, 3, 2, 6, 4};
        heapSort(a1);
        System.out.println(Arrays.toString(a1));

        int[] a2 = {1, 5, 3, 2, 6, 4};
        heapSort2Iterative(a2);
        System.out.println(Arrays.toString(a2));

        int[] a3 = {1, 5, 3, 2, 6, 4};
        heapSort2Recursive(a3);
        System.out.println(Arrays.toString(a3));

    }

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

    //手动维护一个堆
    //时间O(nlogn) 空间O(1)
    public static void heapSort2Iterative(int[] array) {
        int length = array.length;
        for (int i = (length >>> 1) - 1; i >= 0; i--) {
            heapifyDownIterative(array, length, i);
        }

        for (int i = length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapifyDownIterative(array, i, 0);
        }
    }

    public static void heapifyDownIterative(int[] array, int length, int i) {
        int half = length >>> 1;
        while (i < half) {
            int child = (i << 1) + 1;
            int right = child + 1;
            if (right < length && array[right] > array[child]) {
                child = right;
            }

            if (array[child] <= array[i]) {
                break;
            }
            int temp = array[child];
            array[child] = array[i];
            array[i] = temp;

            i = child;
        }
    }

    //时间O(nlogn) 空间O(logn)
    public static void heapSort2Recursive(int[] array) {
        int length = array.length;
        for (int i = (length >>> 1) - 1; i >= 0; i--) {
            heapifyDownRecursive(array, length, i);
        }

        for (int i = length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapifyDownRecursive(array, i, 0);
        }
    }

    public static void heapifyDownRecursive(int[] array, int length, int i) {
        int half = length >>> 1;
        if (i >= half) {
            return;
        }

        int child = (i << 1) + 1;
        int right = child + 1;
        if (right < length && array[right] > array[child]) {
            child = right;
        }
        if (array[child] <= array[i]) {
            return;
        }

        int temp = array[child];
        array[child] = array[i];
        array[i] = temp;
        heapifyDownRecursive(array, length, child);
    }
}
