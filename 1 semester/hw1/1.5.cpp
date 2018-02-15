#include <iostream>
using namespace std;

int main()
{
    int const n = 1000;
    char s[n] = {0};
    int balanceOpen = 0;
    int errors = 0;
    int length = 0;
    cout <<"enter quantity of brackets \n";
    cin >> length;
    for (int i = 0; i < length; i++)
    {
        cin >> s[i];
        if (s[i] == '(')
            balanceOpen++;
        if (s[i] == ')')
            balanceOpen--;
        if (balanceOpen < 0)
        {
            errors++;
            break;
        }
    }
    if ((balanceOpen == 0) && (errors == 0))
        cout << "correct bracket sequence \n";
    else
        cout <<"incorrect bracket sequence \n";
}
