#include <iostream>
#include <vector>
#include "_332_ReconstructItinerary.cpp"

using namespace std;

vector<string> get() {
    vector<string> v1;
    v1.push_back("hi");
    cout << "v1 %p = " << &v1 << endl;
    vector<string> v2;
    v2.push_back("hi1");
    v2.push_back("hi2");
    cout << "v2 %p = " << &v2 << endl;
    return v2;
}

vector<string> op(vector<string> v3) {
    cout << "v3 %p = " << &v3 << endl;
    for (auto  i = 0; i < 1000; i++) {
        v3.push_back("aaaaaa");
    }
    return v3;
}

int main() {
    auto v2 = get();
    cout << "v2[0]" << v2[0] << endl;
    v2.push_back("thx");
    cout << "v2 %p = " << &v2 << endl;
    cout << "size = " << v2.size() << endl;
    v2 = op(v2);
    cout << "v2 %p = " << &v2 << endl;
    cout << "size = " << v2.size() << endl;
    cout << "v2[0]" << v2[0] << endl;
    return 1;
}