#include <iostream>
using namespace std;

int main()
{
    int a = 0;
    int n = 0;
    cout << "enter a and degree - n \n";
    cin >> a >> n;
    int i = 1;
    int degree = a;
    while (i < n)
    {
        degree *= a;
        i++;
    }
    cout << a <<'^'<< n <<" = " << degree;
}
