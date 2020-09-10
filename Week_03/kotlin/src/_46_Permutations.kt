import java.util.*

class _46_UsingSwap {
    fun permute(nums: IntArray): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        val n = nums.size - 1;
        fun dfs(start: Int) {
            if (start == n) {
                ret += nums.toList()
                return
            }
            for (i in start..n) {
                nums[start] = nums[i].also { nums[i] = nums[start] }
                dfs(start + 1)
                nums[start] = nums[i].also { nums[i] = nums[start] }
            }
        }
        dfs(0)
        return ret
    }
}

class _46_UsingVisitedArray {
    fun permute(nums: IntArray): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        val n = nums.size
        val visited = BooleanArray(n)
        val path = LinkedList<Int>()
        fun dfs(start: Int) {
            if (start == n) {
                ret += path.toList()
                return
            }
            for (i in nums.indices) {
                if (visited[i]) continue
                visited[i] = true
                path += nums[i]
                dfs(start + 1)
                path.pollLast()
                visited[i] = false;
            }
        }
        dfs(0)
        return ret
    }
}