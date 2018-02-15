#include <iostream>
#include "list.h"

using namespace std;

struct ListElement
{
    String *value;
    int size;
    ListElement *next;
};

struct List
{
    int length;
    ListElement *head;
};

List *create()
{
    List *newList = new List;
    newList->length = 0;
    newList->head = nullptr;
    return newList;
}

bool isEmptyString(List *list)
{
    return list->head == nullptr;
}

void addInList(List *list, String *value)
{
    list->length++;

    ListElement *tempElement = list->head;
    while (tempElement != nullptr)
    {
        if (areEqual(tempElement->value, value))
        {
            (tempElement->size)++;
            deleteString(value);
            return;
        }
        tempElement = tempElement->next;
    }

    ListElement *newElement = new ListElement;
    newElement->value = value;
    newElement->size = 1;
    newElement->next = nullptr;

    if (isEmptyString(list))
    {
        list->head = newElement;
        return;
    }

    tempElement = list->head;
    while (tempElement->next != nullptr)
        tempElement = tempElement->next;

    tempElement->next = newElement;
    deleteString(value);
}

void deleteList(List *list)
{
    while (!isEmptyString(list))
    {
        deleteString(list->head->value);
        ListElement *tempElement = list->head;
        list->head = list->head->next;
        delete tempElement;
    }
    delete list;
}

void print(List *list)
{
    ListElement *temp = list->head;
    char *newWord = nullptr;
    while (temp != nullptr)
    {
        newWord = rawString(temp->value);
        cout << newWord << ' ' << temp->size << ' ';
        temp = temp->next;
        delete[] newWord;
    }
    cout << '\n';
}

int sizeList(List *list)
{
    return list->length;
}
