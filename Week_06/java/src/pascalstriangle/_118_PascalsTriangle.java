package pascalstriangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 第一遍：2020/08/01周六 ✅
 * 第二遍：2020/08/01周六
 * 第三遍：2020/07/29周三
 * 第四遍：2020/07/05周日
 */
class _118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return Collections.emptyList();
        }
        List<List<Integer>> ret = new ArrayList<>(numRows);
        List<Integer> list = new ArrayList<>(1);
        list.add(1);
        ret.add(list);
        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>(i + 1);
            ret.add(list);
            List<Integer> pre = ret.get(i - 1);
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(pre.get(j - 1) + pre.get(j));
            }
            list.add(1);
        }
        return ret;
    }
}