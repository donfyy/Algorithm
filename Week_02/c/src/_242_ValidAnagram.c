#include <stdio.h>
#include <stdbool.h>

#define MAP_LEN 26
bool isAnagram(char *s, char *t)
{
    if (s == NULL || t == NULL)
        return false;
    int map[MAP_LEN] = {0};
    while (*s)
    {
        map[*s - 'a']++;
        s++;
    }
    while (*t)
    {
        map[*t - 'a']--;
        t++;
    }
    for (int i = 0; i < MAP_LEN; i++)
    {
        if (map[i] != 0)
            return false;
    }
    return true;
}