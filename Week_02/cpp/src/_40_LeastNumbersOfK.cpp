#include <vector>
#include <queue>
#include <iostream>
using namespace std;

class UsingPartition
{
public:
    // 时间O(n)， 空间O(1)
    vector<int> getLeastNumbers(vector<int> &arr, int k)
    {
        if (k < 1)
            return vector<int>(0);
        int start = 0, end = arr.size() - 1;
        int idx = partition(arr, start, end);
        while (idx != k - 1)
        {
            if (idx < k - 1)
            {
                start = idx + 1;
            }
            else
            {
                end = idx - 1;
            }
            idx = partition(arr, start, end);
        }
        vector<int> ret(k);
        for (int i = 0; i < k; i++)
        {
            ret[i] = arr[i];
        }
        return ret;
    }

    int partition(vector<int> &arr, int start, int end)
    {
        if (start >= end)
            return end;
        int pivot = arr[end];
        int j = start - 1;
        for (int i = start; i < end; i++)
        {
            if (arr[i] < pivot)
                swap(arr[i], arr[++j]);
        }
        swap(arr[end], arr[++j]);
        return j;
    }
};

class UsingHeap
{
public:
    vector<int> getLeastNumbers(vector<int> &arr, int k)
    {
        if (k < 1)
            return vector<int>(0);
        vector<int> ret(k);
        priority_queue<int> heap;
        for (int i = 0; i < arr.size(); i++)
        {
            if (heap.size() < k)
            {
                heap.push(arr[i]);
            }
            else
            {
                if (arr[i] < heap.top())
                {
                    heap.pop();
                    heap.push(arr[i]);
                }
            }
        }
        for (int i = 0; i < k; i++)
        {
            ret[i] = heap.top();
            heap.pop();
        }
        return ret;
    }
};

int main(int argc, char const *argv[])
{
    cout << "least numbers of k" << endl;
    return 0;
}
