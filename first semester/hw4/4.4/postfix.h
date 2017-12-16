#pragma once
#include "stack.h"

bool isDigit(char symbol);
bool isSpace(char symbol);
int numeral(char symbol);
int action(char symbol, int number1, int number2);
void printResult(char* symbols);
