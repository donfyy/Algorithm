#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define D 256
#define Q 1000000007
char * shortestPalindromeRabinKarp(char * s){
     long long l = 0, r = 0, m = 1;
     const int n = strlen(s);
     int rM = 0;
     for (int i = 0; i < n; i++) {
         l = (l * D + s[i]) % Q;
         r = (r + m * s[i]) % Q;
         m = m * D % Q;
         if (l == r) {
             rM = i;
         }
     }
     char * ret = malloc((n + n - rM) * sizeof(char));
     int i = n - 1, j = 0;
     while (i > rM) {
         ret[j++] = s[i--];
     }
     i = 0;
     while (i < n) {
	 	 // 少写了++，运行时提示AddressSanitizer: heap-buffer-overflow
		 // 花了1个小时的时间，我去成本太高了，烦。
         ret[j++] = s[i++];
     }
	 ret[j] = 0;
     return ret;
}

char *shortestPalindromeKmp(char *s)
{
    const int n = strlen(s);
    if (n == 0)
        return s;
    // int *lps = malloc((n + 1) * sizeof(int)), i = 1, j = 0; // = { -1 } variable-sized object may not be initialized
    int lps[n + 1], i = 1, j = 0; // = { -1 } variable-sized object may not be initialized
    lps[0] = -1;
    lps[1] = 0;
    while (i < n)
    {
        if (s[i] == s[j])
        {
            lps[++i] = ++j;
        }
        else if (j > 0)
        {
            j = lps[j];
        }
        else
        {
            lps[++i] = 0;
        }
    }

    i = n - 1;
    j = 0;
    while (i >= 0)
    {
        if (s[j] == s[i])
        {
            i--;
            j++;
        }
        else if (j > 0)
        {
            j = lps[j];
        }
        else
        {
            i--;
        }
    }

    j = n - j;
    char *ret = malloc((n + j + 1) * sizeof(char));
    for (i = 0; i < j; i++)
    {
        ret[i] = s[n - 1 - i];
    }
    for (i = 0; i <= n; i++)
    {
        ret[i + j] = s[i];
    }
    return ret;
}

int main() {
    char * ret = shortestPalindromeKmp("aacecaaa");
    printf("ret = %s\n", ret);
    free(ret);
    ret = NULL;
}
