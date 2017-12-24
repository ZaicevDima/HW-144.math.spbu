#include <iostream>
#include <cstring>
#include "postfix.h"
using namespace std;

int main()
{
    char *symbols = new char[256];
    cout << "enter postfix string: \n";
    cin.getline(symbols, 256, '\n');
    cout << "result of your expression: \n";
    cout << result(symbols);

    delete[] symbols;
    return 0;
}
