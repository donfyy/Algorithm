import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a1 = {5, 3, 2, 6, 4, 1};
        insertionSort(a1);
        System.out.println(Arrays.toString(a1));
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > value) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = value;
        }
    }
}
