/**
 * 第一遍：2020/06/27周六 ✅
 * 第二遍：2020/06/28周日 ✅
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 * 这个题目要多多回顾，这个状态表示对我来说稍微有点绕。。。
 * ***以第i个元素为结尾的连续子数组，要么是该元素自身，要么是以第i-1个元素为结尾的连续子数组加上该元素*** 从结构出发。总算理解了。。。
 */
class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        //f(i)表示以第i个元素为结尾的连续子数组的最大乘积
        //h(i)表示以第i个元素为结尾的连续子数组的最小乘积
        //f(i) = max(value(i), value(i) * f(i - 1), value(i) * h(i - 1))
        //h(i) = min(value(i), value(i) * f(i - 1), value(i) * h(h - 1))
        if (nums == null || nums.length == 0) {
            return 0;
        } 
        int ret = nums[0];
        int f = nums[0];
        int h = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int v1 = nums[i] * f;
            int v2 = nums[i] * h;
            int v3 = nums[i];
            f = Math.max(v1, Math.max(v2, v3));
            h = Math.min(v1, Math.min(v2, v3));

            ret = Math.max(f, ret);
        }
        return ret;
    }

    // TODO: 2020/6/27 理解这种解法
    //https://leetcode.com/problems/maximum-product-subarray/discuss/183483/In-Python-it-can-be-more-concise-PythonC%2B%2BJava
    public int maxProduct1(int[] A) {
        int n = A.length, res = A[0], l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l =  (l == 0 ? 1 : l) * A[i];
            r =  (r == 0 ? 1 : r) * A[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }
}