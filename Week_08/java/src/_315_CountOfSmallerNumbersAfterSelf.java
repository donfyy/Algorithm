import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 第一遍：2020/07/13周一 ✅
 * 第二遍：2020/07/14周二 ✅
 * 第三遍：2020/07/13周一
 * 第二遍：2020/07/06周一
 * 第二遍：2020/07/03周五
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _315_CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        int length = nums.length;
        int[] indexes = new int[length];
        for (int i = 0; i < length; i++) {
            indexes[i] = i;
        }
        int[] count = new int[length];
        int[] cache = new int[length];
        mergeSort(nums, indexes, 0, length - 1, cache, count);
        List<Integer> ret = new ArrayList<>(length);
        for (int c : count) {
            ret.add(c);
        }
        return ret;
    }

    void mergeSort(int[] nums, int[] indexes, int left, int right, int[] cache, int[] count) {
        if (left >= right) return;
        int mid = left + ((right - left) >>> 1);
        mergeSort(nums, indexes, left, mid, cache, count);
        mergeSort(nums, indexes, mid + 1, right, cache, count);
        int i = left, j = mid + 1, k = i;
        int c = 0;
        while (i <= mid) {
            //把idx缓存起来可以稳定到6ms。。
            int idx = indexes[i];
            while (j <= right && nums[idx] > nums[indexes[j]]) {
                c++;
                cache[k++] = indexes[j++];
            }
            count[idx] += c;
            cache[k++] = idx;
            i++;
        }

        while (j <= right) cache[k++] = indexes[j++];
        System.arraycopy(cache, left, indexes, left, right - left + 1);
    }

    void mergeSortRight(int[] nums, int[] indexes, int left, int right, int[] cache, int[] count) {
        if (left >= right) return;
        int mid = left + ((right - left) >>> 1);
        mergeSortRight(nums, indexes, left, mid, cache, count);
        mergeSortRight(nums, indexes, mid + 1, right, cache, count);
        int i = left, j = mid + 1, k = i;
        int c = 0;
        while (j <= right) {
            int idx = indexes[j];
            while (i <= mid && nums[indexes[i]] <= nums[idx]) {
                count[indexes[i]] += c;
                cache[k++] = indexes[i++];
            }
            c++;
            cache[k++] = idx;
            j++;
        }
        while (i <= mid) {
            count[indexes[i]] += c;
            cache[k++] = indexes[i++];
        }
        System.arraycopy(cache, left, indexes, left, right - left + 1);
    }

    void mergeSortMid(int[] nums, int[] indexes, int left, int right, int[] cache, int[] count) {
        if (left >= right) return;
        int mid = left + ((right - left) >>> 1);
        mergeSortMid(nums, indexes, left, mid, cache, count);
        mergeSortMid(nums, indexes, mid + 1, right, cache, count);
        int i = left, j = mid + 1, k = i;
        int c = 0;
        while (i <= mid && j <= right) {
            if (nums[indexes[i]] <= nums[indexes[j]]) {
                count[indexes[i]] += c;
                cache[k++] = indexes[i++];
            } else {
                c++;
                cache[k++] = indexes[j++];
            }
        }
        while (i <= mid) {
            count[indexes[i]] += c;
            cache[k++] = indexes[i++];
        }
        while (j <= right) cache[k++] = indexes[j++];
        System.arraycopy(cache, left, indexes, left, right - left + 1);
    }
}