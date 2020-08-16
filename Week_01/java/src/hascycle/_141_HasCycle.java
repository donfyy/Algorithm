package hascycle;

import java.util.HashSet;

/**
 * 第一遍：2020/08/15周六 ✅
 * 第二遍：2020/08/16周日 ✅
 * 第三遍：2020/08/17周一 ✅
 * 第四遍：2020/08/13周四
 * 第五遍：2020/08/14周五
 */
public class _141_HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }


        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public class TwoPointer {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }

            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

