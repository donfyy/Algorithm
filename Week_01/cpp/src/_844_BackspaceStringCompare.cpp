#include <string>
using namespace std;
class Solution
{
public:
    // 要学会逆向思考，正向做比较麻烦的时候可以尝试下逆向
    // O(m + n) O(1)
    // 当前的字符是否被删掉只取决于后面的字符，而与前面的字符无关
    bool backspaceCompare(string S, string T)
    {
        // 从后向前比较, i, j分别指向S与T的最后一个字符
        // 当i指向了#的时候，记录#的个数，向前移动i，消费掉当前记录的所有#，i才停止
        // 然后继续比较i和j
        int i = S.size() - 1, j = T.size() - 1;
        int iCnt = 0, jCnt = 0;
        while (i >= 0 && j >= 0)
        {
            correct(&i, &iCnt, S);
            correct(&j, &jCnt, T);
            if (i >= 0 && j >= 0 && S[i--] != T[j--])
            {
                return false;
            }
        }
        correct(&i, &iCnt, S);
        correct(&j, &jCnt, T);
        return i == -1 && j == -1;
    }
    void correct(int *i, int *iCnt, string &S)
    {
        while (*i >= 0 && (S[*i] == '#' || *iCnt > 0))
        {
            if (S[(*i)--] == '#')
            {
                (*iCnt)++;
            }
            else
            {
                (*iCnt)--;
            }
        }
        if (*iCnt)
            *iCnt = 0;
    }
};