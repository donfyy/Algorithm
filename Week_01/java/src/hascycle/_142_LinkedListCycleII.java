package hascycle;

/**
 * 第一遍：2020/08/16周日 ✅
 * 第二遍：2020/08/17周一 ✅
 * 第三遍：2020/08/17周二 ✅
 * 第四遍：2020/08/13周四
 * 第五遍：2020/08/14周五
 */
public class _142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (hare == tortoise) {
                break;
            }
        }

        if (hare == null || hare.next == null) {
            return null;
        }

        ListNode p = head;
        ListNode q = hare;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}