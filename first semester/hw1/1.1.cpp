#include <iostream>
using namespace std;

int main()
{
    int x = 0;
    cout <<"x^4 + x^3 + x^2 + x + 1\n";
    cout <<"Enter x \n";
    cin >> x;
    int sqr = x * x;
    int sum = 1 + (sqr + 1) * (x + sqr);
    cout <<"x^4 + x^3 + x^2 + x + 1 = " << sum;
}
