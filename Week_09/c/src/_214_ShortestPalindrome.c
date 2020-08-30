#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define D 256
#define Q 1000000007
char * shortestPalindrome(char * s){
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

int main() {
	printf("ret = %s\n", shortestPalindrome("aacecaaa"));
}
