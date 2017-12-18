#pragma once

struct PhoneBook;

PhoneBook *createPhonebook();
void exit();
void add(char* name, char* number, PhoneBook *book);
void nameSearch(char* number, PhoneBook *book);
void numberSearch(char* name, PhoneBook *book);
void upload(PhoneBook *book);
void output(PhoneBook *book);
