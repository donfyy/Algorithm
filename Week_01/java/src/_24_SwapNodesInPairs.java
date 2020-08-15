/**
 * 第一遍：2020/08/14周六 ✅
 * 第二遍：2020/08/14周六
 * 第三遍：2020/05/25周一
 * 第四遍：2020/08/13周四
 * 第五遍：2020/08/14周五
 */
class _24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = null;
        ListNode ret = head.next;
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            head = secondNode.next;

            if (tail != null) {
                tail.next = secondNode;
            }
            secondNode.next = firstNode;
            firstNode.next = head;
            tail = firstNode;
        }
        return ret;
    }

    class SolutionRecursive {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode first = head;
            ListNode second = head.next;
            first.next = swapPairs(second.next);
            second.next = first;
            return second;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}