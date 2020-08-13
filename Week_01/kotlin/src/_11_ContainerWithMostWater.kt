fun maxArea(height: IntArray): Int {
    var l = 0
    var r = height.lastIndex
    var ret = 0
    while (l < r) {
        ret = maxOf(ret, minOf(height[l], height[r]) * (r - l))
        if (height[l] < height[r]) {
            l++
        } else {
            r--
        }
    }
    return ret
}