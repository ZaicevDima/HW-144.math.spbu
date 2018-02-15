#include <iostream>
using namespace std;

void input(int n, int* a)
{
    cout << "enter array \n";
    for (int i = 0; i < n; i++)
        cin >> a[i];
}

void output(int n, int* a)
{
    cout << "sort array \n";
    for (int i = 0; i < n; i++)
        cout << a[i] <<' ';
}

void qsort(int n, int* a)
{
    int m = n / 2;
    int i = 0;
    int j = n;

    while (i < j)
    {
        while (a[i] < a[m]){
            i++;
        }
        while (a[j] > a[m]){
            j--;
        }
        if (i <= j){
            int x = a[i];
            a[i] = a[j];
            a[j] = x;
            i++;
            j--;
        }
    }

    if (j > 0)
        qsort(j, a);
    if (n > i)
        qsort(n - i, a + i);
}



int main()
{
    int n = 0;
    cout << "enter arrays length \n";
    cin >> n;
    int a[100] = {0};
    input(n, a);
    qsort(n - 1, a);
    output(n, a);
}
