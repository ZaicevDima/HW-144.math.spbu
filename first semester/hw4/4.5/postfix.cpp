#include <iostream>
#include <cstring>
#include "postfix.h"
#include "stack.h"
using namespace std;

bool isOperator(char symbol)
{
    return (symbol == '*') || (symbol == '+') || (symbol == '-') || (symbol == '/');
}

int priority (char symbol)
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

void conversionToPostfix(char* symbols, char* result, int amount, int &amountSpaces)
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
            if ((isEmpty(operations)) || (top(operations) == '('))
                push(operations, symbols[i]);
            else if ((!isEmpty(operations)) && (priority(symbols[i]) > priority(top(operations))))
                push(operations, symbols[i]);
            else
            {
                while ((!isEmpty(operations)) && (top(operations) != '(') && (priority(top(operations)) >= priority(symbols[i])))
                {
                    result[topIndexResult] = top(operations);
                    topIndexResult++;
                    pop(operations);
                }
                if ((!isEmpty(operations)) && (top(operations) == '('))
                    pop(operations);
                push(operations, symbols[i]);
            }
        }
        else if (symbols[i] == '(')
        {
            push(operations, symbols[i]);
            amountSpaces++;
        }
        else if (symbols[i] == ')')
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
        if (i == amount - 1)
        {
            while (!isEmpty(operations))
            {
                result[topIndexResult] = top(operations);
                topIndexResult++;
                pop(operations);
            }
        }
    }
    deleteStack(operations);
}

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

int action(char symbol)
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

void printResult(char* symbols)
{
    int n = strlen(symbols);
    Stack* result = createStack();
    for (int i = 0; i < n; i++)
    {
        if (isDigit(symbols[i]))
            push(result, action(symbols[i]));
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
    cout << "result your expression: \n";
    cout << top(result);

}
