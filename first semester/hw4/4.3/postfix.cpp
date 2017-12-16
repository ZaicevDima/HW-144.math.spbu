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
