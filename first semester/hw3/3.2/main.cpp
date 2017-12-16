#include <iostream>
#include "stringsort.h"
using namespace std;

void input(int length, char* string)
{
    for (int i = 0; i < length; i++)
        cin >> string[i];
}

int main()
{
    cout << "enter length first and second string \n";
    int length1 = 0;
    int length2 = 0;
    cin >> length1 >> length2;
    int const size = 100;
    char string1[size] = {};
    char string2[size] = {};
    cout << "enter first string\n";
    input(length1, string1);
    cout << "enter second string\n";
    input(length2, string2);
    if (length1 == length2)
    {
        sort(length1 - 1, string1);
        sort(length2 - 1, string2);
        int i = 0;
        while ((string1[i] == string2[i]) && (i < length1))
        {
            i++;
        }
        if (i == length1)
            cout << "It is possible to receive from the first line the second";
        else
            cout << "It is impossible to receive from the first line the second";
    }
    else
        cout << "It is impossible to receive from the first line the second";
}
