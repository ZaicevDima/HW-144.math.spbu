#pragma once;
#include <iostream>

const int maxLength = sizeof(int) * 8 - 1;

void printBinaryTranslation(bool* bytes);
bool* binaryTranslation(int number);
bool* sum(bool* number1,bool* number2);
void printToDirectCode(bool* bytes);
int inDecimalSystem(bool* bytes);
