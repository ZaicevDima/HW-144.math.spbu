#include <iostream>
#include <string.h>
#include "rabin.h"

using namespace std;

int main()
{
    cout << "enter max size of your string: \n";
    int maxSize = 0;
    cin >> maxSize;
    char* s1 = new char[maxSize];
    char* s2 = new char[maxSize];
    cin.get();
    cout << "enter two string: \n";
    cin.getline(s1, maxSize);
    cin.getline(s2, maxSize);
    cout << "index start your substring: \n";
    algorithmRabinKarp(s1, s2, 0);

    delete [] s1;
    delete [] s2;
    return 0;
}
