/**
 * 第一遍：2020/08/19周三 ✅
 * 第二遍：2020/08/19周三
 * 第三遍：2020/06/06周六
 * 第四遍：2020/06/13周六
 */
class _109_ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return convert(head, null);
    }

    TreeNode convert(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return new TreeNode(slow.val, convert(head, slow), convert(slow.next, tail));
    }

    class SolutionInorder {
        ListNode node;

        public TreeNode sortedListToBST(ListNode head) {
            node = head;
            int n = 0;
            while (head != null) {
                n++;
                head = head.next;
            }
            return convert(0, n - 1);
        }

        TreeNode convert(int l, int r) {
            if (l > r) return null;
            int m = (l + r + 1) >>> 1;
            TreeNode root = new TreeNode();
            root.left = convert(l, m - 1);
            root.val = node.val;
            node = node.next;
            root.right = convert(m + 1, r);
            return root;
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}