#include <iostream>
using namespace std;
int main()
{
    int a = 0;
    int b = 0;
    cout << "enter divided - a \n";
    cin >> a;
    cout << "enter divider - b \n";
    cin >> b;
    int absA = a;
    int absB = b;
    if (a < 0)
        absA = - a;
    if (b < 0)
        absB = - b;
    int x = 0;
    while (absA >= 0)
    {
        absA -= absB;
        x++;
    }
    cout << "incomplete quotient = ";
    if (a * b > 0)
        cout << x - 1 << "\n";
    else
        cout << 1 - x << "\n";
}
