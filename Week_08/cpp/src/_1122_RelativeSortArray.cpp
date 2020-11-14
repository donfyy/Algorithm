#include <vector>
#include <unordered_map>
using namespace std;
class CustomComparator
{
public:
    vector<int> relativeSortArray(vector<int> &arr1, vector<int> &arr2)
    {
        // 自定义比较函数
        // 由于arr2定义了元素的比较顺序，因此我们使用哈希表进行映射
        unordered_map<int, int> rank;
        for (int i = 0; i < arr2.size(); i++)
        {
            rank[arr2[i]] = i;
        }
        sort(arr1.begin(), arr1.end(), [&](int x, int y) {
            if (rank.count(x))
            {
                return rank.count(y) ? rank[x] < rank[y] : true;
            }
            return rank.count(y) ? false : x < y;
        });
        return arr1;
    }
};
class UsingCountingSort
{
public:
    vector<int> relativeSortArray(vector<int> &arr1, vector<int> &arr2)
    {
        // 由于数组中的值的范围在[0, 1000]，因此可以使用计数排序
        // 将arr1中的元素放到桶中
        // 按照arr2中元素的相对顺序从桶中取出元素放在arr1中
        // 在依次从桶中取出元素放到arr1中
        const auto [pLower, pUpper] = minmax_element(arr1.begin(), arr1.end());
        const int lower = *pLower, upper = *pUpper;
        vector<int> bucket(upper - lower + 1);
        for (int it : arr1)
        {
            bucket[it - lower]++;
        }
        int j = 0;
        for (int it : arr2)
        {
            while (bucket[it - lower])
            {
                arr1[j++] = it;
                bucket[it - lower]--;
            }
        }
        for (int i = 0; i < upper - lower + 1; i++)
        {
            while (bucket[i]--)
            {
                arr1[j++] = i + lower;
            }
        }
        return arr1;
    }
};