class _501_UsingMorris {
    // O(n) O(1)
    fun findMode(root: TreeNode?): IntArray {
        var maxFreq = 0
        var curr = 0
        var currFreq = 0
        val ret = arrayListOf<Int>()
        var node = root
        fun update(v: Int) {
            if (v == curr) {
                currFreq++
            } else {
                curr = v
                currFreq = 1
            }
            if (currFreq == maxFreq) {
                ret += curr
            } else if (currFreq > maxFreq) {
                ret.clear()
                ret += curr
                maxFreq = currFreq
            }
        }
        while (node != null) {
            if (node.left == null) {
                update(node.`val`)
                node = node.right
                continue
            }
            var p = node.left!!
            while (p.right != null && p.right != node) {
                p = p.right!!
            }
            if (p.right == null) {
                p.right = node
                node = node.left
            } else {
                p.right = null
                update(node.`val`)
                node = node.right
            }
        }
        return ret.toIntArray()
    }
}