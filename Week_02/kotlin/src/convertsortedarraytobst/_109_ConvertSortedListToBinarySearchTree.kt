package convertsortedarraytobst

fun sortedListToBST(head: ListNode?): TreeNode? {
    fun convert(l: ListNode?, r: ListNode?): TreeNode? {
        if (l == r) return null
        var fast = l
        var slow = l
        while (fast != r && fast?.next != r) {
            fast = fast?.next?.next
            slow = slow?.next
        }

        return TreeNode(slow?.`val`!!, convert(l, slow), convert(slow.next, r))
    }
    return convert(head, null)
}

class _109_Solution2 {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        var len = 0
        var node = head
        while (node != null) {
            node = node.next
            len++
        }
        node = head
        fun convert(l: Int, r: Int): TreeNode? {
            if (l == r) return null
            val m = (l + r) ushr 1
            return TreeNode().apply {
                left = convert(l, m)
                `val` = node?.`val`!!
                node = node?.next
                right = convert(m + 1, r)
            }
        }
        return convert(0, len)
    }
}

class TreeNode(var `val`: Int) {
    constructor(`val`: Int, left: TreeNode?, right: TreeNode?) : this(`val`) {
        this.left = left
        this.right = right
    }

    constructor() : this(0)

    var left: TreeNode? = null
    var right: TreeNode? = null
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}