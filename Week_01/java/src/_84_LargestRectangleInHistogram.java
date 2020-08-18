import java.util.LinkedList;

/**
 * 第一遍：2020/08/13周四 ✅
 * 第二遍：2020/08/16周日 ✅
 * 第三遍：2020/08/17周一 ✅
 * 第四遍：2020/08/18周二 ✅
 * 第五遍：2020/08/09周日
 * 第六遍：2020/08/09周一
 * 第七遍：2020/08/12周三
 * 从遍历查找每个柱子的左边界和右边界
 * 到用栈求出每个柱子的左右边界
 */
class _84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null) return -1;
        int n = heights.length;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int curr = heights[i];
            while (stack.peek() != -1 && heights[stack.peek()] > curr) {
                ret = Math.max(ret, heights[stack.pop()] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            ret = Math.max(ret, heights[stack.pop()] * (n - 1 - stack.peek()));
        }
        return ret;
    }
}