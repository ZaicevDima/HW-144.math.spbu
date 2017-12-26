#include <iostream>
#include <cmath>
#include "binary.h"

using namespace std;

int main()
{
    cout << "enter two numbers: \n";
    int number1 = 0;
    int number2 = 0;
    cin >> number1 >> number2;
    int* binaryNumber1 = binaryTranslation(number1);
    printBinaryTranslation(binaryNumber1);
    cout << "\n";
    int* binaryNumber2 = binaryTranslation(number2);
    printBinaryTranslation(binaryNumber2);
    cout << "\n";
    int* binarySum = sum(binaryNumber1, binaryNumber2);
    cout << "sum : \n";
    printBinaryTranslation(binarySum);
    cout << "\nsum in direct code: \n";
    printToDirectCode(binarySum);

    if (binarySum[maxLength - 1] == 1)
        toDirectCode(binarySum);

    cout <<"\nsum in decimal number system: \n";
    cout << inDecimalSystem(binarySum);

    delete[] binaryNumber1;
    delete[] binaryNumber2;
    delete[] binarySum;
    return 0;
}
