#include <iostream>
#include <cmath>
#include "bynary.h"

using namespace std;

int main()
{
    cout << "enter two numbers: \n";
    int number1 = 0;
    int number2 = 0;
    cin >> number1 >> number2;
    bool* bynaryNumber1 = binaryTranslation(number1);
    printBinaryTranslation(bynaryNumber1);
    cout << "\n";
    bool* bynaryNumber2 = binaryTranslation(number2);
    printBinaryTranslation(bynaryNumber2);
    cout << "\n";
    bool*  bynarySum= sum(bynaryNumber1, bynaryNumber2);
    cout << "sum : \n";
    printBinaryTranslation(bynarySum);
    cout << "\nsum in direct code: \n";
    printToDirectCode(bynarySum);

    delete[] bynaryNumber1;
    delete[] bynaryNumber2;
    delete[] bynarySum;
    return 0;
}
