class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j ;) {
            int curr = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(max, curr);

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}