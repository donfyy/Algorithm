import java.util.*;

/**
 * 第一遍：2020/08/01周六 ✅
 * 第二遍：2020/08/01周六
 * 第三遍：2020/07/29周三
 * 第四遍：2020/07/05周日
 * 抄了三遍，才有了一个大概的理解。。。太菜了我，奥利给！！！
 */
class _632_SmallestRangeCoveringElementsFromKLists {
    //堆解法
    //时间O(nklogk) 空间 O(k)
    public int[] smallestRange(List<List<Integer>> nums) {
        int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
        int minRange = rangeRight - rangeLeft;
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] next = new int[size];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer idx1, Integer idx2) {
                return nums.get(idx1).get(next[idx1]) - nums.get(idx2).get(next[idx2]);
            }
        });
        for (int i = 0; i < size; i++) {
            priorityQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            int minIdx = priorityQueue.poll();
            int curRange = max - nums.get(minIdx).get(next[minIdx]);
            if (curRange < minRange) {
                minRange = curRange;
                rangeLeft = nums.get(minIdx).get(next[minIdx]);
                rangeRight = max;
            }
            next[minIdx]++;
            if (next[minIdx] == nums.get(minIdx).size()) {
                break;
            }
            priorityQueue.offer(minIdx);
            max = Math.max(max, nums.get(minIdx).get(next[minIdx]));
        }
        return new int[]{rangeLeft, rangeRight};
    }


    //时间O(nk + |V|) |V|是列表中元素的值域 空间O(nk)哈希表使用的空间
    public int[] smallestRangeSlidingWindow(List<List<Integer>> nums) {
        int size = nums.size();
        Map<Integer, List<Integer>> indices = new HashMap<>();
        int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            for (int x : nums.get(i)) {
                List<Integer> list = indices.computeIfAbsent(x, k -> new ArrayList<>());
                list.add(i);
                xMin = Math.min(xMin, x);
                xMax = Math.max(xMax, x);
            }
        }

        int[] freq = new int[size];
        int inside = 0;
        int left = xMin, right = xMin - 1;
        int bestLeft = xMin, bestRight = xMax;
        while (right < xMax) {
            right++;
            if (!indices.containsKey(right)) {
                continue;
            }

            for (int x : indices.get(right)) {
                freq[x]++;
                if (freq[x] == 1) {
                    inside++;
                }
            }

            while (inside == size) {
                if (right - left < bestRight - bestLeft) {
                    bestLeft = left;
                    bestRight = right;
                }

                if (indices.containsKey(left)) {
                    for (int x : indices.get(left)) {
                        freq[x]--;
                        if (freq[x] == 0) {
                            inside--;
                        }
                    }
                }
                left++;
            }
        }
        return new int[]{bestLeft, bestRight};
    }
}