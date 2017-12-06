#include <iostream>
#include <string.h>
#include "rabin.h"

using namespace std;

int main()
{
    char* s1 = new char[10];
    char* s2 = new char[3];
    cout << "enter two string: \n";
    cin.getline(s1, 256);
    cin.getline(s2, 256);
    cout << "index start your substring: \n";
    algRabinKarp(s1, s2, strlen(s1), strlen(s2));
    return 0;
}

