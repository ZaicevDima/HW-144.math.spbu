#include <iostream>
#include <string.h>
#include "rabin.h"

using namespace std;

int main()
{
    int maxSize = 100000;
    char* s1 = new char[maxSize];
    char* s2 = new char[maxSize];
    cout << "enter two string: \n";
    cin >> s1;
    cin >> s2;
    cout << "index start your substring: \n";
    algorithmRabinKarp(s1, s2, 0);

    delete [] s1;
    delete [] s2;
    return 0;
}
