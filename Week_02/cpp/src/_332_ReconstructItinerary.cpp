#include <map>
#include <string>
#include <set>
#include <vector>
#include <iostream>

using namespace std;

class _332_DFS {
public:
    map<string, multiset<string>> map;
    vector<string> ret;
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        for (auto ticket : tickets) {
            map[ticket[0]].insert(ticket[1]);
        }
        visit("JFK");
        return vector<string>(ret.rbegin(), ret.rend());
    }

    void visit(string u) {
        while (map[u].size()) {
            string v = *map[u].begin();
            map[u].erase(map[u].begin());
            visit(v);
        }
        ret.push_back(u);
    }
};

