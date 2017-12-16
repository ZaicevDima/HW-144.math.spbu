#pragma once;
#include "stack.h"

bool isOperator(char k);
int prior (char k);
void conversionToPostfix(char* simbol, char* result, int amount, int &amountSpaces);
bool isDigit(char simbol);
bool isSpace(char simbol);
int numeral(char simbol);
int action(char simbol, int number1, int number2);
void printResult(char* simbol);
