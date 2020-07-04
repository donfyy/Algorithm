import java.util.*;

/**
 * 第一遍：2020/06/14周日 ✅
 * 第二遍：2020/07/04周六 ✅
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 * 这道题和最小基因变化这道题相似，
 * 从一个单词变化到下一个可选单词有两种方式
 * 1.逐个改变单词中的每个字符
 * 2.遍历字典，找到与当前单词只有一个字符不同的单词
 * 假设单词的长度为l,字典的长度为m,那么如果m * l > 26*l，那么选用1更快。否则选用2更快。
 * 也就是说字典的长度如果比较小的话采用2更快，如果用dfs更快。
 * 这道题字典中单词很多以至于采用2花费的时间是采用1的10倍。
 * 最小基因变化这道题则相反，2比1要快。
 * 这道题采用dfs方式会超时。候选字母太多了。
 */
class _127_WordLadder {
    /**
     * 双向广度优先搜索快啊，20ms左右
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthBfs1(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length() || wordList == null || wordList.isEmpty())
            return 0;
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        HashSet<String> beginLevel = new HashSet<>();
        beginLevel.add(beginWord);
        HashSet<String> endLevel = new HashSet<>();
        endLevel.add(endWord);

        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        int level = 1;
        while (!beginLevel.isEmpty()) {
            HashSet<String> nextLevel = new HashSet<>();

            for (String word : beginLevel) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (old == c) continue;
                        arr[i] = c;
                        String next = String.valueOf(arr);
                        if (endLevel.contains(next)) {
                            return level + 1;
                        }

                        if (wordSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            nextLevel.add(next);
                        }
                    }
                    arr[i] = old;
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

        return 0;
    }

    //这种方式不会超时
    public int ladderLengthBfs(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length() || wordList == null || wordList.isEmpty())
            return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> visited = new HashSet<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            while (levelCount-- > 0) {
                String curr = queue.poll();
                if (curr.intern() == endWord.intern()) {
                    return level + 1;
                }

                char[] arr = curr.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (int j = 'a'; j <= 'z'; j++) {
                        arr[i] = (char) j;
                        String next = new String(arr);

                        if (wordSet.contains(next) && !visited.contains(next)) {
                            //该visited表示已经访问过的所有节点。
                            visited.add(next);//visited的含义是每条路径上已经访问过的节点，而不是已经遍历过的节点，因此所有路径共享同一个visited列表是不对的，虽然说结果是对的。
                            queue.offer(next);
                        }
                    }
                    arr[i] = old;
                }

            }
            level++;
        }

        return 0;
    }

    static class Bfs1 {
        static class Node {
            Node(String val, HashSet<String> visited) {
                this.val = val;
                this.visited = visited;
            }

            String val;
            HashSet<String> visited;//到该单词的路径上已经访问过的单词集合
        }

        /**
         * 超出时间限制。
         *
         * @param beginWord
         * @param endWord
         * @param wordList
         * @return
         */
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (beginWord == null || endWord == null || beginWord.length() != endWord.length() || wordList == null || wordList.isEmpty())
                return 0;

            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(beginWord, new HashSet<String>()));
            HashSet<String> wordSet = new HashSet<>(wordList);

            int level = 0;
            while (!queue.isEmpty()) {
                int levelCount = queue.size();
                while (levelCount-- > 0) {
                    Node node = queue.poll();
                    if (node.val.equals(endWord)) {
                        return level + 1;
                    }

                    char[] arr = node.val.toCharArray();
                    for (int i = 0; i < arr.length; i++) {
                        char old = arr[i];
                        for (int j = 'a'; j <= 'z'; j++) {
                            arr[i] = (char) j;

                            String word = new String(arr);
                            if (!node.visited.contains(word) && wordSet.contains(word)) {
                                HashSet<String> visited = new HashSet<>(node.visited);
                                visited.add(word);

                                queue.offer(new Node(word, visited));
                            }
                           /* if (!node.visited.contains(word) && wordSet.contains(word)) {
                                node.visited.add(word);
                                //共用一个访问列表就不会超时了。这种方式无法求得所有的路径但是可以求得最短路径
                                queue.offer(new Node(word, node.visited));
                            }*/
                        }
                        arr[i] = old;
                    }
                    /*//遍历字典寻找下一个变化单词，这种方式用了831ms，比生成下一个变化单词的方式慢了10倍
                    for (String word : wordList) {
                        int diff = 0;
                        for (int i = 0; i < word.length(); i++) {
                            if (node.val.charAt(i) != word.charAt(i) && ++diff > 1) break;
                        }
                        if (diff == 1 && !node.visited.contains(word)) {
                            node.visited.add(word);
                            queue.offer(new Node(word, node.visited));
                        }
                    }*/
                }
                level++;
            }
            return 0;
        }
    }

    static class RecursiveDfs1 {
        public static void main(String[] args) {
            System.out.println(new RecursiveDfs1().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
//        System.out.println(new Solution().ladderLength("qa", "sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));
            System.out.println(new RecursiveDfs1().ladderLength("qa", "sq", Arrays.asList("qq", "sq")));
        }

        int minLevel = Integer.MAX_VALUE;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (beginWord == null || endWord == null || beginWord.length() != endWord.length() || wordList == null || wordList.isEmpty())
                return 0;

            dfs(beginWord, endWord, wordList, 0, new HashSet<String>());

            return minLevel == Integer.MAX_VALUE ? 0 : minLevel;
        }

        void dfs(String current, String end, List<String> wordList, int level, HashSet<String> visited) {
            if (current.intern() == end.intern()) {
                if (level < minLevel) minLevel = level;
                return;
            }
            if (level == minLevel) return;

            for (String next : wordList) {
                int diff = 0;
                for (int i = 0; i < next.length(); i++) {
                    if (current.charAt(i) != next.charAt(i) && ++diff > 1) break;
                }
                if (diff == 1 && !visited.contains(next)) {
                    visited.add(next);
                    dfs(next, end, wordList, level + 1, visited);
                    visited.remove(next);
                }
            }
        }
    }
}