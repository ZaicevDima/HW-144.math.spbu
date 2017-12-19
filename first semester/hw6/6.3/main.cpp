#include <iostream>
#include "phonebook.h"
#include <string>

using namespace std;

void input(char* string)
{
    cin.getline(string, 256, '\n');
}

void menu()
{
    cout << "enter operation: \n";
    cout << "0 - Exit \n";
    cout << "1 - Add \n";
    cout << "2 - Find phone \n";
    cout << "3 - Find name \n";
    cout << "4 - Save \n \n";
}

int main()
{
    int operation = 0;
    PhoneBook *book = createPhonebook();
    menu();
    cin >> operation;
    while (operation != 0)
    {
        bool isError = true;
        if (operation == 1)
        {
            isError = false;
            cout << "enter name and phone \n";
            char* name = new char[256];
            char* number = new char[256];
            input(name);
            input(number);
            add(name, number, book);
            menu();
            cin >> operation;
        }
        if (operation == 2)
        {
            isError = true;
            cout << "enter name\n";
            char* name = new char[256];
            input(name);
            numberSearch(name, book);
        }
        if (operation == 3)
        {
            isError = true;
            cout << "enter number\n";
            char* number = new char[256];
            input(number);
            nameSearch(number, book);
            menu();
            cin >> operation;
        }
        if (operation == 4)
        {
            isError = true;
            upload(book);
            menu();
            cin >> operation;
        }
        if (isError)
        {
            cout << "Error, enter the correct operations: \n";
            menu();
            cin >> operation;
        }
    }

    return 0;
}
