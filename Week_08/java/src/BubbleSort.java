import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a1 = {1, 5, 3, 2, 6, 4};
        bubbleSort(a1);
        System.out.println(Arrays.toString(a1));
    }

    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
