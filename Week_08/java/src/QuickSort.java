import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 2, 6, 4};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivotIndex = partition(array, begin, end);
        quickSort(array, begin, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, end);
    }

    public static int partition(int[] array, int begin, int end) {
        int pivot = end;
        int j = begin - 1;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, ++j);
            }
        }
        swap(array, ++j, pivot);
        return j;
    }

    public static void swap(int[] array, int i, int j) {
        if (i != j) {
            array[i] = array[i] ^ array[j];
            array[j] = array[i] ^ array[j];
            array[i] = array[i] ^ array[j];
        }
    }
}
