/**
 * 第一遍：2020/08/13周四 ✅
 * 第二遍：2020/08/13周四
 * 第三遍：2020/07/27周一
 * 第四遍：2020/07/28周二
 * 第五遍：2020/08/09周日
 * 第六遍：2020/08/09周一
 * 第七遍：2020/08/12周三
 */
class _283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && ++j != i) {
                nums[j] = nums[i];
                nums[i] = 0;
            }
        }
    }
}