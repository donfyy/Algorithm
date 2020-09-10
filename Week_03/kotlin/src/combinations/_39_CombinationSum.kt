package combinations

class _39_1 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val path = mutableListOf<Int>()
        val ret = mutableListOf<List<Int>>()
        fun dfs(i: Int, des: Int) {
            if (i == candidates.size) return
            if (des == 0) {
                ret += path.toList()
                return;
            }
            if (des < 0) return
            if (candidates[i] <= des) {
                path += candidates[i]
                dfs(i, des - candidates[i])
                path.removeAt(path.lastIndex)
            }
            dfs(i + 1, des);
        }
        dfs(0, target);
        return ret
    }
}