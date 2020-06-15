class _26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(new _26_RemoveDuplicatesFromSortedArray());
    }
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }
}