#include <iostream>
#include <string.h>
#include "rabin.h"

using namespace std;

int main()
{
    const int maxSize = 100000;
    char* string = new char[maxSize];
    char* substring = new char[maxSize];
    cout << "enter your string and substring: \n";
    cin >> string;
    cin >> substring;
    cout << "index start your substring: \n";
    int *indexes = algorithmRabinKarp(string, substring);
    printIndexes(indexes, strlen(string));

    delete [] indexes;
    delete [] string;
    delete [] substring;
    return 0;
}
