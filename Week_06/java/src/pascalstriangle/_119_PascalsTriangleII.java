package pascalstriangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 第一遍：2020/08/01周六 ✅
 * 第二遍：2020/08/02周日 ✅
 * 第三遍：2020/07/29周三
 * 第四遍：2020/07/05周日
 */
class _119_PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        // f(i, j) = f(i - 1, j - 1) + f(i - 1, j)
        if (rowIndex < 0) {
            return Collections.emptyList();
        }
        List<Integer> ret = new ArrayList<Integer>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            ret.add(1);
            for (int j = i - 1; j > 0; j--) {
                ret.set(j, ret.get(j) + ret.get(j - 1));
            }
        }
        return ret;
    }
}