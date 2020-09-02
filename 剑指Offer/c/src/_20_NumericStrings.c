#include <stdio.h>
#include <stdbool.h>

bool scanInteger(const char **s);
bool scanUnsignedInteger(const char **s);
void trim(const char **s);
bool isNumber(const char *s)
{
    if (s == NULL)
        return false;
    trim(&s);
    bool numeric = scanInteger(&s);
    if (*s == '.')
    {
        s++;
        numeric = scanUnsignedInteger(&s) || numeric;
    }
    if (*s == 'e' || *s == 'E')
    {
        s++;
        numeric = numeric && scanInteger(&s);
    }
    trim(&s);
    return numeric && *s == '\0';
}

bool scanInteger(const char **s)
{
    if (**s == '+' || **s == '-')
        (*s)++;
    return scanUnsignedInteger(s);
}

bool scanUnsignedInteger(const char **s)
{
    const char *pBefore = *s;
    while (**s && **s >= '0' && **s <= '9')
        (*s)++;
    return *s > pBefore;
}

void trim(const char **s)
{
    while (**s == ' ')
        (*s)++;
}

int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}
