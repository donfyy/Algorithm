/**
 * 第一遍：2020/08/14周五 ✅
 * 第二遍：2020/05/22周五
 * 第三遍：2020/05/25周一
 * 第四遍：2020/08/13周四
 * 第五遍：2020/08/14周五
 */
class _189_RotateArray {
    //环状替换
    public void rotate(int[] nums, int k) {
        if (nums == null) return;
        int n = nums.length;
        k = k % n;
        for (int start = 0, count = 0; count < n; start++) {
            int curr = start;
            int pre = nums[start];
            do {
                int next = (curr + k) % n;
                int t = nums[next];
                nums[next] = pre;
                pre = t;
                curr = next;
                count++;
            } while (curr != start);
        }
    }

    class SolutionReverse {
        //反转再反转，和反转字符串中的单词那一题类似。
        public void rotate(int[] nums, int k) {
            if (nums == null) return;
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        void reverse(int[] nums, int l, int r) {
            while (l < r) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
                l++;
                r--;
            }
        }
    }
}