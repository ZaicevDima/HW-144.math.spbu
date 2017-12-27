#include <iostream>
using namespace std;

int main()
{
    int const n = 27;
    int a[n];

    for (int i = 0; i < n; i++)
    {
        a[i] = 0;
    }

    for (int i = 0; i <= 9; i++)
        for (int j = 0; j <= 9; j++)
            for (int k = 0; k <= 9; k++)
            {
                a[i + j + k]++;
            }

    int sum = 0;
    for (int i = 0; i < n; i++)
    {
        sum += a[i] * a[i];
    }
    cout <<"Lucky tickets = " << sum;
}
