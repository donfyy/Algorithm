import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] a1 = {1, 5, 3, 2, 6, 4};
        bucketSort(a1);
        System.out.println(Arrays.toString(a1));
    }

    public static void bucketSort(int[] array) {
        int bucketSize = 3;
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        //创建桶
        int bucketCount = (max - min) / bucketSize + 1;
        List[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList();
        }

        //将元素添加到所属的桶中
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            buckets[(value - min) / bucketSize].add(value);
        }

        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            //对桶进行排序
            Collections.sort(buckets[i]);
            //排序后在取出放到原来的数组中
            for (int j = 0; j < buckets[i].size(); j++) {
                array[k++] = (int) buckets[i].get(j);
            }
        }
    }
}
