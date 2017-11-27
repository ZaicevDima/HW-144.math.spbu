#include <iostream>
#include <cstring>
#include "stack.h"
#include "postfix.h"
using namespace std;

int main()
{
    char *simbol = new char[256];
    Stack *result = createStack();
    cout << "enter postfix string: \n";
    cin.getline(simbol, 256, '\n');
    int length = strlen(simbol);
    for (int i = 0; i < length; i++)
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
    cout << "result your postfix string: \n";
    cout << top(result);
    delete[] simbol;
    deleteStack(result);
}
