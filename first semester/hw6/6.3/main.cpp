#include <iostream>
#include <fstream>
#include "phonebook.h"
#include <string.h>
#include "output.h"

using namespace std;

int main()
{
    PhoneBook *book = createPhoneBook();
    menu();
    enum  Command {exit, add, searchNumber, searchName, print};
    int operation = 0;
    cin >> operation;

    while (operation)
    {
        switch (operation)
        {
        case exit:
            break;
        case add:
            addContact(book);
            break;
        case searchNumber:
            numberSearch(book);
            break;
        case searchName:
            nameSearch(book);
            break;
        case print:
            printToFile(book);
            break;
        }
        cin >> operation;
    }

    deletePhoneBook(book);
    return 0;
}
