import java.util.LinkedList;

class _84_LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0) {
            return 0;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        stack.offerLast(-1);
        int length = heights.length;

        int max = 0;
        for (int i = 0; i < length; i++) {
            int current = heights[i];
            while (stack.peekLast() != -1 && heights[stack.peekLast()] >= current) {
                max = Math.max(max, heights[stack.pollLast()] * (i - stack.peekLast() -1));
            }
            stack.offerLast(i);
        }
        
        while (stack.peekLast() != -1) {
            max = Math.max(max, heights[stack.pollLast()] * (length  - stack.peekLast() - 1));
        }
        return max;
    }
}