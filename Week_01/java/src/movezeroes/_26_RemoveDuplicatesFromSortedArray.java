package movezeroes;
/**
 * 第一遍：2020/08/15周五 ✅
 * 第二遍：2020/08/13周四
 * 第三遍：2020/07/27周一
 * 第四遍：2020/07/28周二
 * 第五遍：2020/08/09周日
 * 第六遍：2020/08/09周一
 * 第七遍：2020/08/12周三
 */
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
        return j + 1;
    }
}