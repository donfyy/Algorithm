class _1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(nums[i]);
            if (j != null) {

                return new int[]{i, j};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}