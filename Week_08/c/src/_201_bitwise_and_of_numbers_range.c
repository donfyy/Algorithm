#include <stdio.h>
int rangeBitwiseAnd(int, int);
int main() {
    printf("%d\n", rangeBitwiseAnd(5, 7));
}
int rangeBitwiseAnd(int m, int n){
    int shift = 0;
    while (m != n) {
        m >>= 1;
        n >>= 1;
        shift++;
    }
    return n << shift;
}