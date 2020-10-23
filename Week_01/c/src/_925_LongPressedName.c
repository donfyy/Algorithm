#include <stdbool.h>
bool isLongPressedName(char *name, char *typed)
{
    const int m = strlen(name), n = strlen(typed);
    int i = 0, j = 0;
    while (j < n)
    {
        if (i < m && name[i] == typed[j])
        {
            i++;
            j++;
        }
        else if (j > 0 && typed[j] == typed[j - 1])
        {
            j++;
        }
        else
        {
            return false;
        }
    }
    return i == m;
}