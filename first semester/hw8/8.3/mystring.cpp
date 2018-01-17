#include <string.h>
#include <iostream>
#include "mystring.h"

String *subString(String *string, const int start, const int len) {
    if (string == nullptr)
        return nullptr;

    char *substr = new char[len + 1];
    memcpy(substr, string->string + start, len);
    substr[len] = '\0';

    String *result = createString(substr);
    delete[] substr;

    return result;
}

String *createString(char *string) {
    String *newString = new String();

    newString->length = strlen(string);
    newString->string = new char[newString->length + 1];
    strcpy(newString->string, string);

    return newString;
}

void concate(String *&string, String *secondString){
    String *newString = new String;
    newString->length = string->length + secondString->length;
    newString->string = new char[newString->length];

    for (int i = 0; i < string->length; i++)
        newString->string[i] = string->string[i];

    for (int j = 0; j < secondString->length; j++)
        newString->string[string->length + j] = secondString->string[j];

    deleteString(string);
    string = newString;
}

void deleteString(String *string) {
    if (string == nullptr)
        return;
    delete[] string->string;
    string->string = nullptr;
    string->length = 0;
    delete string;
}

int lengthString(String *string) {
    if (string != nullptr)
        return string->length;
    return 0;
}

bool isEmptyString(String *string) {
    return (lengthString(string) == 0);
}

bool areEqual(String *str1, String *str2) {
    if ((str1 != nullptr) && (str2 != nullptr))
        return (strcmp(str1->string, str2->string) == 0);
    return false;
}

char *rawString(String *string) {
    if (string == nullptr)
        return nullptr;
    char *newString = new char[string->length + 1];
    strcpy(newString, string->string);
    return newString;
}

String *cloneString(String *string) {
    String *newString = createString(string->string);
    return newString;
}

void printString(String *string, std::ostream &stream) {
    for (int i = 0; i < string->length; i++)
        stream << string->string[i];
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
    if ((0 <= index) && (index < string->length))
        return string->string[index];

    return '\0';
}
