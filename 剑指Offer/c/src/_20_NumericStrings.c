#include <stdio.h>
#include <stdbool.h>

#define trim(s) while (*s == ' ') s++
bool scanInteger(char** s);
bool scanUnsignedInteger(char** s);
bool isNumber(char* s){
    if (s == NULL) return false;
    trim(s);
    bool numeric = scanInteger(&s);
    if (*s == '.') {
        s++;
        numeric = scanUnsignedInteger(&s) || numeric;
    }
    if (*s == 'e' || *s == 'E') {
        s++;
        numeric = numeric && scanInteger(&s);
    }
    trim(s);
    return numeric && *s == '\0';
}
bool scanInteger(char** s) {
    if (**s == '+' || **s == '-') {
        (*s)++;
    }
    return scanUnsignedInteger(s);
}
bool scanUnsignedInteger(char** s) {
    char* pBefore = *s;
    while (**s && **s >= '0' && **s <= '9') {
        (*s)++;
    }
    return *s > pBefore;
}
int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}
