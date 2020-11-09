#include <vector>
using namespace std;
class UsingPartition
{
public:
    vector<vector<int>> kClosest(vector<vector<int>> &points, int k)
    {
        // TopK问题
        // partition
        int l = 0, r = points.size() - 1;
        int idx = partition(points, l, r);
        while (idx != k - 1)
        {
            if (idx < k - 1)
            {
                l = idx + 1;
            }
            else
            {
                r = idx - 1;
            }
            idx = partition(points, l, r);
        }
        return {points.begin(), points.begin() + k};
    }

    int partition(vector<vector<int>> &points, int l, int r)
    {
        if (l >= r)
            return l;
        int j = l - 1;
        for (int i = l; i < r; i++)
        {
            int rk = points[r][0] * points[r][0] + points[r][1] * points[r][1];
            int ik = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (ik < rk)
            {
                swap(points[i], points[++j]);
            }
        }
        swap(points[r], points[++j]);
        return j;
    }
};