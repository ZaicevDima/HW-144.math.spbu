#include <iostream>
#include <cstring>
#include "postfix.h"
#include "stack.h"
using namespace std;

bool isDigit(char symbol)
{
    if (symbol >= '0' && symbol <= '9')
        return true;
    return false;
}

bool isSpace(char symbol)
{
    return (symbol == ' ');
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

void printResult(char* symbol)
{
    int n = strlen(symbol);
    Stack* result = createStack();
    for (int i = 0; i < n; i++)
    {
        if (isDigit(symbol[i]))
            push(result, numeral(symbol[i]));
        else if(!isSpace(symbol[i]))
        {
            int front = top(result);
            pop(result);
            int beforeFront = top(result);
            pop(result);
            int resultOperation = action(symbol[i], beforeFront, front);
            push(result, resultOperation);
        }
    }
    cout << "result your expression: \n";
    cout << top(result);
}
