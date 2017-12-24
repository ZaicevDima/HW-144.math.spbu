#include <iostream>
#include <cstring>
#include "postfix.h"
#include "stack.h"
using namespace std;

bool isDigit(char symbol)
{
    return (symbol >= '0') && (symbol <= '9');
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

int result(char* symbols)
{
    int length = strlen(symbols);
    Stack* result = createStack();
    for (int i = 0; i < length; i++)
    {
        if (isDigit(symbols[i]))
            push(result, numeral(symbols[i]));
        else if(!isSpace(symbols[i]))
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
