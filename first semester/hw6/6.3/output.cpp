#pragma once

#include <iostream>
#include "phonebook.h"
#include "output.h"
#include <string.h>
using namespace std;

void menu()
{
    cout << "menu: \n";
    cout << "0 - exit \n";
    cout << "1 - add \n";
    cout << "2 - searh number \n";
    cout << "3 - search name \n";
    cout << "4 - save \n";
}

void addContact(PhoneBook *book)
{
    char* name = new char[256];
    long long value = 0;
    cout << "enter name and number: ";
    cin >> name;
    cin >> value;
    add(name, value, book);
}

void numberSearch(PhoneBook *book)
{
    char* name = new char[256];
    cout << "enter name: ";
    cin >> name;
    long long value = numberSearch(name, book);
    if (value == -1)
        cout << "not fount" << endl;
    else
        cout << "number: " << value << endl;
}

void nameSearch(PhoneBook *book)
{
    cout << "enter number: ";
    long long value = 0;
    cin >> value;
    char* name = nameSearch(value, book);
    if (name[0] == ' ' && strlen(name) == 1)
        cout << "not fount" << endl;
    else
        cout << "name: " << name << endl;
}

void printToFile(PhoneBook *book)
{
    saveBook(book);
    cout << "your phonebook seved \n";
}



