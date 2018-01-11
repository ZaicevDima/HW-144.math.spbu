#include "phonebook.h"
#include <iostream>
#include <fstream>
#include <string.h>

using namespace std;

struct PhoneBookElement
{
    char* name = new char[1000];
    long long number;
    PhoneBookElement *next;
};

struct PhoneBook
{
    PhoneBookElement *phonebook;
    int size;

};

PhoneBook* createPhoneBook()
{
    PhoneBook *book = new PhoneBook;
    book->phonebook = nullptr;
    book->size = 0;
    return book;
}

PhoneBookElement *createNewElement(char *name, long long number, PhoneBookElement *next)
{
    PhoneBookElement *newElement = new PhoneBookElement;
    newElement->next = next;
    newElement->number = number;
    fillName(newElement->name, name);
    return newElement;
}

void deletePhoneBookElement(PhoneBookElement *element)
{
    if (element == nullptr)
        return;

    deletePhoneBookElement(element->next);
    delete[] element->name;
    delete element;
}

void deletePhoneBook(PhoneBook *book)
{
    if (isEmpty(book))
    {
        delete book;
        return;
    }

    while (book->phonebook->next->next != nullptr)
    {
        PhoneBookElement *toDelete = book->phonebook;
        book->phonebook = book->phonebook->next;
        deletePhoneBookElement(toDelete);
    }

    //delete book->phonebook;
    delete book;
}

void add(char* name, long long number, PhoneBook* book)
{
    if (isEmpty(book))
    {
        book->phonebook = createNewElement(name, number, nullptr);
        book->size = 1;
        return;
    }
    book->phonebook = createNewElement(name, number, book->phonebook);
    book->size++;
}

long long numberSearch(char *name, PhoneBook *book)
{
    if (isEmpty(book))
        return -1;

    PhoneBookElement *temp = book->phonebook;
    while ((temp->next != nullptr) && (strcmp(temp->name, name)))
    {
        temp = temp->next;
    }
    if ((temp->next == nullptr) && (!strcmp(temp->name, name)))
    {
        return temp->number;
    }
    if (strcmp(temp->name, name))
    {
        return -1;
    }

    long long number = temp->number;
    return number;
}

char *nameSearch(long long number, PhoneBook *book)
{
    if (isEmpty(book))
        return " ";

    PhoneBookElement *temp = book->phonebook;
    if ((temp->next == nullptr) && (temp->number == number))
    {
        return temp->name;
    }

    while ((temp->next != nullptr) && (temp->number != number))
    {
        temp = temp->next;
    }

    if (temp->number != number)
    {
        return " ";
    }

    return temp->name;
}

bool isEmpty(PhoneBook *book)
{
    return !(book->size);
}

void saveBook(PhoneBook *book)
{
    ofstream fout;
    fout.open("phonebook.txt", ios::out);
    PhoneBookElement *temp = book->phonebook;
    while (temp != nullptr)
    {
        fout << temp->name << " " << temp->number << endl;
        temp = temp->next;
    }
    fout.close();
}

void fillName(char *firstName, char *secondName)
{
    int secondLength = strlen(secondName);
    for (int i = 0; i < secondLength; i++)
    {
        firstName[i] = secondName[i];
    }
}

