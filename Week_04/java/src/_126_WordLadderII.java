import java.util.*;

/**
 * 第一遍：2020/06/14周日 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 */
class _126_WordLadderII {
    static class BidirectionalBfsWithSuccessors {
        public static void main(String[] args) {
            System.out.println(new BidirectionalBfsWithSuccessors().findLadders(
                    "hit",
                    "cog",
                    Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")
            ));
        }

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            if (beginWord == null || endWord == null || beginWord.length() != endWord.length() || wordList == null || wordList.isEmpty())
                return Collections.emptyList();
            HashSet<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) return Collections.emptyList();

            Map<String, Set<String>> successors = new HashMap<>();
            boolean found = bidirectionalBfs(beginWord, endWord, wordSet, successors);
            if (!found) return Collections.emptyList();

            List<List<String>> ret = new LinkedList<>();
            LinkedList<String> path = new LinkedList<>();
            path.add(beginWord);
            dfs(beginWord, endWord, path, ret, successors);
            return ret;
        }

        void dfs(String beginWord, String endWord, LinkedList<String> path, List<List<String>> ret, Map<String, Set<String>> successors) {
            if (beginWord.equals(endWord)) {
                ret.add(new ArrayList<>(path));
                return;
            }
            Set<String> successor = successors.get(beginWord);
            if (successor == null) {
                return;
            }
            for (String next : successor) {
                path.offerLast(next);
                dfs(next, endWord, path, ret, successors);
                path.pollLast();
            }
        }

        boolean bidirectionalBfs(String beginWord, String endWord, HashSet<String> wordSet, Map<String, Set<String>> successors) {
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);

            HashSet<String> beginVisited = new HashSet<>();
            beginVisited.add(beginWord);
            HashSet<String> endVisited = new HashSet<>();
            endVisited.add(endWord);
            HashSet<String> visited = new HashSet<>();
            visited.add(beginWord);
            visited.add(endWord);

            boolean found = false;
            boolean forward = true;
            int length = beginWord.length();
            while (!beginVisited.isEmpty()) {
                HashSet<String> nlVisited = new HashSet<>();
                for (String curr : beginVisited) {
                    char[] arr = curr.toCharArray();
                    for (int i = 0; i < length; i++) {
                        char old = arr[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (old == c) continue;
                            arr[i] = c;

                            String next = String.valueOf(arr);

                            if (wordSet.contains(next)) {
                                if (endVisited.contains(next)) {
                                    found = true;
                                    addToSuccessors(successors, curr, next, forward);
                                }
                                if (!visited.contains(next)) {
                                    nlVisited.add(next);
                                    addToSuccessors(successors, curr, next, forward);
                                }
                            }
                        }
                        arr[i] = old;
                    }
                }

                if (found) {
                    break;
                }
                visited.addAll(nlVisited);
                if (nlVisited.size() > endVisited.size()) {
                    beginVisited = endVisited;
                    endVisited = nlVisited;
                    forward = !forward;
                } else {
                    beginVisited = nlVisited;
                }
            }
            return found;
        }

        void addToSuccessors(Map<String, Set<String>> successors, String curr, String next, boolean forward) {
            if (!forward) {
                String temp = curr;
                curr = next;
                next = temp;
            }
            Set<String> successor = successors.computeIfAbsent(curr, k -> new HashSet<>());
            successor.add(next);
        }
    }

    static class BfsWithSuccessors {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            //广度优先搜索，先生成邻接表，再由邻接表生成最短路径
            if (beginWord == null || endWord == null || beginWord.length() != endWord.length() || wordList == null || wordList.isEmpty())
                return Collections.emptyList();

            HashSet<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) return Collections.emptyList();

            Map<String, Set<String>> successors = new HashMap<>();
            boolean found = bfs(beginWord, endWord, wordSet, successors);
            if (!found) return Collections.emptyList();

            List<List<String>> ret = new LinkedList<>();
            LinkedList<String> path = new LinkedList<>();
            path.add(beginWord);
            dfs(beginWord, endWord, path, successors, ret);
            return ret;
        }

        boolean bfs(String beginWord, String endWord, HashSet<String> wordSet, Map<String, Set<String>> successors) {
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);

            HashSet<String> visited = new HashSet<>();
            HashSet<String> nextLevelVisited = new HashSet<>();
            visited.add(beginWord);

            int length = beginWord.length();
            boolean found = false;
            while (!queue.isEmpty()) {
                int levelCount = queue.size();
                while (levelCount-- > 0) {
                    String current = queue.poll();

                    char[] arr = current.toCharArray();
                    for (int i = 0; i < length; i++) {
                        char old = arr[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            //这一个判断提升了30%的速度其实也就50ms
                            if (old == c) continue;
                            arr[i] = c;
                            String next = String.valueOf(arr);
                            if (next.equals(endWord)) found = true;

                            if (wordSet.contains(next) && !visited.contains(next)) {
                                nextLevelVisited.add(next);
                                queue.offer(next);

                                Set<String> set = successors.computeIfAbsent(current, k -> new HashSet<String>());
                                set.add(next);
                            }

                        }
                        arr[i] = old;
                    }
                }

                if (found) break;
                visited.addAll(nextLevelVisited);
                nextLevelVisited.clear();
            }
            return found;
        }

        void dfs(String current, String endWord, LinkedList<String> path, Map<String, Set<String>> successors, List<List<String>> ret) {
            if (current.equals(endWord)) {
                ret.add(new ArrayList<String>(path));
                return;
            }

            for (String next : successors.getOrDefault(current, Collections.emptySet())) {
                path.offerLast(next);
                dfs(next, endWord, path, successors, ret);
                path.pollLast();
            }
        }
    }
}