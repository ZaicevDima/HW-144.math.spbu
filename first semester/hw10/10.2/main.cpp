#include <iostream>
#include <string.h>
#include "rabin.h"

using namespace std;

int main()
{
    char* s1 = new char[1000];
    char* s2 = new char[1000];
    cout << "enter two string: \n";
    cin.getline(s1, 256);
    cin.getline(s2, 256);
    cout << "index start your substring: \n";
    algorithmRabinKarp(s1, s2, 0);
    return 0;
}
