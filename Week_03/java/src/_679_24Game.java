import java.util.ArrayList;
import java.util.List;

/**
 * 第一遍：2020/08/22周六 ✅
 * 第二遍：2020/08/22周六
 * 第三遍：2020/06/06周六
 * 第四遍：2020/06/13周六
 * 功力还是不够啊，连暴力的思路都没有想出来，卧槽
 */
class _679_24Game {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] nums) {
        return recur(new ArrayList<Double>() {{
            for (double num : nums) {
                add(num);
            }
        }});
    }

    boolean recur(List<Double> nums) {
        int n = nums.size();
        if (n == 1) return Math.abs(nums.get(0) - TARGET) < EPSILON;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = nums.get(i), b = nums.get(j);
                List<Double> nums2 = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    nums2.add(nums.get(k));
                }
                List<Double> results = new ArrayList<>();
                results.add(a + b);
                results.add(a - b);
                results.add(b - a);
                results.add(a * b);
                if (Math.abs(a) > EPSILON) results.add(b / a);
                if (Math.abs(b) > EPSILON) results.add(a / b);
                for (Double result : results) {
                    nums2.add(result);
                    if (recur(nums2)) {
                        return true;
                    }
                    nums2.remove(nums2.size() - 1);
                }
            }
        }
        return false;
    }
}