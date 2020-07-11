import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a1 = {1, 5, 3, 2, 6, 4};
        selectionSort(a1);
        System.out.println(Arrays.toString(a1));
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }
}
