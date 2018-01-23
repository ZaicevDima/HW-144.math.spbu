#include <iostream>
#include <fstream>
#include "phonebook.h"
#include <string.h>
#include "output.h"

using namespace std;

void downloadPhonebook(PhoneBook *book)
{
    ifstream fin("Phonebook.txt");
    if (!fin.good())
        return;
    int amountNumbers = 0;
    fin >> amountNumbers;
    for (int i = 0; i < amountNumbers; i++)
    {
        char *name = new char[256] {};
        char *number = new char[20] {};
        fin >> name >> number;
        add(name, toLongLong(number), book);

        delete [] name;
        delete [] number;
    }
    fin.close();
}

int main()
{
    PhoneBook *book = createPhoneBook();
    downloadPhonebook(book);
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
