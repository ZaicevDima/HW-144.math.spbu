#include <iostream>
#include "stack.h"
#include "postfix.h"
#include <cstring>
#include <stdio.h>
using namespace std;

int main()
{
    char *symbols = new char[256];
    int amount = 0;
    cout << "enter your expression: \n";
    cin.getline(symbols, 256);
    amount = strlen(symbols);
    char* result = new char[256];
    int amountSpaces = 0;
    Stack* operation = createStack();
    conversionToPostfix(symbols, result, amount, amountSpaces);
    printResult(result);

    delete[] symbols;
    deleteStack(operation);
}
