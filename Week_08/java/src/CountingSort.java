import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] a1 = {1, 5, 3, 2, 6, 4};
        countingSort(a1);
        System.out.println(Arrays.toString(a1));
    }

    //时间O(n + k) 空间 O(k)k表示输入的元素是0到k之间的整数
    public static void countingSort(int[] array) {
        int maxValue = findMaxValue(array);
        int[] bucket = new int[maxValue + 1];
        for (int value : array) {
            bucket[value]++;
        }

        for (int i = 0, j = 0; i < bucket.length; i++) {
            int count = bucket[i];
            while (count-- > 0) {
                array[j++] = i;
            }
        }
    }

    public static int findMaxValue(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
