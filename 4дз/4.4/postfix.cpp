#include <iostream>
#include <cstring>
#include "postfix.h"
#include "stack.h"
using namespace std;

bool isDigit(char simbol)
{
    if (simbol >= '0' && simbol <= '9')
        return true;
    return false;
}

bool isSpace(char simbol)
{
    return (simbol == ' ');
}

int numeral(char simbol)
{
    return simbol - '0';
}

int action(char simbol, int number1, int number2)
{
    if (simbol == '+')
        return number1 + number2;

    if (simbol == '-')
        return number1 - number2;

    if (simbol == '*')
        return number1 * number2;

    if (simbol == '/')
        return number1 / number2;
}

void printResult(char* simbol)
{
    int n = strlen(simbol);
    Stack* result = createStack();
    for (int i = 0; i < n; i++)
    {
        if (isDigit(simbol[i]))
            push(result, numeral(simbol[i]));
        else if(!isSpace(simbol[i]))
        {
            int front = top(result);
            pop(result);
            int beforeFront = top(result);
            pop(result);
            int resultOperation = action(simbol[i], beforeFront, front);
            push(result, resultOperation);
        }
    }
    cout << "result your expression: \n";
    cout << top(result);
}
