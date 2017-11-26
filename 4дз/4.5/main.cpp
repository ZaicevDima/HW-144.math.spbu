#include <iostream>
#include "stack.h"
#include "postfix.h"
#include <cstring>
#include <stdio.h>
using namespace std;



int main()
{
    char *simbol = new char[256];
    int amount = 0;
    cout << "enter your expression: \n";
    cin.getline(simbol, 256);
    amount = strlen(simbol);
    char result[256] = {};
    int amountSpaces = 0;
    Stack* operation = createStack();
    conversionToPostfix(simbol, result, amount, amountSpaces);

    printResult(result);

    delete[] simbol;
    deleteStack(operation);
}
