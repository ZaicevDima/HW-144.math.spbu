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
    cout << "2 - search number \n";
    cout << "3 - search name \n";
    cout << "4 - save \n";
}

bool isCorrectNumber(char *number)
{
    for (int i = 0; i < strlen(number); i++)
        if ((number[i] < '0') || (number[i] > '9'))
            return false;
    return true;
}

long long toLongLong(char *recordNumber)
{
    long long number = 0;
    for (int i = 0; i < strlen(recordNumber); i++)
        number = number * 10 + (int)(recordNumber[i] - '0');
    return number;
}

void addContact(PhoneBook *book)
{
    char* name = new char[256];
    char* recordNumber = new char[20];
    long long number = 0;
    cout << "enter name and number: ";
    cin >> name;
    cin >> recordNumber;
    while (!isCorrectNumber(recordNumber))
    {
        std::cout << "enter correct number \n";
        cin >> recordNumber;
    }

    number = toLongLong(recordNumber);
    add(name, number, book);

    delete [] name;
    delete [] recordNumber;
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
    char* recordNumber = new char[20];
    long long number = 0;

    cin >> recordNumber;
    while (!isCorrectNumber(recordNumber))
    {
        std::cout << "enter correct number \n";
        cin >> recordNumber;
    }
    number = toLongLong(recordNumber);

    char* name = nameSearch(number, book);
    if ((name[0] == ' ') && (strlen(name) == 1))
        cout << "not found \n";
    else
        cout << "name: " << name << "\n";

    delete [] recordNumber;
}

void printToFile(PhoneBook *book)
{
    saveBook(book);
    cout << "your phonebook saved \n";
}
