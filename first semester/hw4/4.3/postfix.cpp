#include <iostream>
#include "postfix.h"

bool isOperator(char k)
{
    return (k == '*') || (k == '+') || (k == '-') || (k == '/');
}

int prioritet (char k)
{
    if (k == '(')
        return 0;
    if (k == ')')
        return 1;
    if ((k == '+') || (k == '-'))
        return 2;
    if ((k == '*') || (k == '/'))
        return 3;
}

void conversionToPostfix(char* simbol, char* result, int amount, int &amountSpaces)
{
    int topIndexResult = 0;
    Stack* operations = createStack();
    for (int i = 0; i < amount; i++)
    {
        if (simbol[i] == ' ')
            amountSpaces++;
        else if ((!isOperator(simbol[i])) && (simbol[i] != '(') && (simbol[i] != ')'))
        {
            result[topIndexResult] = simbol[i];
            topIndexResult++;
        }
        else if (isOperator(simbol[i]))
        {
            if ((isEmpty(operations)) || (top(operations) == '('))
                push(operations, simbol[i]);
            else if ((!isEmpty(operations)) && (prioritet(simbol[i]) > prioritet(top(operations))))
                push(operations, simbol[i]);
            else
            {
                while ((!isEmpty(operations)) && (top(operations) != '(') && (prioritet(top(operations)) >= prioritet(simbol[i])))
                {
                    result[topIndexResult] = top(operations);
                    topIndexResult++;
                    pop(operations);
                }
                if ((!isEmpty(operations)) && (top(operations) == '('))
                    pop(operations);
                push(operations, simbol[i]);
            }
        }
        else if (simbol[i] == '(')
            push(operations, simbol[i]);
        else if (simbol[i] == ')')
        {
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
