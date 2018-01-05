#pragma once
#include <fstream>

struct String
{
    char *data;
    int size;
};

String *subString(String *string, const int start, const int len);
String *createString(char *string);
String *cloneString(String *string);
String *inputString(std::istream &fin);

int lengthString(String *string);

bool isEmptyString(String *string);
bool areEqual(String *str1, String *str2);

char *rawString(String *string);
char getChar(String *string, int index);

void concate(String *&string, String *secondString);
void deleteString(String *string);
void printString(String *string, std::ostream &stream);
