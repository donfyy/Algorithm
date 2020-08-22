import java.util.LinkedList;

/**
 * 第一遍：2020/05/24周日 ✅
 * 第二遍：2020/05/26周二 ✅
 * 第三遍：2020/06/24周三 ✅
 * 第四遍：2020/08/17周日 ✅
 * 第五遍：2020/08/20周四 ✅
 * 第六遍：2020/08/21周五 ✅
 * 第七遍：2020/08/22周六 ✅
 * 每个柱子能够接的雨水数量取决于其左边最高柱子和右边最高柱子的最小值
 */
class _42_TrappingRainWater {
    /**
     * 因为是左右最大值中的最小值决定该柱子能接的雨水数量，这种方式确保了lM小于等于右边的最大值，换言之，lM就是有效高度，太妙了。
     * 对于rM同理。
     * 时间:O(n) 空间:O(1)
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int lM = 0, rM = 0;

        int ret = 0;
        while (l < r) {
            // 这里l与r相当于左右边界，所以l < r就行了
            if (height[l] >= height[r]) {
                //这里已经确保了leftMax小于r或rightMax的
                if (height[r] > rM) {
                    rM = height[r];
                } else {
                    ret += rM - height[r];
                }
                r--;
            } else {
                if (height[l] >= lM) {
                    lM = height[l];
                } else {
                    ret += lM - height[l];
                }
                l++;
            }
        }
        return ret;
    }

    /**
     * 栈的解法和柱状图中的最大矩形栈解法相似，找到左右的小边界，然后出栈的过程就是一层一层的计算雨水数量
     * 时间:O(n) 空间:O(n)
     */
    public int trap1(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            int curr = height[i];
            while (!stack.isEmpty() && height[stack.peekLast()] <= curr) {
                int top = stack.pollLast();
                if (stack.isEmpty()) {
                    break;
                }
                ret += (Math.min(curr, height[stack.peekLast()]) - height[top]) * (i - stack.peekLast() - 1);
            }
            stack.offerLast(i);
        }
        return ret;
    }

    // todo:韦恩图？
    // 时间:O(n) 空间:O(1)
    class SolutionMath {
        public int trap(int[] height) {
            if (height == null) return 0;
            int n = height.length, s1 = 0, s2 = 0, s = 0, max1 = 0, max2 = 0;
            for (int i = 0; i < n; i++) {
                s += height[i];
                if (height[i] > max1) max1 = height[i];
                s1 += max1;
                if (height[n - 1 - i] > max2) max2 = height[n - 1 - i];
                s2 += max2;
            }
            return s1 + s2 - max1 * n - s;
        }
    }
}