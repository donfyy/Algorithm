import java.util.Arrays;

public class HeapSort2 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 6, 4};
        new HeapSort2().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    void sort(int[] arr) {
        for (int i = (arr.length >>> 1) - 1; i >= 0; i--) {
            heapifyDownIterative(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapifyDownIterative(arr, i, 0);
        }
    }

    void heapifyDownIterative(int[] arr, int len, int i) {
        int half = len >>> 1; // 5 -> 2
        int val = arr[i];
        while (i < half) {
            int left = (i << 1) + 1;
            int right = left + 1;
            if (right < len && arr[right] > arr[left]) {
                left = right;
            }
            if (arr[left] <= val) {
                break;
            }
            arr[i] = arr[left];
            i = left;
        }
        arr[i] = val;
    }
}
