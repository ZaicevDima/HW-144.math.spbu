#include <iostream>
#include <string.h>
#include "rabin.h"

long long pow(int degree)
{
    int result = 1;
    for (int i = 0; i < degree; i++)
        result = (result * coefficient) % prime;
    return result;
}

int hash(char* string, int length)
{
    int result = 0;
    for (int i = 0; i < length; i++)
        result = ((result * coefficient) % prime + (int)string[i]) % prime;
    return result;
}

bool search(char* string, int start, char* substring)
{
    int length = strlen(substring);
    for (int i = 0; i < length; i++)
        if (string[i + start] != substring[i])
            return false;
    return true;
}

int *algorithmRabinKarp(char* string, char* substring)
{
    int lengthString = strlen(string);
    int lengthSubstring = strlen(substring);
    int hashSubstring = hash(substring, lengthSubstring) % prime;
    int amountContained = 0;
    int *indexes = new int[lengthString];
    for (int i = 0; i < lengthString; i++)
        indexes[i] = -1;
    int currentHash = hash(string, lengthSubstring) % prime;
    int power = pow(lengthSubstring);
    int j = 0;
    for (int i = 0; i < lengthString - lengthSubstring + 1; i++)
    {
        if (i != 0)
        {
            int newPart = (int)string[i + lengthSubstring - 1];
            currentHash = ((((currentHash * coefficient) - (int)string[i - 1] * power) % prime
                           + prime) % prime  + newPart) % prime;
        }

        if ((currentHash == hashSubstring) && (search(string, i, substring)))
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
    if (i == 0)
        std::cout << "this string does not contain this substring";
    std::cout << "\n";
}
