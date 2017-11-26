#include <iostream>
#include <cstring>
#include <fstream>
#include "stack.h"
#include "postfix.h"
using namespace std;

int main()
{
    char *simbol = new char[256];
    int amount = 0;
    int i = 0;
    cout << "enter your exppression: \n";
    cin.getline(simbol, 256);
    amount = strlen(simbol);
    char *result = new char[256];
    int amountSpaces = 0;

    conversionToPostfix(simbol, result, amount, amountSpaces);
    cout << "postfix form: \n";
    for (i = 0; i < amount - amountSpaces - 2; i++)
        cout << result[i] <<' ';

    delete []simbol;
    delete []result;
}

