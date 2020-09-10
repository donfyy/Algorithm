#include <vector>
#include <iostream>
#include <string>

using namespace std;

class Solution
{
public:
    vector<string> ret;
    vector<string> permutation(string s)
    {
        if (s.empty())
            return ret;
        dfs(s, 0);
        return ret;
    }
    void dfs(string &s, int start)
    {
        if (start == s.size() - 1)
        {
            ret.push_back(s);
            return;
        }
        // unordered_set<char> table;
        for (int i = start; i < s.size(); i++)
        {
            // if (table.count(s[i])) continue;
            if (duplicate(s, start, i))
                continue;
            // table.insert(s[i]);
            swap(s[i], s[start]);
            dfs(s, start + 1);
            swap(s[i], s[start]);
        }
    }
    bool duplicate(string &s, int start, int end)
    {
        for (int i = start; i < end; i++)
        {
            if (s[end] == s[i])
                return true;
        }
        return false;
    }
};

int main(int argc, char const *argv[])
{
    cout << "Permutation!" << endl;
    return 0;
}
