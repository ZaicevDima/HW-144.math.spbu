#include <iostream>
#include <string.h>

using namespace std;

bool isNumber(char symbol)
{
    return ((symbol >= '0') && (symbol <= '9'));
}

bool isSignNextNumber(char* string, int index)
{
    int size = strlen(string);
    return ((string[index] == '+') || (string[index] == '-')) &&
            ((index + 1 < size) && isNumber(string[index + 1]));
}

bool isPointNextNumber(char* string, int index)
{
    int size = strlen(string);
    return (string[index] == '.') && (index + 1 < size) && (isNumber(string[index + 1]));
}

bool isExponent(char symbol)
{
    return (symbol == 'E');
}

bool isRealNumber(char* number)
{
    int state = 0;
    int length = strlen(number);
    for (int i = 0; i < length; i++)
    {
        char next = number[i];
        switch (state)
        {
        case 0:
            if (isSignNextNumber(number, i))
            {
                i++;
                state = 1;
            }
            else if (isNumber(next))
                state = 1;
            else
                return false;
            break;
        case 1:
            if (isNumber(next))
                state = 1;
            else if (isPointNextNumber(number, i))
            {
                i++;
                state = 2;
            }
            else if (isExponent(next))
                state = 3;
            else
                return false;
            break;
        case 2:
            if (isNumber(next))
                state = 2;
            else if (isExponent(next))
                state = 3;
            else
                return false;
            break;
        case 3:
            if (isSignNextNumber(number, i))
            {
                i++;
                state = 4;
            }
            else if (isNumber(next))
                state = 4;
            else
                return false;
            break;
        case 4:
            if (isNumber(next))
                state = 4;
            else
                return false;
            break;
        }
    }
    return (state == 1) || (state == 2) || (state == 4);
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
