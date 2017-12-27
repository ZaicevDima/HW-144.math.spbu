#include <iostream>
#include <cmath>
#include "binary.h"

using namespace std;

/*int *toBits(int number)
{
    int *bits = new int[32];
    int mask = 1;
    for (int i = 0; i < 32; i++)
    {
        if (number & mask)
            bits[i] = 1;
        else
            bits[i] = 0;
        mask = mask << 1;
    }
    return bits;
}

void printBits(int *number)
{
    for (int i = 31; i >= 0; i--)
    {
        cout << number[i];
    }
}

int toNumber(int *bits)
{
    int degree = 1;
    int result = 0;
    for (int i = 0; i < 32; i++)
    {
        result += bits[i] * degree;
        degree = degree << 1;
    }
    return result;
}*/

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
    cout << "\n";

    int sumInDec = inDecimalSystem(binarySum);
    cout << sumInDec;

    delete[] binaryNumber1;
    delete[] binaryNumber2;
    delete[] binarySum;
    return 0;
}
