class _2_ {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var p1 = l1
        var p2 = l2
        var carry = 0
        val dummy = ListNode(0)
        var p = dummy
        while (p1 != null || p2 != null || carry != 0) {
            var sum = carry
            if (p1 != null) {
                sum += p1.`val`
                p1 = p1.next
            }
            if (p2 != null) {
                sum += p2.`val`
                p2 = p2.next
            }
            p.next = ListNode(sum % 10)
            p = p.next!!
            carry = sum / 10
        }
        return dummy.next
    }
}