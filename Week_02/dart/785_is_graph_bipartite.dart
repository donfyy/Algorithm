import 'dart:collection';

void main(List<String> args) {
  print(Solution().isBipartite([
    [2, 2, 3],
    [0, 2],
    [0, 1, 3],
    [0, 2]
  ]));
  print(Solution().isBipartite([
    [1, 3],
    [0, 2],
    [1, 3],
    [0, 2]
  ]));

  print("-----------------");

  print(Solution2().isBipartite([
    [2, 2, 3],
    [0, 2],
    [0, 1, 3],
    [0, 2]
  ]));
  print(Solution2().isBipartite([
    [1, 3],
    [0, 2],
    [1, 3],
    [0, 2]
  ]));
}

class Solution2 {
  bool isBipartite(List<List<int>> graph) {
    final color = List.filled(graph.length, 0);
    for (int i = 0; i < graph.length; i++) {
      if (color[i] != 0) {
        continue;
      }
      color[i] = 1;
      if (!dfs(color, graph, i)) return false;
    }

    return true;
  }

  bool dfs(List<int> color, List<List<int>> graph, int i) {
    for (final j in graph[i]) {
      if (color[j] == 0) {
        color[j] = -color[i];
        if (!dfs(color, graph, j)) return false;
      } else if (color[j] == color[i]) {
        return false;
      }
    }
    return true;
  }
}

class Solution {
  bool isBipartite(List<List<int>> graph) {
    final color = List.filled(graph.length, 0);
    final q = Queue<int>();
    for (int i = 0; i < graph.length; i++) {
      if (color[i] != 0) {
        continue;
      }
      color[i] = 1;
      q.add(i);
      while (q.isNotEmpty) {
        final n = q.removeFirst();
        for (final j in graph[n]) {
          if (color[j] == 0) {
            q.add(j);
            color[j] = -color[n];
          } else if (color[j] == color[n]) {
            return false;
          }
        }
      }
    }

    return true;
  }
}
