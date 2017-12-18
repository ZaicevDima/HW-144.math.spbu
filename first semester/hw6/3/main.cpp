#include <iostream>
#include "phonebook.h"

using namespace std;

void input(char* string)
{
    cin.getline(string, 256, ' ');
}

void menu()
{
    cout << "enter operation: \n";
    cout << "menu: \n";
    cout << "0 - Exit \n";
    cout << "1 - Add \n";
    cout << "2 - Find phone \n";
    cout << "3 - Find name \n";
    cout << "4 - Save \n";
}

int main()
{
    int operation = 0;
    PhoneBook *book = createPhonebook();
    menu();
    cin >> operation;
    while (operation != 0)
    {
        if (operation == 1)
        {
            cout << "enter name and phone \n";
            char* name = new char[256];
            char* number = new char[256];
            input(name);
            input(number);
            add(name, number, book);
            cin >> operation;
        }
        if (operation == 2)
        {
            cout << "enter name\n";
            char* name = new char[256];
            cin.getline(name, 256, ' ');
            numberSearch(name, book);
            cin >> operation;
        }
        if (operation == 3)
        {
            cout << "enter number\n";
            char* number = new char[256];
            input(number);
            nameSearch(number, book);
            cin >> operation;
        }
        if (operation == 4)
        {
            upload(book);
            cin >> operation;
        }
    }
}
