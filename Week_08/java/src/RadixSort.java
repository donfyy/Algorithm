import java.util.Arrays;
import java.util.LinkedList;

public class RadixSort {
    public static void main(String[] args) {
        int[] a1 = {1, 5, 3, 2, 6, 4};
        radixSort(a1);
        System.out.println(Arrays.toString(a1));
    }

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

    private static int findMaxValue(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

}
