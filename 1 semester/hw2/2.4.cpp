#include <iostream>
using namespace std;

bool isMutual(int a, int b)
{
    for (int i = 2; i <= min(a, b); i++)
        if ((a % i == 0) && (b % i == 0))
            return false;
    return true;
}

void qsort(int n, int* a, int* b)
{
    int m = n / 2;
    int i = 0;
    int j = n;

    while (i < j)
    {
        while (a[i] * b[m] < a[m] * b[i]){
            i++;
        }
        while (a[j] * b[m] > a[m] * b[j]){
            j--;
        }
        if (i <= j){
            swap(a[i], a[j]);
            swap(b[i], b[j]);

            i++;
            j--;
        }
    }

    if (j > 0)
        qsort(j, a, b);
    if (n > i)
        qsort(n - i, a + i, b + i);
}


int main()
{
    int n = 0;
    cout << "enter number n \n";
    cin >> n;
    int numerator[1000] = {0};
    int denominator[1000] = {0};
    int k = 0;

    for (int i = 1; i < n; i++)
        for (int j = 2; j <= n; j++)
        {
            if (isMutual(i, j) && (i < j))
            {
                numerator[k] = i;
                denominator[k] = j;
                k++;
            }
        }
    cout << "fractions from 0 to 1: \n";
    cout << 0 <<"/" << 1 <<"\n";
    qsort(k - 1, numerator, denominator);
    for (int i = 0; i < k; i++)
        cout << numerator[i] << '/' << denominator[i] <<"\n";
    cout << 1 <<"/" << 1;
}
