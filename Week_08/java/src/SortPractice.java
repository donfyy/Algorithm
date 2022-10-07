import java.util.*;

/**
 * 第一遍：2020/07/12周日 ✅
 * 第二遍：2020/07/08周四
 * 第二遍：2020/07/06周一
 * 第二遍：2020/07/03周五
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
public class SortPractice {
    public static void main(String[] args) {

//        int[] a1 = {1, 5, 3, 2, 6, 4};
//        insertionSort(a1);
//        System.out.println(Arrays.toString(a1));
//
//        int[] a2 = {1, 5, 3, 2, 6, 4};
//        shellSort(a2);
//        System.out.println(Arrays.toString(a2));
//
//        int[] a3 = {1, 5, 3, 2, 6, 4};
//        bubbleSort(a3);
//        System.out.println(Arrays.toString(a3));
//
//        int[] a4 = {1, 5, 3, 2, 6, 4};
//        quickSort(a4, 0, a4.length - 1);
//        System.out.println(Arrays.toString(a4));
//
//        int[] a5 = {1, 5, 3, 2, 6, 4};
//        selectionSort(a5);
//        System.out.println(Arrays.toString(a5));

//        int[] a6 = {1, 5, 3, 2, 6, 4};
//        heapSort(a6);
//        System.out.println(Arrays.toString(a6));
//
//        int[] a7 = {1, 5, 3, 0, 6, 4};
//        mergeSort(a7, new int[a7.length], 0, a7.length - 1);
//        System.out.println(Arrays.toString(a7));
//
        int[] a8 = {1, 5, 3, 2, 6, 4};
        countingSort(a8);
        System.out.println(Arrays.toString(a8));

        int[] a9 = {1, 5, 3, 2, 6, 4};
        bucketSort(a9);
        System.out.println(Arrays.toString(a9));

        int[] a10 = {1, 50, 3, 2, 600, 41};
        radixSort(a10);
        System.out.println(Arrays.toString(a10));
    }

    // TODO: 2020/7/11 insertion sort
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > v) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = v;
        }
    }

    // TODO: 2020/7/11 shell sort
    public static void shellSort(int[] array) {
        for (int gap = array.length >>> 1; gap > 0; gap >>>= 1) {
            for (int i = gap; i < array.length; i++) {
                int j = i - gap;
                int v = array[i];
                while (j >= 0 && array[j] > v) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = v;
            }
        }
    }

    // TODO: 2020/7/11 bubble sort
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    QuickSort.swap(array, j, j + 1);
                }
            }
        }
    }

    // TODO: 2020/7/11 quick sort
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = right;
        int j = left - 1;
        for (int i = left; i < right; i++) {
            if (array[i] < array[pivot]) {
                QuickSort.swap(array, i, ++j);
            }
        }
        QuickSort.swap(array, pivot, ++j);
        return j;
    }

    // TODO: 2020/7/11 selection sort
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            QuickSort.swap(array, min, i);
        }
    }

    // TODO: 2020/7/11 heap sort
    public static void heapSort(int[] array) {
        for (int i = (array.length >>> 1) - 1; i >= 0; i--) {
            heapifyDown(array, array.length, i);
        }
        for (int i = array.length - 1; i > 0; i--) {
            QuickSort.swap(array, i, 0);
            heapifyDown(array, i, 0);
        }
    }

    public static void heapifyDown(int[] array, int length, int i) {
        int half = length >>> 1;
        int v = array[i];
        while (i < half) {
            int child = (i << 1) + 1;
            int right = child + 1;
            if (right < length && array[right] > array[child]) {
                child = right;
            }
            if (array[child] <= v) {
                break;
            }
            array[i] = array[child];
            i = child;
        }
        array[i] = v;
    }

    // TODO: 2020/7/11 merge sort
    public static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left >= right) return;
        int mid = left + ((right - left) >>> 1);
        mergeSort(array, temp, left, mid);
        mergeSort(array, temp, mid + 1, right);
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];
        System.arraycopy(temp, left, array, left, right - left + 1);
    }

    // TODO: 2020/7/11 counting sort
    public static void countingSort(int[] array) {
        System.out.println("countingSort");
        int mavValue = CountingSort.findMaxValue(array);
        int[] counting = new int[mavValue + 1];
        for (int value : array) {
            counting[value]++;
        }

        for (int i = 0, j = 0; i <= mavValue; i++) {
            while (counting[i]-- != 0) {
                array[j++] = i;
            }
        }
    }

    // TODO: 2020/7/11 bucket sort
    public static void bucketSort(int[] array) {
        System.out.println("bucketSort");
        int minValue = CountingSort.findMinValue(array);
        int maxValue = CountingSort.findMaxValue(array);
        int expectedBucketCapacity = 3;
        int bucketCount = (maxValue - minValue) / expectedBucketCapacity + 1;
        LinkedList[] bucketList = new LinkedList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            bucketList[i] = new LinkedList();
        }

        for (int value : array) {
            bucketList[(value - minValue) / expectedBucketCapacity].add(value);
        }

        for (int i = 0, j = 0; i < bucketCount; i++) {
            Collections.sort(bucketList[i]);
            while (!bucketList[i].isEmpty()) {
                array[j++] = ((int) bucketList[i].poll());
            }
        }
    }

    // TODO: 2020/7/11 radix sort
    public static void radixSort(int[] array) {
        System.out.println("radixSort");
        int maxValue = CountingSort.findMaxValue(array);
        int digitCount = 0;
        while (maxValue != 0) {
            maxValue /= 10;
            digitCount++;
        }
        int[] tmp = new int[array.length];
        for (int digit = 0, div = 1, mod = 10; digit < digitCount; digit++, div *= 10, mod *= 10) {
            int[] cnt = new int[10];
            for (int value : array) {
                cnt[value % mod / div]++;
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }

            for (int i = array.length - 1; i >=0; i--) {
                tmp[--cnt[array[i] % mod / div]] = array[i];
            }
            System.arraycopy(tmp, 0, array, 0, array.length);
        }
    }
}
