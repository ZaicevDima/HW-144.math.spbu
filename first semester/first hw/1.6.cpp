#include <iostream>
using namespace std;

int main()
{
    int len1 = 0, len2 = 0;
    cout << "enter length first string and second string ";
    cin >> len1 >> len2;
    char s[len1], s1[len2];
    cout << "enter first string ";
    for (int i = 0; i < len1; i++)
        cin >> s[i];
    cout << "enter second string ";
    for (int i = 0; i < len2; i++)
        cin >> s1[i];
    int errors = 0;
    int times = 0;
    for (int i = 0; i < len1 - len2 + 1; i++)
    {
        errors = 0;
        for (int j = 0; j < len2; j++)
        {
            if (s[i + j] != s1[j])
            errors++;
        }
        if (errors == 0)
            times++;
    }
    cout << "second string is in first string " << times <<" times \n";
}
