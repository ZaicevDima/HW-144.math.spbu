#include <iostream>
using namespace std;

int recursiveFactorial(int n)
{
    if ((n == 0) || (n == 1))
        return 1;
    return n * recursiveFactorial(n - 1);
}

int interactiveFactorial(int n)
{
    int i = 1;
    int factorial = 1;
    while (i <= n)
    {
        factorial *= i;
        i++;
    }
    return factorial;
}

int main()
{
    cout << "enter n \n";
    int n = 0;
    cin >> n;
    cout << "recursive factorial = " << recursiveFactorial(n) << "\n";
    cout << "interactive factorial = " << interactiveFactorial(n) <<"\n";
}
