#include <iostream>
#include "postfix.h"
#include <cstring>
using namespace std;

int main()
{
    char *symbols = new char[256];
    cout << "enter your expression: \n";
    cin.getline(symbols, 256);
    int amountOfSymbols = strlen(symbols);
    char result[256] = {};

    conversionToPostfix(symbols, result, amountOfSymbols);

    cout << "result your expression: \n";
    cout << resultExpression(result) << "\n";

    delete[] symbols;
    return 0;
}

