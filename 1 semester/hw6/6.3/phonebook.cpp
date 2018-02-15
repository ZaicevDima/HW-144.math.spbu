#include "phonebook.h"
#include <iostream>
#include <fstream>
#include <string.h>

using namespace std;

struct PhoneBookElement
{
    char* name;
    char* number;
    PhoneBookElement *next;
};

struct PhoneBook
{
    PhoneBookElement *phonebook;
    int size;
};

PhoneBook* loadPhoneBook()
{
    PhoneBook *book = new PhoneBook;
    book->phonebook = nullptr;
    book->size = 0;

    ifstream fin("Phonebook.txt");
    if (fin.good())
    {
        int amountNumbers = 0;
        fin >> amountNumbers;
        for (int i = 0; i < amountNumbers; i++)
        {
            char *name = new char[256] {};
            char *number = new char[20] {};
            fin >> name >> number;
            add(name, number, book);
        }
        fin.close();
    }

    return book;
}

void deletePhoneBookElement(PhoneBookElement *element)
{
    if (element == nullptr)
        return;

    deletePhoneBookElement(element->next);
    delete [] element->name;
    delete [] element->number;
    delete element;
}

void deletePhoneBook(PhoneBook *book)
{
    deletePhoneBookElement(book->phonebook);
    delete book;
}

void add(char* name, char *number, PhoneBook* book)
{
    PhoneBookElement *newElement = new PhoneBookElement;
    newElement->name = name;
    newElement->number = number;
    newElement->next = book->phonebook;
    book->phonebook = newElement;
    book->size++;
}

bool isEqual(char *first, char *second)
{
    int index = 0;
    while ((first[index] != '\0') && (second[index] != '\0') && (first[index] == second[index]))
    {
        index++;
    }
    return first[index] == second[index];
}

char *numberSearch(char *name, PhoneBook *book)
{
    PhoneBookElement *tmp = book->phonebook;
    while ((tmp != nullptr) && (!isEqual(tmp->name, name)))
    {
        tmp = tmp->next;
    }
    if (tmp == nullptr)
        return "not fount \n";

    return tmp->number;
}

char *nameSearch(char *number, PhoneBook *book)
{
    PhoneBookElement *tmp = book->phonebook;
    while ((tmp != nullptr) && (!isEqual(tmp->number, number)))
    {
        tmp = tmp->next;
    }
    if (tmp == nullptr)
        return "not fount \n";

    return tmp->name;
}

bool isEmpty(PhoneBook *book)
{
    return !(book->size);
}

void saveBook(PhoneBook *book)
{
    ofstream fout;
    fout.open("Phonebook.txt");
    fout << book->size << "\n";
    PhoneBookElement *tmp = book->phonebook;

    while (tmp != nullptr)
    {
        fout << tmp->name << ' ' << tmp->number << "\n";
        tmp = tmp->next;
    }

    fout.close();
}

void printBook(PhoneBook *book)
{
    PhoneBookElement *temp = book->phonebook;
    while (temp != nullptr)
    {
        cout << temp->name << " " << temp->number << "\n";
        temp = temp->next;
    }
}
