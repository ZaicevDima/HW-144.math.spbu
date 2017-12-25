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
    int *bytes = new int[maxLength + 1];
    fill(bytes, bytes + maxLength, 0);
    if (number < 0)
    {
        bytes = binaryTranslation(abs(number));
        for (int i = 0; i < maxLength; i++)
            bytes[i] = !bytes[i];
        return bytes;
    }
    int length = 0;
    while (number > 0)
    {
        bytes[length] = (number % 2 != 0);
        number = number >> 1;
        length++;
    };
    return bytes;
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

int inDecimalSystem(int* bytes)
{
    int number = 0;
    for (int i = 0; i < maxLength; i++)
        number += bytes[i] * pow(2, i);
    return number;
}

void printToDirectCode(int* bytes)
{
    for (int i = maxLength - 1; i >= 0; i--)
        cout << (bytes[i] == 0);
}
