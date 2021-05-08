#include <vector>
#include <unordered_set>
#include <iostream>

using namespace std;

int solution(vector<int> nums) {
    unordered_set<int> s(nums.begin(), nums.end());
    return min(nums.size() / 2, s.size());
}

int main() {
    vector<int> v = { 3, 2, 1, 4 };
    cout << solution(v);
}