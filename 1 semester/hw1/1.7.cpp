#include <iostream>
using namespace std;

void fill (bool* a, int n, int fillable, int step)
{
    for (int i = 0; i < n; i += step)
        a[i] = fillable;
}

void siev (bool* number, int n)
{
    for (int i = 2; i < n; i++)
    {
        if (not number[i])
        {
            fill (number, n, 1, i);
            number[i] = 0;
        }
    }
}
int main()
{
    int const n = 100;
    bool number[n];
    fill(number, n, 0, 1);
    siev(number, n);
    cout <<"Prime numbers to " << n <<": \n";
    for (int i = 2; i < n; i++)
    {
        if (not number[i])
            cout << i <<" ";
    }
}
