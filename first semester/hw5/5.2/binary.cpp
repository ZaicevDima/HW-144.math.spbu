#include <iostream>
#include <cmath>
#include "binary.h"
using namespace std;

void printBinaryTranslation(int* bytes)
{
    for (int i = maxLength - 1; i >= 0; i--)
        cout << bytes[i];
}

int* binaryTranslation(int number)
{
    int *bits = new int[maxLength];
    int mask = 1;
    for (int i = 0; i < maxLength; i++)
    {
        if (number & mask)
            bits[i] = 1;
        else
            bits[i] = 0;
        mask = mask << 1;
    }
    return bits;
}

int* sum(int* number1, int* number2)
{
    int* number = new int[maxLength];
    fill(number, number + maxLength, 0);
    bool isCarry = false;
    for (int i = 0; i < maxLength; i++)
    {
        if (isCarry)
        {
            if (!(number1[i] ^ number2[i]) && (number1[i] & number2[i]))
                number[i] = 1;
            if ((number1[i] ^ number2[i]))
                number[i] = 0;
            if (!(number1[i] ^ number2[i]) && !(number1[i] & number2[i]))
            {
                isCarry = false;
                number[i] = 1;
            }
            continue;
        }
        number[i] = number1[i] ^ number2[i];
        if (number1[i] & number2[i])
            isCarry = true;
    }

    if (isCarry)
    {
        int *overcoming = new int[maxLength];
        fill(overcoming, overcoming + maxLength, 0);
        overcoming[0] = 1;
        sum(number, overcoming);
        delete [] overcoming;
    }
    return number;
}

int inDecimalSystem(int* bits)
{
        int degree = 1;
        int result = 0;
        for (int i = 0; i < 32; i++)
        {
            result += bits[i] * degree;
            degree = degree << 1;
        }
        return result;
}
