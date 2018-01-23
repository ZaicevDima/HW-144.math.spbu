#pragma once

#include "phonebook.h"

void menu();
void addContact(PhoneBook *book);
void numberSearch(PhoneBook *book);
void nameSearch(PhoneBook *book);
void printToFile(PhoneBook *book);

