#include <iostream>
#include <cstring>
#include "stack.h"
#include "postfix.h"
using namespace std;

int main()
{
    char *symbol = new char[256];
    Stack *result = createStack();
    cout << "enter postfix string: \n";
    cin.getline(symbol, 256, '\n');
    int length = strlen(symbol);
    for (int i = 0; i < length; i++)
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
    cout << "result your postfix string: \n";
    cout << top(result);
    delete[] symbol;
    deleteStack(result);
}
