#pragma once
#include <iostream>

const int maxLength = sizeof(int) * 8 - 1;

void printBinaryTranslation(int* bytes);
int* binaryTranslation(int number);
int* sum(int* number1,int* number2);
void toDirectCode(int *bytes);
void printToDirectCode(int* bytes);
int inDecimalSystem(int* bytes);
