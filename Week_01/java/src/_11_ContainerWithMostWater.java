/**
 * 第一遍：2020/08/13周四 ✅
 * 第二遍：2020/08/14周五 ✅
 * 第三遍：2020/07/27周一
 * 第四遍：2020/07/28周二
 * 第五遍：2020/08/09周日
 * 第六遍：2020/08/09周一
 * 第七遍：2020/08/12周三
 */
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