#include <iostream>
#include <string.h>
#include "rabin.h"

long long pow(int degree)
{
    int result = 1;
    for (int i = 0; i < degree; i++)
        result = (result * coefficient) % prime;
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
        result = (result + (int)string[i]) * coefficient;
    return result + (int)string[length - 1];
}

bool search(char* string, int start, char* substring)
{
    int length = strlen(substring);
    for (int i = 0; i < length; i++)
        if(string[i + start] != substring[i])
            return false;
    return true;
}

int *algorithmRabinKarp(char* string, char* substring)
{
    int lengthString = strlen(string);
    int lengthSubstring = strlen(substring);
    int amountContained = 0;
    int *indexes = new int[lengthString];
    for (int i = 0; i < lengthString; i++)
        indexes[i] = -1;
    int h = hash(string, lengthSubstring) % prime;
    int j = 0;
    for (int i = 0; i <= lengthString - lengthSubstring; i++)
    {
        if (i != 0)
        {
            int newPart = (int)string[i + lengthSubstring - 1];
            int change = (h - mod((int)string[i - 1] * (pow(lengthSubstring - 1)), prime)) * coefficient + newPart;
            h = mod(change, prime);
        }
        if (h == mod(hash(substring, lengthSubstring), prime) && (search(string, i, substring)))
        {
            amountContained++;
            indexes[j] = i;
            j++;
        }
    }

    return indexes;
}

void printIndexes(int* indexes, int size)
{
    int i = 0;
    while ((indexes[i] != -1) && (i < size))
    {
        std::cout << indexes[i] << ' ';
        i++;
    }
    if (!i)
        std::cout << "this is string does not contain this substring";
    std::cout << "\n";
}
