#include <stdio.h>
#include <string.h>

int main(int argc, char const *argv[])
{
    char *s = NULL; // EXC_BAD_ACCESS
    // char *s = "hi";
    printf("strlen(NULL) = %d", strlen(s));
    return 0;
}
