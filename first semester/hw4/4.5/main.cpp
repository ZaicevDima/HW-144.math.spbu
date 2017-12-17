#include <iostream>
#include "postfix.h"
#include <cstring>
using namespace std;

int main()
{
    char *symbols = new char[256];
    int amount = 0;
    cout << "enter your expression: \n";
    cin.getline(symbols, 256);
    amount = strlen(symbols);
    char result[256] = {};
    int amountSpaces = 0;

    conversionToPostfix(symbols, result, amount, amountSpaces);
    printResult(result);

    delete[] symbols;
}
