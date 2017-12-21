#include <iostream>
#include <string.h>
#include "rabin.h"

long long pow(int degree)
{
    int result = 1;
    for (int i = 0; i < degree; i++)
        result = (result * d) % p;
    return result ;
}

int mod(int number1, int number2)
{
    return (number1 + number2) % number2;
}

int hash(char* string, int length)
{
    int result = 0;
    for (int i = 0; i < length - 1; i++)
        result = (result + (int)string[i]) * d;
    return result + (int)string[length - 1];
}

bool search(char* string1, int start, char* string2)
{
    int length = strlen(string2);
    for (int i = 0; i < length; i++)
        if(string1[i + start] != string2[i])
            return false;
    return true;
}

void algorithmRabinKarp(char* string, char* substring, int amountContained)
{
    int lengthString = strlen(string);
    int lengthSubstring = strlen(substring);
    int h = hash(string, lengthSubstring) % p;
    for (int i = 0; i <= lengthString - lengthSubstring; i++)
    {
        if (i != 0)
            h = mod((h - mod((int)string[i - 1] * (pow(lengthSubstring - 1)), p)) * d + (int)string[i + lengthSubstring - 1], p);
        if (h == mod(hash(substring, lengthSubstring), p) && (search(string, i, substring)))
        {
            amountContained++;
            std::cout << i << " ";
        }
    }
    if (amountContained == 0)
        std::cout << "this is string does not contain this substring";
}
