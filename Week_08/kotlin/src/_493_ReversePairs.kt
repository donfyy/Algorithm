fun reversePairs(nums: IntArray): Int {
    if (nums.size < 2) return 0
    return mergeSort(nums, 0, nums.size - 1, IntArray(nums.size))
}

fun mergeSort(nums: IntArray, left:Int, right:Int, cache:IntArray):Int {
    if (left >= right) return 0
    val mid = left + ((right - left) shr 1)
    var count = 0
    count += mergeSort(nums, left, mid, cache)
    count += mergeSort(nums, mid + 1, right, cache)

    var i = left
    var j = mid + 1
    var k = left
    var l = j

    while (i <= mid) {
        while (l <= right && nums[i] > 2L * nums[l]) l++
        count += l - mid - 1

        while (j <= right && nums[j] < nums[i]) cache[k++] = nums[j++]
        cache[k++] = nums[i++]
    }

    while (j <= right) cache[k++] = nums[j++]
    System.arraycopy(cache, left, nums, left, right - left + 1)
    return count
}
class SolutionRight {
    fun reversePairs(nums: IntArray): Int {
        if (nums.size < 2) return 0
        return mergeSort(nums, 0, nums.size - 1, IntArray(nums.size))
    }
    fun mergeSort(nums:IntArray, left:Int, right:Int, cache:IntArray) :Int{
        if (left >= right) return 0
        val mid = left + ((right - left) shr 1)
        var count = 0
        count += mergeSort(nums, left, mid, cache)
        count += mergeSort(nums, mid + 1, right, cache)

        var i = left
        var j = mid + 1
        var k = left
        var l = i

        while (j <= right) {
            while (l <= mid && nums[l] <= 2L * nums[j]) l++
            count += mid + 1 - l

            while (i <= mid && nums[i] < nums[j]) cache[k++] = nums[i++]
            cache[k++] = nums[j++]
        }

        while (i <= mid) cache[k++] = nums[i++]
        System.arraycopy(cache, left, nums, left, right - left + 1)
        return count
    }
}