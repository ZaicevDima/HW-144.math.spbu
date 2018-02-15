#pragma once

struct PhoneBookElement;
struct PhoneBook;

PhoneBook* loadPhoneBook();
PhoneBookElement *createNewElement(char* name, char* number, PhoneBookElement *next);

void add(char* name, char* number, PhoneBook *book);
char *numberSearch(char* name, PhoneBook *book);
char *nameSearch(char* number, PhoneBook *book);

bool isEmpty(PhoneBook *book);
int size(PhoneBook *book);
void saveBook(PhoneBook *book);
void printBook(PhoneBook *book);
long long toLongLong(char *recordNumber);

void deletePhoneBook(PhoneBook *book);

