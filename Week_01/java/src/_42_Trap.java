class _42_Trap {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int lM = 0, rM = 0;

        int ret = 0;
        while (l < r) {
            if (height[l] >= height[r]) {
                if (height[r] > rM) {
                    rM = height[r];
                } else {
                    ret += rM - height[r];
                }
                r--;
            } else {
                if (height[l] >= lM) {
                    lM = height[l];
                } else {
                    ret += lM - height[l];
                }
                l++;
            }
        }
        return ret;
    }
}