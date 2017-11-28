#include <iostream>
#include <cmath>
#include "bynary.h"
using namespace std;

void printBinaryTranslation(bool* bytes)
{
    for (int i = maxLength - 1; i >= 0; i--)
        cout << bytes[i];
}

bool* binaryTranslation(int number)
{
    bool *bytes = new bool[maxLength + 1];
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

bool* sum(bool* number1,bool* number2)
{
    bool* number = new bool[maxLength];
    fill(number, number + maxLength, 0);
    bool carry = false;
    for (int i = 0; i < maxLength; i++)
    {
        if (carry)
        {
            if (!(number1[i] ^ number2[i]) && (number1[i] & number2[i]))
                number[i] = 1;
            if ((number1[i] ^ number2[i]))
                number[i] = 0;
            if (!(number1[i] ^ number2[i]) && !(number1[i] & number2[i]))
            {
                carry = false;
                number[i] = 1;
            }
            continue;
        }
        number[i] = number1[i] ^ number2[i];
        if (number1[i] & number2[i])
            carry = true;
    }

    if (carry)
    {
        bool *overcoming = new bool[maxLength];
        fill(overcoming, overcoming + maxLength, 0);
        overcoming[0] = 1;
        sum(number, overcoming);
    }
    return number;
}

int inDecimalSystem(bool* bytes)
{
    int number = 0;
    for (int i = 0;i < maxLength; i++)
        number += bytes[i] * pow(2, i);
    return number;
}

void printToDirectCode(bool* bytes)
{
    for (int i = maxLength - 1; i >= 0; i--)
        cout << (bytes[i] == 0);
}
