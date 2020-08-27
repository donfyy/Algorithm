#include <iostream>

using namespace std;

class _201_BitwiseAndOfNumbersRange {
public:
    int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n = n & n - 1;
        }
        return n;
    }
};

int main() {
    _201_BitwiseAndOfNumbersRange r;
    int ret = r.rangeBitwiseAnd(5, 7);
    cout << ret << "\n";
}
