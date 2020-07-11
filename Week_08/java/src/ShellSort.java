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
                int j = i;
                int value = array[i];
                while (j - gap >=0 && array[j - gap] > value) {
                    array[j] = array[j - gap];
                    j = j - gap;
                }
                array[j] = value;
            }
        }
    }
}
