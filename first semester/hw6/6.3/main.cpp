#include <iostream>
#include <fstream>
#include "phonebook.h"
#include <string.h>

using namespace std;

char *input()
{
    char *line = new char[1000];
    cin.getline(line, 1000);
    return line;
}

int main()
{
    PhoneBook *book = loadPhoneBook();

    cout << "menu: \n";
    cout << "0 - exit \n";
    cout << "1 - add \n";
    cout << "2 - search number \n";
    cout << "3 - search name \n";
    cout << "4 - save \n";

    enum  Command {exit, addContact, searchNumberContact, searchNameContact, print};

    int operation = 0;
    cin >> operation;
    cin.ignore();

    while (operation)
    {
        char *name = nullptr;
        char *number = nullptr;
        switch (operation)
        {
        case exit:
            break;
        case addContact:
            cout << "enter name: \n";
            name = input();
            cout << "enter phone: \n";
            number = input();
            add(name, number, book);
            break;
        case searchNumberContact:
            cout << "enter name: \n";
            name = input();
            cout << "number: " << numberSearch(name, book) << "\n";

            delete[] name;
            break;
        case searchNameContact:
            cout << "enter phone: " << endl;
            number = input();
            cout << "name: " << nameSearch(number, book) << "\n";

            delete[] number;
            break;
        case print:
            saveBook(book);
            cout << "your phonebook saved \n";

            break;

        default:
            cout << "unknown command" << endl;
        }
        cout << "enter operation: \n";
        cin >> operation;
        cin.ignore();
    }

    deletePhoneBook(book);
    return 0;
}
