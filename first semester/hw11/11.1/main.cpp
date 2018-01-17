#include <iostream>
#include <string.h>

using namespace std;

bool isDigit(char symbol)
{
    return ((symbol >= '0') && (symbol <= '9'));
}

bool isSign(char symbol)
{
    return ((symbol == '+') || (symbol == '-'));
}

bool isPoint(char symbol)
{
    return (symbol == '.');
}

bool isExponent(char symbol)
{
    return (symbol == 'E');
}

bool isRealNumber(char* digits)
{
    enum {start, afterSign, integer, afterPoint, real, exponent, signE, afterSignE, realWithE, fail};
    int state = start;
    int i = 0;
    while (i < strlen(digits))
    {
        char current = digits[i];
        switch (state)
        {
        case start:
            if (isSign(current))
                state = afterSign;
            else if (isDigit(current))
                state = integer;
            else
                state = fail;
            break;
        case afterSign:
            if (isDigit(current))
                state = integer;
            else
                state = fail;
        case integer:
            if (isDigit(current))
                state = integer;
            else if (isPoint(current))
            {
                state = afterPoint;
            }
            else if (isExponent(current))
                state = exponent;
            else
                state = fail;
            break;
        case afterPoint:
            if (isDigit(current))
                state = real;
            else
                state = fail;
            break;
        case real:
            if (isDigit(current))
                state = real;
            else if (isExponent(current))
                state = exponent;
            else
                state = fail;
            break;
        case exponent:
            if (isSign(current))
            {
                state = signE;
            }
            else if (isDigit(current))
                state = real;
            else
                state = fail;
            break;
        case signE:
            if (isSign(current))
                state = afterSignE;
            else if (isDigit(current))
                state = realWithE;
            else
                state = fail;
            break;
        case afterSignE:
            if (isSign(current))
                state = realWithE;
            else
                state = fail;
            break;
        case realWithE:
            if (!isDigit(current))
                state = fail;
            break;
        default :
            break;
        }
        i++;
    }
    return ((state == real) || (state == integer) || (state == realWithE));
}

int main()
{
    cout << "enter string:" <<  endl;
    char* string = new char[1000];
    for (int i = 0; i < 1000; i++)
        string[i] = ' ';
    cin >> string;

    if (isRealNumber(string))
        cout << "it's a real number" ;
    else
        cout << "it is not a real number";

    delete [] string;
    return 0;
}
