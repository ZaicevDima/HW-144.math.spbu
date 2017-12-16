#include <iostream>
#include <cstring>
#include <fstream>
#include "stack.h"
#include "postfix.h"
using namespace std;

int main()
{
    char *symbols = new char[256];
    int amount = 0;
    int i = 0;
    cout << "enter your exppression: \n";
    cin.getline(symbols, 256);
    amount = strlen(symbols);
    char *result = new char[256];
    int amountSpaces = 0;

    conversionToPostfix(symbols, result, amount, amountSpaces);
    cout << "postfix form: \n";
    for (i = 0; i < amount - amountSpaces; i++)
        cout << result[i] <<' ';

    delete []symbols;
    delete []result;
}
