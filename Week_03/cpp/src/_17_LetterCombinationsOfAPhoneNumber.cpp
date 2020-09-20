#include <unordered_map>
#include <vector>
using namespace std;
class UsingDfs
{
public:
    unordered_map<char, string> table{
        {'2', "abc"},
        {'3', "def"},
        {'4', "ghi"},
        {'5', "jkl"},
        {'6', "mno"},
        {'7', "pqrs"},
        {'8', "tuv"},
        {'9', "wxyz"}};
    vector<string> ret;
    // O(3^n*4^m) O(n + m) n 字符串中有4个字符组合的数字个数，m 字符串中有4个字符组合的数字个数
    vector<string> letterCombinations(string digits)
    {
        if (digits.empty())
            return ret;
        string path;
        dfs(digits, 0, path);
        return ret;
    }
    void dfs(string &digits, int idx, string &path)
    {
        if (idx == digits.size())
        {
            ret.push_back(path);
            return;
        }
        auto &letters = table[digits[idx]];
        for (auto &ch : letters)
        {
            path.push_back(ch);
            dfs(digits, idx + 1, path);
            path.pop_back();
        }
    }
};