#include <vector>
using namespace std;
class UnionFind
{
private:
    vector<int> parent;
    vector<int> rank;
    int count;

public:
    UnionFind(vector<vector<char>> &grid) : count(0)
    {
        int m = grid.size(), n = grid[0].size();
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    parent.push_back(i * n + j);
                    count++;
                }
                else
                {
                    parent.push_back(-1);
                }
                rank.push_back(0);
            }
        }
    }

    int find(int x)
    {
        int root = x;
        while (root != parent[root])
        {
            root = parent[root];
        }
        while (parent[x] != root)
        {
            int p = parent[x];
            parent[x] = root;
            x = p;
        }
        return root;
    }

    void unite(int x, int y)
    {
        int p = find(x);
        int q = find(y);
        if (q != p)
        {
            if (rank[p] < rank[q])
            {
                swap(p, q);
            }
            parent[q] = p;
            if (rank[p] == rank[q])
            {
                rank[p]++;
            }
            count--;
        }
    }

    int getCount() const
    {
        return count;
    }
};
class Solution
{
public:
    // O(mn * alpha(mn)) O(mn)
    int numIslands(vector<vector<char>> &grid)
    {
        if (grid.empty() || grid[0].empty())
            return 0;
        vector<pair<int, int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        UnionFind uf(grid);
        int m = grid.size(), n = grid[0].size();
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '0')
                {
                    continue;
                }
                for (auto &[di, dj] : dirs)
                {
                    int u = di + i, v = dj + j;
                    if (u >= 0 && u < m && v >= 0 && v < n && grid[u][v] == '1')
                    {
                        uf.unite(i * n + j, u * n + v);
                    }
                }
            }
        }
        return uf.getCount();
    }
};
