#include <iostream>
using namespace std;

int main()
{
    int length = 0;
    cout << "enter length \n";
    cin >> length;
    char s[length];
    cout << "enter string \n";
    for (int i = 0; i < length; i++)
        cin >> s[i];
    int errors = 0;
    int i = 0;
    while ((i <= (length / 2)) && (s[i] == s[length - i - 1]))
        i++;
    if (i <= length / 2)
        cout << "is not palindrom \n";
    else
    cout << "is palindrom \n";
}
