import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] a1 = {1, 5, 3, 2, 6, 4};
        shellSort(a1);
        System.out.println(Arrays.toString(a1));
    }

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
}
