#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main(int argc, char const *argv[])
{
    int fd;
    char c;
    fd = open("foobar.txt", O_RDONLY, 0);
    if (fork() == 0) {
        read(fd, &c, 1);
        return 0;
    }
    wait(NULL);
    read(fd, &c, 1);
    printf("c = %c\n", c);

    return 0;
}
