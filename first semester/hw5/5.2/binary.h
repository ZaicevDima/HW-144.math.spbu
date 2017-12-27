#pragma once
#include <iostream>

const int maxLength = sizeof(int) * 8;

void printBinaryTranslation(int* bytes);
int* binaryTranslation(int number);
int* sum(int* number1,int* number2);
int inDecimalSystem(int* bits);
