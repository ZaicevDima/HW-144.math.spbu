#include <iostream>
using namespace std;

void invert(int* a, int l, int r)
{
    for (int i = l; i <= (r + l) / 2; i++)
    {
        int x = a[i];
        a[i] = a[r - i + l];
        a[r - i + l] = x;
    }
}

int main()
{
    int n = 0;
    int m = 0;
    int const k = 1000;
    int a[k] = {0};
    cout <<"enter lengths first array, second array \n";
    cin >> m >> n;
    for (int i = 0; i < n + m; i++)
        cin >> a[i];
    invert(a, 0, m - 1);
    invert(a, m, m + n - 1);
    invert(a, 0, m + n - 1);
    cout <<"inverted array: ";
    for (int i = 0; i < n + m; i++)
        cout << a[i] << ' ';
}
