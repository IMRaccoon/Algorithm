#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int answer = 0;
    for (int i = 0; i < 5; i++) {
        int t;
        cin >> t;
        answer += pow(t, 2);
    }
    cout << answer % 10;
}