#include <iostream>
#include "postfix.h"

bool isOperator(char k)
{
    return (k == '*') || (k == '+') || (k == '-') || (k == '/');
}

int prior (char k)
{
    if (k == '(')
        return 0;
    if (k == ')')
        return 1;
    if (k == '+' || k == '-')
        return 2;
    if (k == '*' || k == '/')
        return 3;
}

void conversionToPostfix(char* simbol, char* result, int amount, int &amountSpaces)
{
    int topIndexResult = 0;
    Stack* operation = createStack();
    for (int i = 0; i < amount; i++)
    {
        if (simbol[i] == ' ')
            amountSpaces++;
        else if (!isOperator(simbol[i]) && simbol[i] != '(' && simbol[i] != ')')
        {
            result[topIndexResult] = simbol[i];
            topIndexResult++;
        }
        else if (isOperator(simbol[i]))
        {
            if (isEmpty(operation) || top(operation) == '(')
                push(operation, simbol[i]);
            else if (!isEmpty(operation) && prior(simbol[i]) > prior(top(operation)))
                push(operation, simbol[i]);
            else
            {
                while (!isEmpty(operation) && top(operation) != '(' && prior(top(operation)) >= prior(simbol[i]))
                {
                    result[topIndexResult] = top(operation);
                    topIndexResult++;
                    pop(operation);
                }
                if (!isEmpty(operation) && top(operation) == '(')
                    pop(operation);
                push(operation, simbol[i]);
            }
        }
        else if (simbol[i] == '(')
            push(operation, simbol[i]);
        else if (simbol[i] == ')')
        {
            while (!isEmpty(operation) && top(operation) != '(' )
            {
                result[topIndexResult] = top(operation);
                topIndexResult++;
                pop(operation);
            }
            if (!isEmpty(operation))
                pop(operation);
        }
        if (i == amount - 1)
        {
            while (!isEmpty(operation))
            {
                result[topIndexResult] = top(operation);
                topIndexResult++;
                pop(operation);
            }
        }
    }
    deleteStack(operation);
}
