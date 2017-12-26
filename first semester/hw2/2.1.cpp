#include <iostream>
using namespace std;

long long fibonacciRecursive(int n)
{
    if ((n == 0) || (n == 1))
        return 1;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

long long fibonacciIterative(int n)
{
    int previous = 1;
    int now = 1;
    int future = 0;
    for (int i = 1; i < n; i++)
    {
        future = now + previous;
        previous = now;
        now = future;
    }
    return now;
}

void output(int n)
{
    cout << n << "\n";
}

int main()
{
    int n = 0;
    cout <<"enter number Fibonacci (F[0] = 1) \n";
    cin >> n;
    cout << "Fibonacci Iterative number " << n <<" = ";
    output(fibonacciIterative(n));
    cout << "Fibonacci Recursive number " << n <<" = ";
    output(fibonacciRecursive(n));
}
