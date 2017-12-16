#pragma once
#include "stack.h"

bool isOperator(char k);
int priority(char k);
void conversionToPostfix(char* symbols, char* result, int amount, int &amountSpaces);
bool isDigit(char symbol);
bool isSpace(char symbol);
int action(char symbol);
int action(char symbol, int number1, int number2);
void printResult(char* symbols);
