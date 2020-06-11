import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/**
 * 第一遍：2020/06/11周四 ✅
 * 第二遍：2020/06/12周二
 * 第三遍：2020/06/18周四
 * 第四遍：2020/07/02周四
 * 没彻底理解，需要多做几遍。
 */
class _433_MinimumGeneticMutation {
    int minStepCount = Integer.MAX_VALUE;

    public int minMutation1(String start, String end, String[] bank) {
        dfs(new HashSet<String>(), 0, start, end, bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
    }

    void dfs(HashSet<String> set, int step, String current, String end, String[] bank) {
        if (current.equals(end)) {
            minStepCount = Math.min(step, minStepCount);
            if (step > minStepCount) {
                return;
            }
        }

        for (String str : bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (current.charAt(i) != str.charAt(i) && ++diff > 1) {
                    break;
                }
            }
            if (diff == 1 && !set.contains(str)) {
                set.add(str);
                dfs(set, step + 1, str, end, bank);
                set.remove(str);
            }

        }
    }

    //1.将起始基因序列和目标基因序列中不同的基因个数记为x，则最少变化次数就是x。。。
    //2.问题在于判断是否能实现目标变化
    //3.如果存在一条从起始基因序列到目标基因序列的变化路径，并且路径中的每一个基因序列都在基因库中，则能实现目标变化
    //理解错了。。草草草草浪费了一个半小时  啊啊啊啊
    public int minMutationFailed(String start, String end, String[] bank) {
        if (start == null || end == null || bank == null || start.length() != end.length() || bank.length == 0) {
            return -1;
        }

        HashSet<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }

        //记录当前不同的下标列表
        List<Integer> idxList = new LinkedList<>();
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                idxList.add(i);
            }
        }

        if (idxList.isEmpty()) {
            return 0;
        }

        if (idxList.size() > bank.length) {
            return -1;
        }


        return dfs(idxList, false, new StringBuilder(start), end, bankSet) ? idxList.size() : -1;
    }

    boolean dfs(List<Integer> idxList, boolean check, StringBuilder current, String target, HashSet<String> bankSet) {
        if (check && !bankSet.contains(current.toString())) return false;
        if (idxList.isEmpty()) return current.toString().equals(target);

        for (int idx : idxList) {
            char originalChar = current.charAt(idx);
            current.setCharAt(idx, target.charAt(idx));

            List<Integer> newIdxList = new LinkedList<>(idxList);
            newIdxList.remove(new Integer(idx));

            if (dfs(newIdxList, true, current, target, bankSet)) {
                return true;
            }

            current.setCharAt(idx, originalChar);
        }


        return false;
    }
}