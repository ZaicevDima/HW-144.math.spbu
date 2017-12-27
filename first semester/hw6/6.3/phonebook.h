#pragma once

struct PhoneBookElement;
struct PhoneBook;

PhoneBook* createPhoneBook();
PhoneBookElement *createNewElement(char* name, long long number, PhoneBookElement *next);

void add(char* name, long long number, PhoneBook *book);
long long numberSearch(char* name, PhoneBook *book);
char *nameSearch(long long value, PhoneBook *book);

bool isEmpty(PhoneBook *book);
int size(PhoneBook *book);
void showBook(PhoneBook *book);
void saveBook(PhoneBook *book);

bool areNamesEqual(char* firstName, char* secondName);
void fillName(char* firstArray, char* secondArray);

void deletePhoneBook(PhoneBook *book);
