#include <iostream>
#include "postfix.h"

bool isOperator(char symbol)
{
    return (symbol == '*') || (symbol == '+') || (symbol == '-') || (symbol == '/');
}

int priority(char symbol)
{
    if (symbol == '(')
        return 0;
    if (symbol == ')')
        return 1;
    if ((symbol == '+') || (symbol == '-'))
        return 2;
    if ((symbol == '*') || (symbol == '/'))
        return 3;
}

void actionOnOperator(char symbol, char* result, Stack* operations, int& topIndexResult)
{
    if ((isEmpty(operations)) || (top(operations) == '('))
        push(operations, symbol);
    else if ((!isEmpty(operations)) && (priority(symbol) > priority(top(operations))))
        push(operations, symbol);
    else
    {
        while ((!isEmpty(operations)) && (top(operations) != '(') &&
               (priority(top(operations)) >= priority(symbol)))
        {
            result[topIndexResult] = top(operations);
            topIndexResult++;
            pop(operations);
        }
        if ((!isEmpty(operations)) && (top(operations) == '('))
            pop(operations);
        push(operations, symbol);
    }
}

void actionOnOpeningBracket(char symbol, Stack* operations, int& amountSpaces)
{
    push(operations, symbol);
    amountSpaces++;
}

void actionOnClosingBracket(char* result, Stack* operations, int& amountSpaces, int& topIndexResult)
{
    amountSpaces++;
    while ((!isEmpty(operations)) && (top(operations) != '(' ))
    {
        result[topIndexResult] = top(operations);
        topIndexResult++;
        pop(operations);
    }
    if (!isEmpty(operations))
        pop(operations);
}

void actionOnRemainingOperations(char* result, Stack* operations, int& topIndexResult)
{
    while (!isEmpty(operations))
    {
        result[topIndexResult] = top(operations);
        topIndexResult++;
        pop(operations);
    }
}

void conversionToPostfix(char* symbols, char* result, int amount, int& amountSpaces)
{
    int topIndexResult = 0;
    Stack* operations = createStack();
    for (int i = 0; i < amount; i++)
    {
        if (symbols[i] == ' ')
            amountSpaces++;
        else if ((!isOperator(symbols[i])) && (symbols[i] != '(') && (symbols[i] != ')'))
        {
            result[topIndexResult] = symbols[i];
            topIndexResult++;
        }
        else if (isOperator(symbols[i]))
        {
            actionOnOperator(symbols[i], result, operations, topIndexResult);
        }
        else if (symbols[i] == '(')
        {
            actionOnOpeningBracket(symbols[i], operations, amountSpaces);
        }
        else if (symbols[i] == ')')
        {
            actionOnClosingBracket(result, operations, amountSpaces, topIndexResult);
        }
        if (i == amount - 1)
        {
            actionOnRemainingOperations(result, operations, topIndexResult);
        }
    }
    deleteStack(operations);
}
