#include "rabin.h"
#include <iostream>

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

bool search(char* string1,int start,char* string2, int length)
{
    for (int i = 0; i < length; i++)
        if(string1[i + start] != string2[i])
            return false;
    return true;
}

void algRabinKarp(char* string, char* subString, int length1, int length2)
{
    int h = hash(string, length2) % p;
    for (int i = 0; i <= length1 - length2; i++)
    {
        if (i != 0)
            h = mod((h - mod((int)string[i - 1] * (pow(length2 - 1)), p)) * d + (int)string[i + length2 - 1], p);
        if (h == mod(hash(subString, length2), p) && (search(string, i, subString, length2)))
            std::cout << i << " ";
    }
}
