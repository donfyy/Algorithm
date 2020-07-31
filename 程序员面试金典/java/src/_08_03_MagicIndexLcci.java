/**
 * 第一遍：2020/07/31周五 ✅
 * 第二遍：2020/08/01周六 ✅
 * 第三遍：2020/07/29周三
 * 第四遍：2020/07/05周日
 */
class _08_03_MagicIndexLcci {
    public int findMagicIndex(int[] nums) {
        //b[i] = a[i] - i 不具有单调性，所以无法使用二分
        if (nums == null) {
            return -1;
        }
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                return i;
            }
            if (i < nums[i]) {
                i = nums[i];
            } else {
                i++;
            }
        }
        return -1;
    }
}