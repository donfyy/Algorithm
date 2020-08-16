package reverselinkedlist;

/**
 * 第一遍：2020/08/14周六 ✅
 * 第二遍：2020/08/15周日 ✅
 * 第三遍：2020/05/25周一
 * 第四遍：2020/08/13周四
 * 第五遍：2020/08/14周五
 */
class _25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(-1);
        ListNode preTail = hair;
        hair.next = head;
        while (head != null) {
            ListNode tail = head;
            for (int i = 1; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            preTail.next = tail;
            preTail = head;
            reverse(head, tail);
            head = preTail.next;
        }
        return hair.next;
    }

    void reverse(ListNode head, ListNode tail) {
        ListNode headNew = tail.next;
        while (headNew != tail) {
            ListNode curr = head;
            head = head.next;
            curr.next = headNew;
            headNew = curr;
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