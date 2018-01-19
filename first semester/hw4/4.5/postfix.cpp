#include <iostream>
#include <cstring>
#include "postfix.h"
#include "stack.h"
using namespace std;

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
    if ((isEmptyString(operations)) || (top(operations) == '('))
        push(operations, symbol);
    else if ((!isEmptyString(operations)) && (priority(symbol) > priority(top(operations))))
        push(operations, symbol);
    else
    {
        while ((!isEmptyString(operations)) && (top(operations) != '(') &&
               (priority(top(operations)) >= priority(symbol)))
        {
            result[topIndexResult] = top(operations);
            topIndexResult++;
            pop(operations);
        }
        if ((!isEmptyString(operations)) && (top(operations) == '('))
            pop(operations);
        push(operations, symbol);
    }
}

void actionOnOpeningBracket(char symbol, Stack* operations)
{
    push(operations, symbol);
}

void actionOnClosingBracket(char* result, Stack* operations, int& topIndexResult)
{
    while ((!isEmptyString(operations)) && (top(operations) != '('))
    {
        result[topIndexResult] = top(operations);
        topIndexResult++;
        pop(operations);
    }
    if (!isEmptyString(operations))
        pop(operations);
}

void actionOnRemainingOperations(char* result, Stack* operations, int& topIndexResult)
{
    while (!isEmptyString(operations))
    {
        result[topIndexResult] = top(operations);
        topIndexResult++;
        pop(operations);
    }
}

void conversionToPostfix(char* symbols, char* result, int amount)
{
    int topIndexResult = 0;
    Stack* operations = createStack();
    for (int i = 0; i < amount; i++)
    {
        if ((!isOperator(symbols[i])) && (symbols[i] != '(') && (symbols[i] != ')'))
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
            actionOnOpeningBracket(symbols[i], operations);
        }
        else if (symbols[i] == ')')
        {
            actionOnClosingBracket(result, operations, topIndexResult);
        }
        if (i == amount - 1)
        {
            actionOnRemainingOperations(result, operations, topIndexResult);
        }
    }
    deleteStack(operations);
}

bool isDigit(char symbol)
{
    return ((symbol >= '0') && (symbol <= '9'));
}

bool isSpace(char symbol)
{
    return symbol == ' ';
}

int numeral(char symbol)
{
    return symbol - '0';
}

int action(char symbol, int number1, int number2)
{
    if (symbol == '+')
        return number1 + number2;
    if (symbol == '-')
        return number1 - number2;
    if (symbol == '*')
        return number1 * number2;
    if (symbol == '/')
        return number1 / number2;
}

int resultExpression(char* symbols)
{
    int n = strlen(symbols);
    Stack* result = createStack();
    for (int i = 0; i < n; i++)
    {
        if (isDigit(symbols[i]))
            push(result, numeral(symbols[i]));
        else if (!isSpace(symbols[i]))
        {
            int front = top(result);
            pop(result);
            int beforeFront = top(result);
            pop(result);
            int resultOperation = action(symbols[i], beforeFront, front);
            push(result, resultOperation);
        }
    }
    int resultExpression = top(result);

    deleteStack(result);
    return resultExpression;
}
