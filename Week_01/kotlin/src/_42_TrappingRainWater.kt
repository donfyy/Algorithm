fun trap(height: IntArray): Int {
    if (height.size < 3) {
        return 0
    }
    var l = 0
    var r = height.size - 1
    var lM = 0
    var rM = 0
    var ret = 0
    while (l < r) {
        if (height[l] < height[r]) {
            if (height[l] > lM) {
                lM = height[l]
            } else {
                ret += lM - height[l]
            }
            l++
        } else {
            if (height[r] > rM) {
                rM = height[r]
            } else {
                ret += rM - height[r]
            }
            r--
        }
    }
    return ret
}