import java.util.*;

/**
 * 第一遍：2020/06/11周四 ✅
 * 第二遍：2020/06/13周六 ✅
 * 第三遍：2020/07/04周六 ✅
 * 第三遍：2020/09/21周四 ✅
 * 第四遍：2020/07/02周四
 * 没彻底理解，需要多做几遍。
 * 获取一次基因变化后的结果有两种方式
 * 1.将当前基因某个碱基逐个替换为候选碱基，然后判断替换后的基因是否在基因库中。
 * 2.遍历基因库找到与当前基因只相差一个碱基的基因。
 * 因此这道题的bfs和dfs解法至少有4种，在算上bfs的3种写法，一共可以有8种解法。如果算上dfs的循环解法又可以再多两种。。
 * 2种基因变化的方式是8种解法的核心。
 * 需要考虑去重的原因是基因变化是一张图，而不是一棵树。第i个碱基在当前层可以从A变成B
 * 在下一层的时候又会从B变成A，因此我们要记录已经访问的基因，也就是要去重。
 */
class _433_MinimumGeneticMutation {
    int minLevel = Integer.MAX_VALUE;

    public int minMutationDfs1(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() != end.length() || bank == null || bank.length == 0) {
            return -1;
        }

        dfs(new HashSet<String>(), 0, start, end, bank);
        return minLevel == Integer.MAX_VALUE ? -1 : minLevel;
    }

    /**
     * @param visited 当前路径上已经访问过的节点
     * @param level
     * @param current
     * @param end
     * @param bank
     */
    void dfs(HashSet<String> visited, int level, String current, String end, String[] bank) {
        if (current.equals(end)) {
            minLevel = Math.min(minLevel, level);
            return;
        }
        //假如已经得到了一个最小变化次数，继续变化碱基得到的变化次数一定比这个最小变化次数要大，此时可以结束当前的dfs
        if (level == minLevel) return;

        for (String str : bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != current.charAt(i) && ++diff > 1) break;
            }

            if (diff == 1 && !visited.contains(str)) {
                visited.add(str);
                dfs(visited, level + 1, str, end, bank);
                visited.remove(str);
            }
        }
    }

    static class TwoEndBfs {
        public int minMutation(String start, String end, String[] bank) {
            if (start == null || end == null || bank == null || bank.length == 0 || start.isEmpty() || end.isEmpty() || start.length() != end.length()) {
                return -1;
            }

            HashSet<String> beginLevel = new HashSet<>();
            beginLevel.add(start);
            HashSet<String> endLevel = new HashSet<>();
            endLevel.add(end);
            HashSet<String> visited = new HashSet<>();
            visited.add(end);
            visited.add(start);
            int level = 1;

            while (!beginLevel.isEmpty()) {
                HashSet<String> nextLevel = new HashSet<>();
                for (String str : beginLevel) {

                    for (String next : bank) {
                        int diff = 0;
                        for (int i = 0; i < next.length(); i++) {
                            if (next.charAt(i) != str.charAt(i) && ++diff > 1) {
                                break;
                            }
                        }
                        if (diff == 1 && endLevel.contains(next)) {
                            return level;
                        }
                        if (diff == 1 && !visited.contains(next)) {

                            visited.add(next);
                            nextLevel.add(next);
                        }
                    }
                }

                if (nextLevel.size() > endLevel.size()) {
                    beginLevel = endLevel;
                    endLevel = nextLevel;
                } else {
                    beginLevel = nextLevel;
                }

                level++;
            }

            return -1;
        }
    }

    static class SolutionIterativeDfs1 {
        static class Node {
            Node(String val, int level, HashSet<String> visited) {
                this.val = val;
                this.level = level;
                this.visited = visited;
            }

            String val;
            int level;
            HashSet<String> visited;
        }

        public int minMutation(String start, String end, String[] bank) {
            if (start == null || end == null || start.length() != end.length() || bank == null || bank.length == 0)
                return -1;
            Deque<Node> stack = new LinkedList<>();
            stack.offerLast(new Node(start, 0, new HashSet<String>()));
            int minLevel = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                if (node.val.intern() == end.intern()) {
                    if (minLevel > node.level) {
                        minLevel = node.level;
                    }
                    continue;
                }
                if (node.level == minLevel) continue;
                for (String next : bank) {
                    int diff = 0;
                    for (int i = 0; i < next.length(); i++) {
                        if (node.val.charAt(i) != next.charAt(i) && ++diff > 1) break;
                    }
                    if (diff == 1 && !node.visited.contains(next)) {
                        HashSet<String> visited = new HashSet<>(node.visited);
                        visited.add(next);
                        stack.offerLast(new Node(next, node.level + 1, visited));
                    }
                }
            }

            return minLevel == Integer.MAX_VALUE ? -1 : minLevel;
        }
    }

    static class SolutionIterativeDfs2 {
        static class Node {
            Node(String val, int level, HashSet<String> visited) {
                this.val = val;
                this.level = level;
                this.visited = visited;
            }

            String val;
            int level;
            HashSet<String> visited;
        }

        public int minMutation(String start, String end, String[] bank) {
            if (start == null || end == null || start.length() != end.length() || bank == null || bank.length == 0)
                return -1;
            LinkedList<Node> stack = new LinkedList<>();
            stack.offerLast(new Node(start, 0, new HashSet<String>()));
            char[] candidates = new char[]{'A', 'C', 'G', 'T'};
            HashSet<String> bankSet = new HashSet<>();
            Collections.addAll(bankSet, bank);
            int minLevel = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                if (node.val.intern() == end.intern()) {
                    if (minLevel > node.level) {
                        minLevel = node.level;
                    }
                    continue;
                }
                if (node.level == minLevel) continue;

                char[] arr = node.val.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c : candidates) {
                        arr[i] = c;

                        String next = new String(arr);
                        if (bankSet.contains(next) && !node.visited.contains(next)) {
                            HashSet<String> visited = new HashSet<>(node.visited);
                            visited.add(next);
                            stack.offerLast(new Node(next, node.level + 1, visited));
                        }
                    }
                    arr[i] = old;
                }
            }
            return minLevel == Integer.MAX_VALUE ? -1 : minLevel;
        }
    }

    public int minMutationBfs4(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() != end.length() || bank == null || bank.length == 0)
            return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        HashSet<String> visited = new HashSet<>();
        visited.add(start);

        int level = 0;
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            while (levelCount-- > 0) {
                String curr = queue.poll();
                if (curr.equals(end)) return level;

                for (String next : bank) {
                    int diff = 0;
                    for (int i = 0; i < curr.length(); i++) {
                        if (curr.charAt(i) != next.charAt(i) && ++diff > 1) break;
                    }

                    if (diff == 1 && !visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    public int minMutationBfs5(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() != end.length() || bank == null || bank.length == 0)
            return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        HashSet<String> visited = new HashSet<>();

        int level = 0, cl = 1, nl = 0;

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.intern() == end.intern()) return level;
            for (String next : bank) {
                int diff = 0;
                for (int i = 0; i < next.length(); i++) {
                    if (next.charAt(i) != curr.charAt(i) && ++diff > 1) break;
                }
                if (diff == 1 && !visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                    nl++;
                }
            }

            cl--;
            if (cl == 0) {
                level++;
                cl = nl;
                nl = 0;
            }
        }

        return -1;
    }

    public int minMutationBfs6(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() != end.length() || bank == null || bank.length == 0)
            return -1;

        Queue<String> cl = new LinkedList<>();
        Queue<String> nl = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        cl.offer(start);
        int level = 0;
        while (!cl.isEmpty()) {
            String curr = cl.poll();
            if (curr.intern() == end.intern()) return level;

            for (String next : bank) {
                int diff = 0;
                for (int i = 0; i < next.length(); i++) {
                    if (next.charAt(i) != curr.charAt(i) && ++diff > 1) break;
                }
                if (diff == 1 && !visited.contains(next)) {
                    visited.add(next);
                    nl.offer(next);
                }
            }

            if (cl.isEmpty()) {
                Queue<String> temp = cl;
                cl = nl;
                nl = temp;

                level++;
            }
        }
        return -1;
    }

    public int minMutationBfs1(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() != end.length() || bank == null || bank.length == 0) {
            return -1;
        }
        HashSet<String> bankSet = new HashSet<>(bank.length);
        Collections.addAll(bankSet, bank);

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        HashSet<String> visited = new HashSet<>();
        int level = 0;

        char[] change = new char[]{'A', 'C', 'G', 'T'};

        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            while (levelCount-- > 0) {
                String current = queue.poll();
                if (current.equals(end)) return level;

                char[] currentCharArray = current.toCharArray();
                for (int i = 0; i < currentCharArray.length; i++) {
                    char oldChar = currentCharArray[i];
                    for (char c : change) {
                        currentCharArray[i] = c;
                        String nextCurrent = new String(currentCharArray);
                        if (!visited.contains(nextCurrent) && bankSet.contains(nextCurrent)) {
                            visited.add(nextCurrent);
                            queue.offer(nextCurrent);
                        }
                    }
                    currentCharArray[i] = oldChar;
                }
            }
            level++;
        }

        return -1;
    }

    public int minMutationBfs2(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() != end.length() || bank == null || bank.length == 0)
            return -1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int level = 0;
        int cl = 1, nl = 0;

        HashSet<String> bankSet = new HashSet<>();
        Collections.addAll(bankSet, bank);
        HashSet<String> visited = new HashSet<>();

        char[] changeArray = new char[]{'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.equals(end)) return level;

            char[] currArray = curr.toCharArray();
            for (int i = 0; i < currArray.length; i++) {
                char old = currArray[i];
                for (char c : changeArray) {
                    currArray[i] = c;
                    String next = new String(currArray);
                    if (!visited.contains(next) && bankSet.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                        nl++;
                    }
                }
                currArray[i] = old;
            }

            cl--;
            if (cl == 0) {
                level++;
                cl = nl;
                nl = 0;
            }
        }
        return -1;
    }

    public int minMutationBfs3(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() != end.length() || bank == null || bank.length == 0)
            return -1;

        Queue<String> cl = new LinkedList<>();
        Queue<String> nl = new LinkedList<>();
        cl.offer(start);

        HashSet<String> visited = new HashSet<>();
        HashSet<String> bankSet = new HashSet<>();
        Collections.addAll(bankSet, bank);

        int level = 0;

        char[] change = new char[]{'A', 'C', 'G', 'T'};
        while (!cl.isEmpty()) {
            String curr = cl.poll();
            if (curr.equals(end)) return level;

            char[] currArr = curr.toCharArray();
            for (int i = 0; i < currArr.length; i++) {
                char old = currArr[i];
                for (char c : change) {
                    //将当前字符逐个替换为候选字符
                    currArr[i] = c;
                    String next = new String(currArr);
                    if (!visited.contains(next) && bankSet.contains(next)) {
                        visited.add(next);
                        nl.offer(next);
                    }

                }
                currArr[i] = old;
            }

            if (cl.isEmpty()) {
                Queue<String> temp = cl;
                cl = nl;
                nl = temp;

                level++;
            }
        }

        return -1;
    }

    static class SolutionDfs {
        int minLevel = Integer.MAX_VALUE;
        char[] change = new char[]{'A', 'C', 'G', 'T'};

        public int minMutation(String start, String end, String[] bank) {
            if (start == null || end == null || start.length() != end.length() || bank == null || bank.length == 0)
                return -1;

            HashSet<String> bankSet = new HashSet<>();
            Collections.addAll(bankSet, bank);
            dfs(0, start, end, bankSet, new HashSet<String>());

            return minLevel == Integer.MAX_VALUE ? -1 : minLevel;
        }

        void dfs(int level, String curr, String end, HashSet<String> bankSet, HashSet<String> visited) {
            if (curr.equals(end)) {
                minLevel = Math.min(minLevel, level);
                return;
            }

            char[] currArr = curr.toCharArray();
            for (int i = 0; i < currArr.length; i++) {
                char old = currArr[i];

                for (char c : change) {
                    currArr[i] = c;
                    String next = new String(currArr);

                    if (!visited.contains(next) && bankSet.contains(next)) {
                        visited.add(next);
                        dfs(level + 1, next, end, bankSet, visited);
                        visited.remove(next);
                    }
                }

                currArr[i] = old;
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