/**
 * 第一遍：2020/08/14周六 ✅
 * 第二遍：2020/08/14周六
 * 第三遍：2020/05/25周一
 * 第四遍：2020/08/13周四
 * 第五遍：2020/08/14周五
 */
class _206_ReverseLinkedList {
    //时间O(n) 空间O(n)
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode headNew = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return headNew;
    }

    class SolutionIterative {
        //时间O(n) 空间O(1)
        public ListNode reverseList(ListNode head) {
            if (head == null) return null;
            ListNode headReversed = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = headReversed;
                headReversed = head;
                head = next;
            }
            return headReversed;
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