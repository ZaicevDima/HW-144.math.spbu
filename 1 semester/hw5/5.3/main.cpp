#include <iostream>
#include "polynmial.h"

using namespace std;

int main()
{
    cout << "enter degree your polinomial: \n";
    int degree = 0;
    cin >> degree;
    int *coefficients = new int[degree + 1];
    cout << "enter coefficients your polinomial: \n";
    for (int i = 0; i < degree + 1; i++)
        cin >> coefficients[i];
    cout << "your polinomial: \n";
    printDegrees(degree, coefficients);
    cout << "\n";
    printCoefficients(degree, coefficients);

    delete [] coefficients;
    return 0;
}
