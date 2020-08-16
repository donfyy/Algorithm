import java.util.LinkedList;

/**
 * 第一遍：2020/08/13周四 ✅
 * 第二遍：2020/08/14周五 ✅
 * 第三遍：2020/08/16周日 ✅
 * 第四遍：2020/07/28周二
 * 第五遍：2020/08/09周日
 * 第六遍：2020/08/09周一
 * 第七遍：2020/08/12周三
 */
class _155_MinStack {
    class MinStack {
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> minStack = new LinkedList<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            if (!minStack.isEmpty()) {
                x = Math.min(x, minStack.peek());
            }
            minStack.push(x);
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                minStack.pop();
            }
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.peek();
            }
            return -1;
        }

        public int getMin() {
            if (!minStack.isEmpty()) {
                return minStack.peek();
            }
            return -1;
        }
    }
}