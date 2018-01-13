#include <string.h>
#include <iostream>
#include "mystring.h"

String *subString(String *string, const int start, const int len) {
    if (string == nullptr)
        return nullptr;

    char *substr = new char[len + 1];
    memcpy(substr, string->data + start, len);
    substr[len] = '\0';

    String *result = createString(substr);
    delete[] substr;

    return result;
}

String *createString(char *string) {
    String *newString = new String();

    newString->size = strlen(string);
    newString->data = new char[newString->size + 1];
    strcpy(newString->data, string);

    return newString;
}

void concate(String *&string, String *secondString){
    String *newString = new String;
    newString->size = string->size + secondString->size;
    newString->data = new char[newString->size];

    for (int i = 0; i < string->size; i++)
        newString->data[i] = string->data[i];

    for (int j = 0; j < secondString->size; j++)
        newString->data[string->size + j] = secondString->data[j];

    deleteString(string);
    string = newString;
}

void deleteString(String *string) {
    if (string == nullptr)
        return;
    delete[] string->data;
    string->data = nullptr;
    string->size = 0;
    delete string;
}

int lengthString(String *string) {
    if (string != nullptr)
        return string->size;
    return 0;
}

bool isEmptyString(String *string) {
    return (lengthString(string) == 0);
}

bool areEqual(String *str1, String *str2) {
    if ((str1 != nullptr) && (str2 != nullptr))
        return (strcmp(str1->data, str2->data) == 0);
    return false;
}

char *rawString(String *string) {
    if (string == nullptr)
        return nullptr;
    char *newString = new char[string->size + 1];
    strcpy(newString, string->data);
    return newString;
}

String *cloneString(String *string) {
    String *newString = createString(string->data);
    return newString;
}

void printString(String *string, std::ostream &stream) {
    for (int i = 0; i < string->size; i++)
        stream << string->data[i];
}

String *inputString(std::istream &fin) {
    int const bufferSize = 256;
    char *buffer = new char[bufferSize];
    for (int i = 0; i < bufferSize; i++)
        buffer[i] = '\0';

    char emptyLine[1];
    emptyLine[0] = '\0';
    String *result = createString(emptyLine);

    char currentSymbol;
    currentSymbol = fin.get();

    int currentIndex = 0;
    while (currentSymbol != '\0' && currentSymbol != '\n' && !fin.eof())
    {
        if (currentIndex == bufferSize - 1)
        {
            buffer[currentIndex] = '\0';
            String *addition = createString(buffer);
            concate(result, addition);
            deleteString(addition);
            for (int j = 0; j < bufferSize; j++)
                buffer[j] = '\0';
            currentIndex = 0;
        }
        buffer[currentIndex] = currentSymbol;
        currentSymbol = fin.get();
        currentIndex++;
    }
    buffer[currentIndex] = '\0';
    String *addition = createString(buffer);
    concate(result, addition);
    deleteString(addition);

    delete[] buffer;
    return result;
}

char getChar(String *string, int index) {
    if ((0 <= index) && (index < string->size))
        return string->data[index];

    return '\0';
}
