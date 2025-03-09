#include <iostream>

using namespace std;

int check(int n) {
    if (n % 3 > 0) {
        return 1;
    } else {
        return 0;
    }
}

int result(int r, int c) {
    int y = int(r / 3) + check(r);
    int x = int(c / 3) + check(c);
    return (r * c) - (y * x);
}

int main() {
    int r;
    int c;
    cin >> r >> c;
    cout << result(r, c) << endl;
}
