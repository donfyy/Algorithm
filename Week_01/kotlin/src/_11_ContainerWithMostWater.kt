fun maxArea(height: IntArray): Int {
    var i = 0
    var j = height.size - 1
    var max = 0
    while (i < j) {
        max = Math.max(max, (j - i) * Math.min(height[i], height[j]))
        if (height[i] < height[j]) i++ else j--
    }
    return max;
}
