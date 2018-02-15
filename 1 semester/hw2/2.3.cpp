#include <iostream>
using namespace std;

void printSums(int n, int newTerm, int* term, int numberTerms)
{
    if (n == 0)
    {
        for (int i = 0; i < (numberTerms - 1); i++)
            cout << term[i] << " + ";
        cout << term[numberTerms - 1] << "\n";
        return;
    }

    for (int i = newTerm; i <= n; i++)
    {
        if ((n - i) < 0)
            return;
        term[numberTerms] = i;
        printSums(n - i, i, term, numberTerms + 1);
    }
}
int main()
{
    int n = 0;
    cout << "Enter a natural number: \n";
    cin >> n;
    int term[100] = {0};
    cout << "All presentations of n as summation of natural numbers below: \n";
    printSums(n, 1, term, 0);
}
