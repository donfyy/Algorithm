class _45_JumpGameII {
    public int jump1(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int nextPos = 0;
        int maxPos = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == nextPos) {
                nextPos = maxPos;
                step++;
            }
        }
        return step;
    }

    public int jump2(int[] nums) {
        //从最后一个位置开始，不断的找能够跳跃到该位置的最远位置。
        if (nums == null) {
            return 0;
        }
        int pos = nums.length - 1;
        int step = 0;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (i + nums[i] >= pos) {
                    pos = i;
                    step++;
                }
            }
        }
        return step;
    }

}