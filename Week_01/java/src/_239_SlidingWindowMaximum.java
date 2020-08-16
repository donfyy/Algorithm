import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 第一遍：2020/05/23周六 ✅
 * 第二遍：2020/05/24周日 ✅
 * 第三遍：2020/05/30周六 ✅
 * 第四遍：2020/08/16周日 ✅
 */
class _239_SlidingWindowMaximum {

    /**
     * 使用一个双端队列来记录滑动窗口中的最大值，队列的头部就是最大值。
     * 时间：O(n) 每个元素最多被访问两次
     * 空间：O(k)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ret = new int[nums.length - k + 1];
        ret[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i - deque.peekFirst() == k) {
                deque.pollFirst();
            }

            ret[i - k + 1] = nums[deque.peekFirst()];
        }
        return ret;
    }

    /**
     * 使用最大堆来保存滑动窗口中的值，位于堆顶的元素就是滑动窗口中的最大值。
     * 时间：O(nlogk) 空间：O(k)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((l, r) -> r - l);
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
                if (queue.size() == k) {
                    ret[0] = queue.peek();
                }
            } else {
                queue.remove(nums[i - k]);
                queue.offer(nums[i]);
                ret[i - k + 1] = queue.peek();
            }
        }

        return ret;
    }

    // TODO: 2020/5/30  动态规划？
}