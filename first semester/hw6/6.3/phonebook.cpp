#include <iostream>
#include "phonebook.h"
#include <fstream>
using namespace std;

struct PhoneBookElement
{
    char* name;
    char* number;
};

struct PhoneBook
{
    PhoneBookElement *phonebook;
    int previousIndex;
    int size;
};

PhoneBook *createPhonebook()
{
    PhoneBookElement* array = new PhoneBookElement[100];
    PhoneBook *newBook = new PhoneBook{array, -1, 0};
    return newBook;
}

void add(char* name, char* number, PhoneBook *book)
{
    int newIndex = ++book->previousIndex;
    book->phonebook[newIndex].name = name;
    book->phonebook[newIndex].number = number;
    (book->size)++;

}

void upload(PhoneBook *book)
{
    ofstream fout;
    fout.open("book.txt");
    if (!fout.good())
    {
        cout << "error, file not opened";
        return;
    }
    for (int i = 0; i <= book->previousIndex; i++)
        fout << book->phonebook->name << ' ' << book->phonebook->number;
    fout.close();
}

void nameSearch(char* number, PhoneBook *book)
{
    for (int i = 0; i <= book->size; i++)
        if (number == book->phonebook[i].number)
        {
            cout <<"name of number " << book->phonebook[i].name << "\n";
            break;
        }
}

void numberSearch(char* name, PhoneBook *book)
{
    for (int i = 0; i <= book->previousIndex; i++)
        if (name == book->phonebook[i].name)
        {
            cout <<"number of name " << book->phonebook[i].number << "\n";
            break;
        }

}

void output(PhoneBook *book)
{
    int i = 0;
    while (book->size > 0)
    {
        cout << book->phonebook[i].name <<' '<<book->phonebook[i].number <<"\n";
        i++;
    }
}
