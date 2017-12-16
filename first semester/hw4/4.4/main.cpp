#include <iostream>
#include <cstring>
#include "stack.h"
#include "postfix.h"
using namespace std;

int main()
{
    char *symbols = new char[256];
    Stack *result = createStack();
    cout << "enter postfix string: \n";
    cin.getline(symbols, 256, '\n');
    int length = strlen(symbols);
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
    cout << "result your postfix string: \n";
    cout << top(result);
    delete[] symbols;
    deleteStack(result);
}
