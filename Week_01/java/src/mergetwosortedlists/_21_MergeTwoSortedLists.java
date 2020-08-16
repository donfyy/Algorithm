package mergetwosortedlists;

/**
 * 第一遍：2020/08/16周日 ✅
 * 第二遍：2020/08/17周一 ✅
 * 第三遍：2020/05/25周一
 * 第四遍：2020/08/13周四
 * 第五遍：2020/08/14周五
 */
class _21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode hair = new ListNode(-1);
        ListNode k = hair;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                k.next = l2;
                l2 = l2.next;
            } else {
                k.next = l1;
                l1 = l1.next;
            }
            k = k.next;
        }

        k.next = l1 == null ? l2 : l1;
        return hair.next;
    }

    class SolutionRecursive {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}