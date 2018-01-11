#include <iostream>
#include "phonebook.h"
#include "output.h"
#include <string.h>
using namespace std;

void menu()
{
    cout << "menu: \n";
    cout << "0 - exit \n";
    cout << "1 - fill \n";
    cout << "2 - sort \n";
    cout << "3 - reverse \n";
    cout << "4 - avarage value \n";
}

void fill(PhoneBook *book)
{
    char* name = new char[256];
    long long number = 0;
    cout << "enter name and number: ";
    cin >> name;
    cin >> number;
    add(name, number, book);
    delete [] name;
}

void numberSearch(PhoneBook *book)
{
    char* name = new char[256];
    cout << "enter name: ";
    cin >> name;
    long long number = numberSearch(name, book);
    if (number == -1)
        cout << "not found \n";
    else
        cout << "number: " << number << "\n";
    delete [] name;
}

void nameSearch(PhoneBook *book)
{
    cout << "enter number: ";
    long long number = 0;
    cin >> number;
    char* name = nameSearch(number, book);
    if ((name[0] == ' ') && (strlen(name) == 1))
        cout << "not found \n";
    else
        cout << "name: " << name << "\n";
}

void printToFile(PhoneBook *book)
{
    saveBook(book);
    cout << "your phonebook saved \n";
}
