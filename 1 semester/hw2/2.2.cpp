#include <iostream>
using namespace std;

int degree(int a, int n)
{
    if (n == 1)
        return a;
    if (n % 2 == 0)
        return degree(a, n / 2) * degree(a, n / 2);
    return a * degree(a, n - 1);
}

int main()
{
    int n = 0;
    int a = 0;
    cout << "enter a and degree - n \n";
    cin >> a >> n;
    cout << a <<'^'<< n <<" = " << degree(a, n);
}
